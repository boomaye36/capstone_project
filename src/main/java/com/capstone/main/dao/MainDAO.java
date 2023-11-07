/*package com.capstone.main.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.capstone.admin.model.Silver;

@Repository
public interface MainDAO {

	public List<Silver> selectSilverList(Silver silver, @Param("sort") String sort);
	public int selectSilverCount(@Param("userId")int userId, @Param("silverId") int SilverId);
}
*/

package com.capstone.main.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.capstone.admin.model.Silver;
import com.capstone.admin.model.new_table;

@Repository
public interface MainDAO {

	public List<Silver> selectSilverList(Silver silver);
	public int selectSilverCount( @Param("silverId") int SilverId);
	public List<Silver> selectSilverSearchList(Map<String, Object> parameters);
	public List<Silver> selectRelateSilverList(@Param("name")String name);
	public List<new_table> selectnewList(new_table newTable);
}