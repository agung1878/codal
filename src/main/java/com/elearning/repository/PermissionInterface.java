package com.elearning.repository;

import com.elearning.entity.security.Permission;
import com.elearning.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionInterface extends JpaRepository<Permission, String> {
}
