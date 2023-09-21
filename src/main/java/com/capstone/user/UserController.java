package com.capstone.user;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/main")
	public String main() {
		return "user/main";
	}
	@GetMapping("/sign_in")
	public String signIn() {
		return "user/terms";
	}
	@GetMapping("/sign_up")
	public String signUp(){
		return "user/sign_up";
	}
	
}
