package com.capstone.main.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.capstone.admin.model.Silver;

@Repository
public interface MainDAO {

	public List<Silver> selectSilverList(Silver silver);
}
