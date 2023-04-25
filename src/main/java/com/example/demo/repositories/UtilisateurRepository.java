package com.example.demo.repositories;

import com.example.demo.entities.Apprenti;
import com.example.demo.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

}
