package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
 @AllArgsConstructor @NoArgsConstructor

public class Post {
    @Id @Column(name = "Post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    @Column(columnDefinition = "TEXT")
    private String contenu;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datePublication;

    @ManyToOne
    private Apprenti apprenti;

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<Validation> validations = new ArrayList<>();


    @ManyToOne(cascade=CascadeType.ALL)
    private Competence competence;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public Apprenti getApprenti() {
        return apprenti;
    }

    public List<Validation> getValidations() {
        return validations;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public void setApprenti(Apprenti apprenti) {
        this.apprenti = apprenti;
    }

    public void setValidations(List<Validation> validations) {
        this.validations = validations;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }
}
