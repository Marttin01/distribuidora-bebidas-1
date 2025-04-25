package com.martin.proyecto.distribuidora.distribuidora_bebidas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("mongo")
@EnableMongoRepositories(basePackages = "com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories")
public class MongoConfig {
    
}
