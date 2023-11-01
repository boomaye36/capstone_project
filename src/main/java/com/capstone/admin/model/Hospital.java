package com.capstone.admin.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Hospital {
	private Silver silver;
	private List<Silver> recommendedList;
	public Silver getSilver() {
		return silver;
	}
	public void setSilver(Silver silver) {
		this.silver = silver;
	}
	public List<Silver> getRecommendedList() {
		return recommendedList;
	}
	public void setRecommendedList(List<Silver> recommendedList) {
		this.recommendedList = recommendedList;
	}
}