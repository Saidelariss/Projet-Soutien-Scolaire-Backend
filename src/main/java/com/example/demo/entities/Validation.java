package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@AllArgsConstructor
@NoArgsConstructor

public class Validation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean formateurAccepte;
    private Boolean apprentiAccepte;
    @ManyToOne
    private Formateur formateur;

    @ManyToOne
    private Post post;


    public void setId(Long id) {
        this.id = id;
    }

    public void setFormateurAccepte(Boolean formateurAccepte) {
        this.formateurAccepte = formateurAccepte;
    }

    public void setApprentiAccepte(Boolean apprentiAccepte) {
        this.apprentiAccepte = apprentiAccepte;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public Boolean getFormateurAccepte() {
        return formateurAccepte;
    }

    public Boolean getApprentiAccepte() {
        return apprentiAccepte;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public Post getPost() {
        return post;
    }

}
