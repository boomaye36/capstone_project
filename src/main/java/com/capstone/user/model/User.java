package com.capstone.user.model;

import java.util.Date;

import lombok.Data;
@Data
public class User {
	private int id;
	private String loginid;
	private String password;
	private String phonenumber;
	private String nickname;
	private String email;
	private String path;
	private String profilephoto;
	private String location;
	private Date createdat;
	private Date updatedat;

	
	
}
