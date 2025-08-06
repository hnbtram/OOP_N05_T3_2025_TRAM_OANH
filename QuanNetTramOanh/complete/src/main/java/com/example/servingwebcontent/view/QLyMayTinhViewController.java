package com.example.servingwebcontent.view;  // Sửa package cho khớp với vị trí file

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QLyMayTinhViewController {
    
    @GetMapping("/quan-ly-may")
    public String manageComputers(
            @RequestParam(required = false) String status,
            Model model) {
        
        model.addAttribute("filterStatus", status != null ? status : "all");
        // Thêm logic lấy danh sách máy từ service
        return "computer-management";
    }
}