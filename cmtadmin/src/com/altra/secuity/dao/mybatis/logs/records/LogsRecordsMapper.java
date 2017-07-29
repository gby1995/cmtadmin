package com.altra.secuity.dao.mybatis.logs.records;

import java.util.List;
import java.util.Map;

import com.altra.secuity.model.logs.LogsRecords;

public interface LogsRecordsMapper {

	 
     /*****
     *根据主键查询
     ****/
     LogsRecords selectByPrimaryKey(Long reId);
	
	 /****
	 *根据主键删除
	 ****/
     int deleteByPrimaryKey(Long reId);
     
     /****
	 *根据主键批量删除
	 ****/
     int deleteBatchByPrimaryKey(List<String> list);
     
     /****
	 *新增
	 ****/
     int insertSelective(LogsRecords record);
     
     /****
	 *根据属性分页查询
	 ****/
     List<LogsRecords> selectByPropertyByPage(Map map);
     
     /****
     *根据属性查询记录数
	 ****/
	 int selectCountByProperty(Map map); 
	 
	 /****
     *根据主键更新记录
	 ****/
	 int updateByPrimaryKeySelective(LogsRecords record);
}