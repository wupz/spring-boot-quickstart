package cn.dfun.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dfun.exception.MyException;

@Controller
public class HwController {
	@RequestMapping("/hello")
	@ResponseBody
	public Map<String, Object> hello() {
		Map<String, Object> map = new HashMap<String, Object>();
		int a = 1/0;
		return map;
	}
	@RequestMapping("/hello1")
	@ResponseBody
	public Map<String, Object> hello1() {
		Map<String, Object> map = new HashMap<String, Object>();
		String s = null;
		s.length();
		return map;
	}
	@RequestMapping("/hello2")
	@ResponseBody
	public Map<String, Object> hello2() {
		throw new MyException("自定义异常");
	}
}
