package com.elearning.entity.profile;

import com.elearning.constants.MutualStatus;
import com.elearning.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Mutual extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mutual_member_id", nullable = false)
    private Member mutualMember;

    @Enumerated(EnumType.STRING)
    private MutualStatus relationshipStatus;

}
