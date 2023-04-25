package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("FORM")
public class Formateur extends Utilisateur{
    @ManyToMany(mappedBy = "formateurs")
    private List<Competence> competences = new ArrayList<Competence>();

    @OneToMany(mappedBy = "formateur")
    private List<Validation> validations = new ArrayList<Validation>();
}
