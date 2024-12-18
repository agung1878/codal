package com.elearning.repository;

import com.elearning.entity.profile.Member;
import com.elearning.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInterface extends JpaRepository<Member, String> {
}
