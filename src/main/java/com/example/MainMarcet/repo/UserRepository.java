package com.example.MainMarcet.repo;

import com.example.MainMarcet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail( String email);
}
