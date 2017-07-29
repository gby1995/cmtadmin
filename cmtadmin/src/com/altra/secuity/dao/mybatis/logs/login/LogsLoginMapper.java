package com.altra.secuity.dao.mybatis.logs.login;

import java.util.List;
import java.util.Map;

import com.altra.secuity.model.logs.LogsLogin;

public interface LogsLoginMapper {

	 
     /*****
     *根据主键查询
     ****/
     LogsLogin selectByPrimaryKey(Long loginId);
	
	 /****
	 *根据主键删除
	 ****/
     int deleteByPrimaryKey(Long loginId);
     
     /****
	 *根据主键批量删除
	 ****/
     int deleteBatchByPrimaryKey(List<String> list);
     
     /****
	 *新增
	 ****/
     int insertSelective(LogsLogin record);
     
     /****
	 *根据属性分页查询
	 ****/
     List<LogsLogin> selectByPropertyByPage(Map map);
     
     /****
     *根据属性查询记录数
	 ****/
	 int selectCountByProperty(Map map); 
	 
	 /****
     *根据主键更新记录
	 ****/
	 int updateByPrimaryKeySelective(LogsLogin record);
}