package com.bitacademy.mysite.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitacademy.mysite.service.UserService;

@Controller("userApiController")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/existemail")
	public Map<String, Object> existEmail(String email){
		Boolean result = userService.existUser(email);
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		map.put("data", result);
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "안녕하세요";
	}
}
