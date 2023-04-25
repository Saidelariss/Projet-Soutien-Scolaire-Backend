package com.example.demo.repositories;

import com.example.demo.entities.Apprenti;
import com.example.demo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByApprenti(Apprenti apprenti);
}
