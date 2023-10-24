package com.capstone.user;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.common.SHA256;
import com.capstone.user.bo.UserBO;
import com.capstone.user.model.User;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserRestController {
@Autowired 
private UserBO userBO;
	


	//회원가입 (필수정보) insert
	@PostMapping("/user/user_insert")
	public Map<String, Object> addUser(User user, HttpSession session) throws NoSuchAlgorithmException {
		
		//회원 비밀번호가 null이 아닐 때 암호화시킴
		if (user.getPassword() != null) {

		//암호화
		SHA256 sha256 = new SHA256();
		String encryptPassword = sha256.encrypt(user.getPassword());
		//암호화 된 정보 셋팅
		user.setPassword(encryptPassword);
		}
		Map<String, Object> result = new HashMap<>();
		int row = userBO.addUser(user);
		User loginUser = userBO.getUserByLoginIdAndPassword(user);
		session.setAttribute("loginUser", loginUser);
		if ( row > 0 ) {
			result.put("code", 100);
		} else {
			result.put("code", 400);
		}
		return result;
	}
	
	//회원가입 id 중복확인 event
	@RequestMapping("/user/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(@RequestParam("loginid") String loginid) {
		Map<String, Object> result = new HashMap<>();
		int existRowCount = userBO.existingLoginId(loginid);
		if (existRowCount > 0) {
			result.put("result", true);
			result.put("code", 100);
		} else {
			result.put("errorMessege", false);
			result.put("code", 400);
		}
		return result;
	}
	
	
	//로그인 아이디 및 비밀번호 일치 event
	@PostMapping("/user/sign_in")
	public Map<String, Object> signIn(User user, HttpSession session) throws NoSuchAlgorithmException {
		
		//암호화
		SHA256 sha256 = new SHA256();
		String encryptPassword = sha256.encrypt(user.getPassword());
		//암호화 
		user.setPassword(encryptPassword);
		
		Map<String, Object> result = new HashMap<>();
		User loginUser = userBO.getUserByLoginIdAndPassword(user);
		if (loginUser != null) {
			session.setAttribute("loginUser", loginUser);
			result.put("code", 100);
		} else {
			result.put("code", 400);
		}
		
		return result;
	}
	
	
	
	
	//인증번호 보내기 event
	@PostMapping("/user/sendMessage")
	public Map<String, Object> sendSMS(@RequestParam("phoneNumber")String phoneNumber, HttpSession session) {
		String confirmNo = userBO.sendRandomMessage(phoneNumber);
		session.setAttribute("confirmNo", confirmNo);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 100);
		return result;
	}
	
	//인증번호 일치여부 event
	@PostMapping("/user/confirmMessage")
	public Map<String, Object> confirmSMS(@RequestParam("pnconfirm")String pnconfirm, @RequestParam("phoneNumber")String phoneNumber, HttpSession session) {
	    String confirmNo = (String) session.getAttribute("confirmNo");
		Map<String, Object> result = new HashMap<>();
		if (pnconfirm.equals(confirmNo)) {
			result.put("code", 100);
			session.removeAttribute("confirmNo");

		}else {
			result.put("code", 400);
		}
		return result;
	}
	
}