package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
 @AllArgsConstructor @NoArgsConstructor
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nom;


    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "formateur_competence",
            joinColumns = @JoinColumn(name = "competence_id"),
            inverseJoinColumns = @JoinColumn(name = "formateur_id"))
    private List<Formateur> formateurs = new ArrayList<Formateur>();


    @JsonIgnore
    @OneToMany(mappedBy = "competence")
    private List<Post> posts = new ArrayList<Post>();

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Formateur> getFormateurs() {
        return formateurs;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFormateurs(List<Formateur> formateurs) {
        this.formateurs = formateurs;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
