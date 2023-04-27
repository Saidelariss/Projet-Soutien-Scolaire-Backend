package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.repositories.CompetenceRepository;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UtilisateurRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Data
@AllArgsConstructor

public class PostService {
    PostRepository postRepository;
    UtilisateurRepository utilisateurRepository;

    CompetenceRepository competenceRepository;
    public Post savePost(Post post, String email,Competence competence){


        Apprenti apprenti =(Apprenti) utilisateurRepository.findByEmail(email);

        post.setApprenti(apprenti);
        post.setDatePublication(new Date());
        post.setCompetence(competence);
        Post savedPost =  postRepository.save(post);


        return savedPost;
    }
    public List<Post> getAllPostsByApprenti(String email){
        Apprenti apprenti= (Apprenti) utilisateurRepository.findByEmail(email);
        return apprenti.getPosts();
    }

    public List<Post> getAllPostsByFormateur(String email) {
        Formateur formateur = (Formateur) utilisateurRepository.findByEmail(email);
        List<Competence> sesCompetences = formateur.getCompetences();
        List<Post> posts = new ArrayList<Post>();

        for (Competence competence : sesCompetences) {
            posts.addAll( competence.getPosts());
        }

        return posts;
    }

}
