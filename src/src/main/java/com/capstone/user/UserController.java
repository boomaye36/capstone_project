package com.capstone.user;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.capstone.user.bo.KakaoService;
import com.capstone.user.bo.UserBO;
import com.capstone.user.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private KakaoService kakaoService;
	
	@Autowired 
	private UserBO userBO;

	@RequestMapping("/user/main")
	public String main() {
		return "user/main";
	}
	@GetMapping("/user/sign_in")
	public String signIn() {
		return "user/terms";
	}
	@GetMapping("/user/sign_up")
	public String signUp(){
		return "user/sign_up";
	}
	// 카카오로 로그인 접속
		@RequestMapping(value = "/oauth/kakao", method = RequestMethod.GET)
		public String kakaoLogin(@RequestParam(value = "code", required = false) String code, HttpSession session,
				Model model, @RequestParam Map<String, String> params, RedirectAttributes redirect) throws Exception {
			// String result = null;
			String access_Token = kakaoService.getAccessToken(code);
			HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);

			// 아이디
			Object id = (Object) userInfo.get("id");
			String loginid = String.valueOf(id);
			// 닉네임
			String userNickName = (String) userInfo.get("nickname");
			model.addAttribute("nickname", userNickName);
			model.addAttribute("loginid", loginid);
//			if (userBO.isExistUser(loginid)) {
//				User loginUser = userBO.getUserByLoginId(loginid);
//				session.setAttribute("loginUser", loginUser);
//
//				return "/main/main";
//			} else {
				return "/user/kakaosignup";
		//	}
		}
}
