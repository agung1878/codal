package com.elearning.repository;

import com.elearning.entity.security.User;
import com.elearning.entity.security.UserPassword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPasswordInterface extends JpaRepository<UserPassword, String> {
}
