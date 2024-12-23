package com.elearning.repository;

import com.elearning.entity.profile.Mutual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutualRepository extends JpaRepository<Mutual, String> {
}
