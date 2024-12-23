package com.elearning.entity.profile;


import com.elearning.entity.BaseEntity;
import com.elearning.entity.Country;
import com.elearning.entity.security.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member extends BaseEntity {


    @NotNull(message = "First name cannot be null")
    @NotBlank(message = "First name cannot be blank")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @NotBlank(message = "Last name cannot be blank")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @Size(max = 255, message = "Bio must not exceed 255 characters")
    private String bio;

    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    @Size(max = 100, message = "Workplace must not exceed 100 characters")
    private String workPlace;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_country", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_member_country"))
    @NotNull(message = "Country cannot be null")
    private Country country;

    private String imgProfileUrl;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mutual> mutualLists = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "id_user", nullable = false, columnDefinition = "varchar(36)")
    private User user;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GroupMembership> groupMemberships = new ArrayList<>();

}
