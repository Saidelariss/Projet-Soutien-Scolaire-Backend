package com.example.demo;

import com.example.demo.entities.Competence;
import com.example.demo.entities.Formateur;
import com.example.demo.entities.Utilisateur;
import com.example.demo.repositories.CompetenceRepository;
import com.example.demo.repositories.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
public class ProjetJavaUmlBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetJavaUmlBackendApplication.class, args);
	}

	//@Bean
	CommandLineRunner commandLineRunner(CompetenceRepository competenceRepository, UtilisateurRepository u){
		return args ->{
			Utilisateur formateur =(Formateur) u.findByEmail("formateur@ehtp.ac.ma");
			List<Competence> competences = ((Formateur) formateur).getCompetences();
			for(Competence competence : competences){
				System.out.println("----competence "+competence.getNom());
			}

			};
		};
	}
	//@Bean
	/*CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
		return args ->{
			jdbcUserDetailsManager.createUser(User.withUsername("user4").password(passwordEncoder().encode("1234")).roles("USER").build());

		jdbcUserDetailsManager.createUser(User.withUsername("user2").password(passwordEncoder().encode("1234")).roles("USER").build());

		jdbcUserDetailsManager.createUser(User.withUsername("user3").password(passwordEncoder().encode("1234")).roles("USER").build());
};
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

*/


