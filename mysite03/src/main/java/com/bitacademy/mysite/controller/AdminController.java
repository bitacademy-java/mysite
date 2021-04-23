package com.bitacademy.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.mysite.security.Auth;

@Auth(role="admin")
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping("")
	public String main() {
		return "admin/main";
	}

	@RequestMapping("/guestbook")
	public String guestbook() {
		return "admin/guestbook";
	}

	@RequestMapping("/board")
	public String board() {
		return "admin/board";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
	
	
}
