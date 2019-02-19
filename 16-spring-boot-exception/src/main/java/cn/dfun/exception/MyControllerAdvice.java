package cn.dfun.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {
	/**
	 * 通用异常
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = java.lang.Exception.class)
	public Map<String, Object> myException(Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 500);
		map.put("msg", "系统错误!");
		return map;
	}
	/**
	 * 处理特定异常
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = java.lang.NullPointerException.class)
	public Map<String, Object> myException2(Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 501);
		map.put("msg", "空指针!");
		return map;
	}
	/**
	 * 处理自定义异常
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = cn.dfun.exception.MyException.class)
	public Map<String, Object> myException3(Exception e) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 500);
		map.put("msg", e.getMessage());
		return map;
	}
}
