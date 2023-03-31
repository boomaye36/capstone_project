package com.capstone.user.dao;

import org.springframework.stereotype.Repository;

import com.capstone.user.model.User;

@Repository

public interface UserDAO {

	// 회원가입 필수정보 insert
	public int insertUser(User user);

	// 회원가입시 id 중복 event
	public int existingLoginId(String loginid);

	// 로그인시 아이디 및 비밀번호 일치여부 확인 event
	public User selectUserByLoginIdAndPassword(User user);

}
