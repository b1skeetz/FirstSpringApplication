package damir.kad.medicine.controller;

import damir.kad.medicine.model.User;
import damir.kad.medicine.model.enums.UserRole;
import damir.kad.medicine.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/registration")
public class RegistrationController {
    private final UserRepository userRepository;

    @GetMapping
    private String registrationPage(Model model){
        model.addAttribute("user", new User());
        return "auth/registration_page";
    }

    @PostMapping
    private String registration(@ModelAttribute(name = "user") User user){
        user.setRole(UserRole.USER);
        userRepository.save(user);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getUsername(), user.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/medicines";
    }
}