package com.martin.proyecto.distribuidora.distribuidora_bebidas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Profile("jpa")
// @ConditionalOnProperty(name = "spring.datasource.url")
@EnableJpaRepositories(basePackages = "com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories")
public class JpaConfig {
    
}
