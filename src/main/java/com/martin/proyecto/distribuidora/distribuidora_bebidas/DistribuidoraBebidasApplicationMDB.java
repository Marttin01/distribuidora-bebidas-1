package com.martin.proyecto.distribuidora.distribuidora_bebidas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication (exclude = {HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class DistribuidoraBebidasApplicationMDB {

	public static void main(String[] args) {
		SpringApplication.run(DistribuidoraBebidasApplicationMDB.class, args);
	}

}
