package cn.dfun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThyController {
	@RequestMapping("/show")
	public String show(Model model) {
		model.addAttribute("msg", "world");
	    return "index";
	}
}
