package com.elearning.repository;

import com.elearning.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInterface extends JpaRepository<User, String> {
}
