package com.elearning.repository;

import com.elearning.entity.profile.GroupMembership;
import com.elearning.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupMembershipInterface extends JpaRepository<GroupMembership, String> {
}
