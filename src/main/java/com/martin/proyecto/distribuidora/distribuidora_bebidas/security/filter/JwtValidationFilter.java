package com.martin.proyecto.distribuidora.distribuidora_bebidas.security.filter;

import static com.martin.proyecto.distribuidora.distribuidora_bebidas.security.TokenJwtConfig.CONTENT_TYPE;
import static com.martin.proyecto.distribuidora.distribuidora_bebidas.security.TokenJwtConfig.HEADER_AUTHORIZATION;
import static com.martin.proyecto.distribuidora.distribuidora_bebidas.security.TokenJwtConfig.PREFIX_TOKEN;
import static com.martin.proyecto.distribuidora.distribuidora_bebidas.security.TokenJwtConfig.SECRET_KEY;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtValidationFilter extends BasicAuthenticationFilter {

    public JwtValidationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {

        String header = request.getHeader(HEADER_AUTHORIZATION);

        if(header == null || !header.startsWith(PREFIX_TOKEN)){
            chain.doFilter(request, response);
            return;
        } 

        String token = header.replace(PREFIX_TOKEN, "");

        
        try {
            Claims claims = Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload();

            String username = claims.getSubject();
            List<GrantedAuthority> authorithies = Arrays.asList(new SimpleGrantedAuthority(claims.get("authority").toString()));
            

            System.out.println(claims);

            // Collection<? extends GrantedAuthority> authorities = Arrays.asList(new ObjectMapper().addMixIn(SimpleGrantedAuthority.class, SimpleGranthedAuthorityJsonCreator.class).readValue(authority.toString().getBytes(),SimpleGrantedAuthority.class));



            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, null, authorithies );
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            chain.doFilter(request, response);
        } catch (JwtException e) {
            Map<String,String> body = new HashMap<>();
            body.put("error", e.getMessage());
            body.put("message", "El token es invalido");

            response.setStatus(401);
            response.setContentType(CONTENT_TYPE);
            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        }


    }

}
