package com.capstone.admin.model;

public class RecommendedHospitals {
	private int id;
	private String original_hospital;
	private String recommended_hospital;
	private String similarity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOriginal_hospital() {
		return original_hospital;
	}
	public void setOriginal_hospital(String original_hospital) {
		this.original_hospital = original_hospital;
	}
	public String getRecommended_hospital() {
		return recommended_hospital;
	}
	public void setRecommended_hospital(String recommended_hospital) {
		this.recommended_hospital = recommended_hospital;
	}
	public String getSimilarity() {
		return similarity;
	}
	public void setSimilarity(String similarity) {
		this.similarity = similarity;
	}
	
	

}
