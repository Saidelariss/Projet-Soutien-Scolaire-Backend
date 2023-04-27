package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("FORM")
public class Formateur extends Utilisateur{
    @ManyToMany(mappedBy = "formateurs",fetch = FetchType.EAGER)
    private List<Competence> competences = new ArrayList<Competence>();

    @OneToMany(mappedBy = "formateur")
    private List<Validation> validations = new ArrayList<Validation>();

    public List<Competence> getCompetences() {
        return competences;
    }

    public List<Validation> getValidations() {
        return validations;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public void setValidations(List<Validation> validations) {
        this.validations = validations;
    }
}
