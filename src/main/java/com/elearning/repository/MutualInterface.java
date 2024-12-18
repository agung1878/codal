package com.elearning.repository;

import com.elearning.entity.profile.Mutual;
import com.elearning.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutualInterface extends JpaRepository<Mutual, String> {
}
