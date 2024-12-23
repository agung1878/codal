package com.elearning.repository;

import com.elearning.entity.security.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPasswordRepository extends JpaRepository<UserPassword, String> {
}
