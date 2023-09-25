package com.capstone.admin.model;

import java.util.Date;

import lombok.Data;
@Data
public class Silver {

	private int id;
	private String name;
	private String location;
	private String phonenumber;
	private String category;
	private String photo;
	private String open_time;
	private String province;
	private String xpos;
	private String ypos;
	private int doctorNo;
	private String url;
	private Date opendate;
	private double credit;
	private Date createdat;
	private Date updatedat;
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
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getXpos() {
		return xpos;
	}
	public void setXpos(String xpos) {
		this.xpos = xpos;
	}
	public String getYpos() {
		return ypos;
	}
	public void setYpos(String ypos) {
		this.ypos = ypos;
	}
	public int getDoctorNo() {
		return doctorNo;
	}
	public void setDoctorNo(int doctorNo) {
		this.doctorNo = doctorNo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public Date getCreatedat() {
		return createdat;
	}
	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	public Date getUpdatedat() {
		return updatedat;
	}
	public void setUpdatedat(Date updatedat) {
		this.updatedat = updatedat;
	}

	
	
}
