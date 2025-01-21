package com.martin.proyecto.distribuidora.distribuidora_bebidas.security.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Usuario;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.martin.proyecto.distribuidora.distribuidora_bebidas.security.TokenJwtConfig.*;//LA CONFIGURACION DEL TOKEN ESTA TODO EN ESA CLASE

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        
        Usuario user = null;
        String username = null;
        String password = null;

        try {
            user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            username = user.getUsername();
            password = user.getPassword();
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,Authentication authResult) throws IOException, ServletException {

        User user = (User) authResult.getPrincipal();
        String username = user.getUsername();
        // Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
        SimpleGrantedAuthority rol = (SimpleGrantedAuthority) authResult.getAuthorities().stream().findFirst().orElseThrow(() -> new RuntimeException("No se encontro rol o authority alguno"));

        Map<String,Object> claims = new HashMap<>();
        claims.put("authority",rol);
        claims.put("username",username);

        String token = Jwts.builder().subject(username).claims(claims).expiration(new Date(System.currentTimeMillis() + 3600000)).issuedAt(new Date()).signWith(SECRET_KEY).compact();
        
        response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);

        Map<String,Object> json = new HashMap<>();
        json.put("token", token);
        json.put("username", username);
        json.put("message", String.format("Hola %s iniciaste sesion con exito", username));

        response.getWriter().write(new ObjectMapper().writeValueAsString(json));
        response.setContentType(CONTENT_TYPE);
        response.setStatus(200);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        Map<String,String> json = new HashMap<>();
        json.put("mensaje","Error en la autenticacion, username o password incorrectos");
        json.put("error", failed.getMessage());

        response.getWriter().write(new ObjectMapper().writeValueAsString(json));
        response.setStatus(401);
        response.setContentType(CONTENT_TYPE);
    }

}
