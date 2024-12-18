package com.elearning.repository;

import com.elearning.entity.profile.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupInterface extends JpaRepository<GroupMember, String> {
}
