package com.example.demo.web;


import com.example.demo.entities.Apprenti;
import com.example.demo.entities.Competence;
import com.example.demo.entities.Post;
import com.example.demo.entities.Validation;
import com.example.demo.repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import  java.util.List;

@RestController
@AllArgsConstructor
public class PostControllerAPI {
    public final PostRepository postRepository;


    @GetMapping(path = "/postsApprenti")
    public List<Post> listPostByApprenti(Apprenti apprenti)
    {
        List<Post> listePosts = postRepository.findByApprenti(apprenti).orElse(null);
        return listePosts;

    }

    @GetMapping(path = "/savePost")
    public List<Post> savePost(String titre,String contenu, Apprenti apprenti,Competence competence)
    {
        Post poste = new Post(null,titre,contenu ,new Date(),apprenti,new ArrayList<Validation>(),competence);
        List<Post> listePosts = postRepository.findByApprenti(apprenti).orElse(null);
        return listePosts;

    }
    @GetMapping(path = "/postsCompetences")
    public List<Post> listPostByCompetence(Competence competence)
    {
        List<Post> listePosts = postRepository.findByCompetence(competence).orElse(null);
        return listePosts;

    }
}
