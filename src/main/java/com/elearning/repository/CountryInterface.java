package com.elearning.repository;

import com.elearning.entity.Country;
import com.elearning.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryInterface extends JpaRepository<Country, String> {
}
