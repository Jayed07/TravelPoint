package com.travelpoint.web;

import com.travelpoint.repository.RegionRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    private final RegionRepository regionRepository;

    public HomeController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("regions", regionRepository.findAll());

        return "home";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/users/login";
    }
}
