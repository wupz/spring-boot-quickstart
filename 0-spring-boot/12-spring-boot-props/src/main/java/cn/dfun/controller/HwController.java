package cn.dfun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HwController {
	@Value("${msg}")
	private String msg;
	
	@RequestMapping("/hello")
	public String hello() {
		return msg;
	}
}
