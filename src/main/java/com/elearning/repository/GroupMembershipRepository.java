package com.elearning.repository;

import com.elearning.entity.profile.GroupMembership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, String> {
}
