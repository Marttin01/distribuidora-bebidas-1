package com.martin.proyecto.distribuidora.distribuidora_bebidas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.security.filter.JwtAuthenticationFilter;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.security.filter.JwtValidationFilter;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    AuthenticationManager authenticationManager() throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests((authz) -> authz
        //API
        .requestMatchers(HttpMethod.GET,"/").permitAll()
        .requestMatchers(HttpMethod.POST,"/").permitAll()
        .requestMatchers(HttpMethod.PUT,"/").permitAll()
        .requestMatchers(HttpMethod.DELETE,"/").permitAll()
        .requestMatchers(HttpMethod.GET,"/{path}").permitAll()
        .requestMatchers(HttpMethod.POST,"/{path}").permitAll()
        .requestMatchers(HttpMethod.PUT,"/{path}").permitAll()
        .requestMatchers(HttpMethod.DELETE,"/{path}").permitAll()
        //USUARIOS
        .requestMatchers(HttpMethod.GET,"/api/usuarios").permitAll()
        .requestMatchers(HttpMethod.POST,"/api/usuarios/register").permitAll()
        .requestMatchers(HttpMethod.DELETE,"/api/usuarios").hasAnyAuthority("admin")
        .requestMatchers(HttpMethod.PUT,"/api/usuarios").hasAnyAuthority("admin")
        //PRODUCTOS
        .requestMatchers(HttpMethod.GET,"/api/productos").permitAll()
        .requestMatchers(HttpMethod.POST,"/api/productos")./*hasAnyAuthority("admin")*/permitAll() /*HABILITADO PARA PRUEBAS*/ 
        .requestMatchers(HttpMethod.GET,"api/productos/{id}"). permitAll() /*HABILITADO PARA PRUEBAS*/
        .requestMatchers(HttpMethod.PUT,"api/productos/{id}"). permitAll() /*HABILITADO PARA PRUEBAS*/
        .requestMatchers(HttpMethod.DELETE,"api/productos/{id}").permitAll()/*HABILITADO PARA PRUEBAS*/
        .anyRequest()
        .authenticated()
        )
        .addFilter(new JwtAuthenticationFilter(authenticationManager()))
        .addFilter(new JwtValidationFilter(authenticationManager()))
        .csrf((config) -> config.disable())
        .sessionManagement((management) -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }

}
