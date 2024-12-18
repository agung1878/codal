package com.elearning.entity.profile;


import com.elearning.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class GroupMembership extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "group_member_id", nullable = false)
    private GroupMember groupMember;

    private boolean isAdmin;

}
