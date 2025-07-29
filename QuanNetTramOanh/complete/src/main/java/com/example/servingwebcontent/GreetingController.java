package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.servingwebcontent.Model.KhachHang;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		System.out.println("Greeting request received with name: " + name);
		return "greeting";
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(name="hovaten", required=false, defaultValue="Ho va ten") String hovaten, Model model) {
		model.addAttribute("name", hovaten);
		System.out.println("Hello request received with name: " + hovaten);
		return "greeting";
	}
	@GetMapping("/netOanhTram")
	public String netOanhTram(@RequestParam(name="hovaten", required=false, defaultValue="World") String hovaten, Model model) {
		model.addAttribute("hovaten", hovaten);
		System.out.println("Index request received with name: " + hovaten);
		return "netOanhTram";

}
	@GetMapping("/khachHang")
	public String khachHang(@RequestParam(name="maKhachHang", required=false, defaultValue="KH001") String maKhachHang, Model model) {
		// Simulate fetching customer data
		KhachHang kh = new KhachHang(maKhachHang, "Nguyen Van A", "0123456789");
		model.addAttribute("khachHang", kh);
		System.out.println("Customer request received with ID: " + maKhachHang);
		return "khachHang";
	}
}
