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
            Utilisateur formateur =(Formateur) u.findByEmail("formateur@ehtp.ac.ma").orElse(null);
            List<Competence> competences = ((Formateur) formateur).getCompetences();
            for(Competence competence : competences){
                System.out.println("----competence "+competence.getNom());
            }

            };
        };



}
