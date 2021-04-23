package com.bitacademy.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.dto.JsonResult;
import com.bitacademy.mysite.service.UserService;

@Controller("userApiController")
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/existemail")
	public JsonResult existEmail(String email){
		Boolean result = userService.existUser(email);
		return JsonResult.success(result);
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "안녕하세요";
	}
}
