package com.capstone.silver.dto;

import java.sql.Timestamp;

public class SilverResponseDTO {
	private int id;
	private String name;
	private String location;
	private String phonenumber;
	private String category;
	private int hnumber;
	private String photo;
	private String open_time;
	private double credit; // 2번째 소수점 자리에서 올려주는 명령어 사용해주기
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public SilverResponseDTO(int id, String name, String location, String phonenumber, String category, int hnumber,
			String photo, String open_time, double credit, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.phonenumber = phonenumber;
		this.category = category;
		this.hnumber = hnumber;
		this.photo = photo;
		this.open_time = open_time;
		this.credit = credit;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public SilverResponseDTO() {
	}
	
	
	
	
	
	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getHnumber() {
		return hnumber;
	}
	public void setHnumber(int hnumber) {
		this.hnumber = hnumber;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getOpen_time() {
		return open_time;
	}
	public void setOpen_time(String open_time) {
		this.open_time = open_time;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "SilverResponseDTO [id=" + id + ", name=" + name + ", location=" + location + ", phonenumber="
				+ phonenumber + ", category=" + category + ", hnumber=" + hnumber + ", photo=" + photo + ", open_time="
				+ open_time + ", credit=" + credit + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	
}
