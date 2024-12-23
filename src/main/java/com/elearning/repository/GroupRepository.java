package com.elearning.repository;

import com.elearning.entity.profile.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupMember, String> {
}
