package com.elearning.repository;

import com.elearning.entity.profile.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
