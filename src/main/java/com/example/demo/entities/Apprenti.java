package com.example.demo.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("APPR")
public class Apprenti extends Utilisateur{
    @OneToMany(mappedBy = "apprenti")
    List<Post> posts = new ArrayList<Post>();


}
