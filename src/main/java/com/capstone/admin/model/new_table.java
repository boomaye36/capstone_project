package com.capstone.admin.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class new_table {
	int id;
	int recommended_id;
	String original_hospital;
	String recommended_hospital;
	String recommended_location;
	String recommended_category;
	String recommended_xpos;
	String recommended_ypos;
}
