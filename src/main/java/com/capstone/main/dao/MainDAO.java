package com.capstone.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.capstone.admin.model.Silver;

@Repository
public interface MainDAO {

	public List<Silver> selectSilverList(Silver silver, @Param("sort") String sort);
	public int selectSilverCount(@Param("userId")int userId, @Param("silverId") int SilverId);
}
