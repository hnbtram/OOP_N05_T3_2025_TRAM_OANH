package com.example.servingwebcontent.view;  // Sửa package cho khớp với vị trí file

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("totalComputers", 50);
        model.addAttribute("availableComputers", 35);
        model.addAttribute("revenueToday", "15,000,000 VND");
        return "home";
    }
}