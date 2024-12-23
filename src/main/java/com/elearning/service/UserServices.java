package com.elearning.service;


import com.elearning.dto.RegisterDto;
import com.elearning.entity.Country;
import com.elearning.entity.profile.Member;
import com.elearning.entity.security.Role;
import com.elearning.entity.security.User;
import com.elearning.entity.security.UserPassword;
import com.elearning.exceptions.CodalCustomException;
import com.elearning.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserInterface userInterface;

    @Autowired
    private RoleRepository roleInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserPasswordRepository userPasswordInterface;
    @Autowired
    private CountryRepository countryInterface;

    @Autowired
    private MemberRepository memberInterface;

    @Transactional
    public void register(RegisterDto registerDto) {

        if (usernameExist(registerDto.getUsername())) {
            throw CodalCustomException.usernameAlreadyExists("Username is already in use");
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPhone(registerDto.getPhoneNumber());

        Role role = roleInterface.findById("R002")
                .orElseThrow(() -> CodalCustomException.roleNotFound("Role not found!"));
        user.setRole(role);

        UserPassword userPassword = new UserPassword();
        userPassword.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        userPassword.setUser(user);

        Member member = new Member();
        member.setUser(user);
        member.setFirstName(registerDto.getFirstName());
        member.setLastName(registerDto.getLastName());

        Country country = countryInterface.findById(registerDto.getIdCountry())
                .orElseThrow(() -> CodalCustomException.countryNotFound("Country not found!"));
        member.setCountry(country);

        userPasswordInterface.save(userPassword);
        memberInterface.save(member);

        userInterface.save(user);
    }



    public List<Country> getCountryList(){
        return countryInterface.findAll();
    }

    private boolean usernameExist(String username) {
        Optional<User> opUser = userInterface.findByUsername(username);
        return opUser.isPresent();
    }

}
