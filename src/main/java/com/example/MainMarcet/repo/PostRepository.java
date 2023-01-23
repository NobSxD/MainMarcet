package com.example.MainMarcet.repo;

import com.example.MainMarcet.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

}
