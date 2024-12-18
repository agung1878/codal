package com.elearning.repository;

import com.elearning.entity.security.Role;
import com.elearning.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleInterface extends JpaRepository<Role, String> {
}
