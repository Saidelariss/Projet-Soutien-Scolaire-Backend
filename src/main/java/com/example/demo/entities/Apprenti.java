package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
 @AllArgsConstructor @NoArgsConstructor
@DiscriminatorValue("APPR")
public class Apprenti extends Utilisateur{

    @OneToMany(mappedBy = "apprenti")
   @JsonIgnore
    private List<Post> posts = new ArrayList<Post>();

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
