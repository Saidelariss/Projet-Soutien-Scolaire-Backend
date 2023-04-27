package com.example.demo.web;


import com.example.demo.entities.*;
import com.example.demo.repositories.CompetenceRepository;
import com.example.demo.repositories.UtilisateurRepository;
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

   // UtilisateurRepository utilisateurRepository;

    @PostMapping(path="/apprenti")
    public Apprenti saveApprenti(@RequestBody Apprenti apprenti){
        return (Apprenti) userService.saveApprenti(apprenti);
    }

    @PostMapping(path="/formateur")
    public Formateur saveFormateur(@RequestBody Formateur formateur){


        Formateur savedFormateur = userService.saveFormateur(formateur);
        return  savedFormateur;




      // return (Formateur) userService.saveFormateur(formateur);
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

        Post savedPost = postService.savePost(post,email,competence);
        return savedPost;
    }

    @GetMapping(path="/apprenti/posts")
    public List<Post> getAllPostsByApprenti(HttpServletRequest request){
        String email = getCookie(request);
        List<Post> posts = postService.getAllPostsByApprenti(email);
        return posts;

    }


    @GetMapping(path="/formateur/posts")
    public List<Post> getAllPostsByFormateur(HttpServletRequest request){
        String email = getCookie(request);
        List<Post> posts = postService.getAllPostsByFormateur(email);
        return posts;

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






/*

    @GetMapping(path = "/posts")
    public List<Post> getPosts(){
    return postRepository.findAll();
}



    @GetMapping("/user")
    public String getCurrentUser(HttpServletRequest request) throws Exception {
        // Récupérer l'ID de session à partir du cookie de session dans la requête
        String sessionId = request.getSession().getId();
        System.out.println("numéro de la session" +sessionId);
        HttpSession httpSession =  request.getSession();
        String username = (String) httpSession.getAttribute("username");
        System.out.println("username : " +username);
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("username security : " +user);
        return username;


        // Récupérer la session correspondante à partir du HttpSession
        //HttpSession session = request.getSession(false);

        /*if (session != null && session.getAttribute("username") != null) {
            // Si l'utilisateur est authentifié, récupérer les données de l'utilisateur à partir de la session
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");

            return new User(username, role,null);
        } else {
            // Si l'utilisateur n'est pas authentifié, renvoyer une erreur ou une réponse appropriée
            throw new Exception("L'utilisateur n'est pas authentifié.");

    }
}*/
}
