package com.example.demo.services;

import com.example.demo.entities.Apprenti;
import com.example.demo.entities.Competence;
import com.example.demo.entities.Formateur;
import com.example.demo.entities.Utilisateur;
import com.example.demo.repositories.CompetenceRepository;
import com.example.demo.repositories.UtilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data @AllArgsConstructor

public class UserService {
    private UtilisateurRepository utilisateurRepository;
    private CompetenceRepository competenceRepository;
    public Utilisateur UserAuthentication(String email,String password){
        System.out.println("email : "+email);
     //   if(!(email.contains("ehtp.ac.ma"))) throw new RuntimeException("Vous n'êtes pas authorisé");
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);

        if(!(utilisateur.getPassword().equals(password))) throw new RuntimeException("les identifiants sont erronées");
        System.out.println("email : "+email);
        return utilisateur;

    }

    public Apprenti saveApprenti(Apprenti apprenti){

         return utilisateurRepository.save(apprenti);

    }

    public Formateur saveFormateur(Formateur formateur){
        String[] competencesNames = new String[formateur.getCompetences().size()];
        for(int i=0;i<formateur.getCompetences().size();i++){
            competencesNames[i]=formateur.getCompetences().get(i).getNom();
            System.out.println("-------------------");
            System.out.println("competence "+competencesNames[i]);
        }
        List<Competence> competences = new ArrayList<Competence>();
        for(int i=0;i<competencesNames.length;i++){
            Competence c = competenceRepository.findByNom(competencesNames[i]);
            competences.add(c);
        }
        formateur.setCompetences(competences);

        for (Competence competence : formateur.getCompetences()){
            competence.getFormateurs().add(formateur);
            System.out.println("$$$$$$$$$$$$$$competence "+competence.getNom());
        }
        Formateur savedFormateur = utilisateurRepository.save(formateur);
        return savedFormateur;
    }

}
