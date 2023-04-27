package com.example.demo.web;


import com.example.demo.entities.*;
import com.example.demo.repositories.CompetenceRepository;
import com.example.demo.services.PostService;
import com.example.demo.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestApiController {

    UserService userService;
    PostService postService;
    CompetenceRepository competenceRepository;


    @PostMapping(path="/apprenti")
    public Apprenti saveApprenti(@RequestBody Apprenti apprenti){
        return userService.saveApprenti(apprenti);
    }

    @PostMapping(path="/formateur")
    public Formateur saveFormateur(@RequestBody Formateur formateur){

        return userService.saveFormateur(formateur);
    }

    @GetMapping(path="/login")
    public Utilisateur LoginUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password, HttpServletResponse response){
        Utilisateur utilisateur=userService.UserAuthentication(email,password);
        Cookie cookie = new Cookie("email", email);
        response.addCookie(cookie);
        return utilisateur;
    }

    @PostMapping(path="/apprenti/post")
    public Post savePost(@RequestBody Post post,HttpServletRequest request){
        String competenceName = post.getCompetence().getNom();

        Competence competence = competenceRepository.findByNom(competenceName);

        String email = getCookie(request);

        return postService.savePost(post,email,competence);
    }

    @GetMapping(path="/apprenti/posts")
    public List<Post> getAllPostsByApprenti(HttpServletRequest request){
        String email = getCookie(request);
        return postService.getAllPostsByApprenti(email);

    }


    @GetMapping(path="/formateur/posts")
    public List<Post> getAllPostsByFormateur(HttpServletRequest request){
        String email = getCookie(request);
        return postService.getAllPostsByFormateur(email);

    }
    private String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String email = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email")) {
                    email = cookie.getValue();
                    break;
                }
            }
        }
        return email;
    }



}
