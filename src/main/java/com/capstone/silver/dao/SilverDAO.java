package com.capstone.silver.dao;

import com.capstone.silver.dto.SilverDTO;

public interface SilverDAO {
	public int insertSilver(SilverDTO silverDTO);
	public int exist(String name);
}
