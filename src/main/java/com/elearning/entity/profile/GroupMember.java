package com.elearning.entity.profile;


import com.elearning.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class GroupMember extends BaseEntity {

    @NotNull(message = "Group name cannot be null")
    @NotBlank(message = "Group name cannot be blank")
    @Size(min = 2, max = 50, message = "Group name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Group Description cannot be null")
    @NotBlank(message = "Group Description cannot be blank")
    @Size(min = 2, max = 255, message = "Group description must be between 2 and 50 characters")
    private String description;

    @OneToMany(mappedBy = "groupMember", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupMembership> memberships = new ArrayList<>();

}
