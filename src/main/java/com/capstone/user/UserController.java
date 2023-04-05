package com.capstone.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception
	{
		return "root page";
	}
	@RequestMapping("/main")
	public String main() {
		return "user/main";
	}
	@RequestMapping("/sign_in")
	public String signIn() {
		return "user/terms";
	}
	@RequestMapping("/sign_up")
	public String signUp(){
		return "user/sign_up";
	}
	
}
