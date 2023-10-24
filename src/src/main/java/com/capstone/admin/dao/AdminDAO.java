package com.capstone.admin.dao;

import org.springframework.stereotype.Repository;

import com.capstone.admin.model.Silver;
@Repository
public interface AdminDAO {
	public void insertSilver (Silver silver);
}
