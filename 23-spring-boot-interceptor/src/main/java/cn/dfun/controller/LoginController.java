package cn.dfun.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
	@RequestMapping("/login")
	public Map<String, Object> login() {
		System.out.println("进入login方法");
		return null;
	}
}
