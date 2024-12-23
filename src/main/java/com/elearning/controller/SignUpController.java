package com.elearning.controller;


import com.elearning.dto.RegisterDto;
import com.elearning.exceptions.CodalCustomException;
import com.elearning.service.UserServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class SignUpController {

    @Autowired
    private UserServices authServices;

    @GetMapping("/sign_up")
    public String sign_up(Model model) {

        model.addAttribute("countries", authServices.getCountryList());
        model.addAttribute("registerDto", new RegisterDto());

        return "signup";
    }


    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute RegisterDto registerDto, RedirectAttributes redirectAttributes) {
        try {
            authServices.register(registerDto);

            redirectAttributes.addFlashAttribute("successMessage", "Registration successful! Please log in.");
            return "redirect:/login";
        } catch (CodalCustomException e) {
            log.error("Registration error: {}", e.getMessage(), e);

            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/sign_up";
        } catch (Exception e) {
            log.error("Unexpected error during registration", e);

            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred. Please try again.");
            return "redirect:/sign_up";
        }
    }

}
