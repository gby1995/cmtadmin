package com.altra.secuity.dao.mybatis.system.corp;

import java.util.List;
import java.util.Map;

import com.altra.secuity.model.system.SystemCorp;

public interface SystemCorpMapper {

	 
     /*****
     *根据主键查询
     ****/
     SystemCorp selectByPrimaryKey(Long scId);
	
	 /****
	 *根据主键删除
	 ****/
     int deleteByPrimaryKey(Long scId);
     
     /****
	 *根据主键批量删除
	 ****/
     int deleteBatchByPrimaryKey(List<String> list);
     
     /****
	 *新增
	 ****/
     int insertSelective(SystemCorp record);
     
     /****
	 *根据属性分页查询
	 ****/
     List<SystemCorp> selectByPropertyByPage(Map map);
     
     /****
     *根据属性查询记录数
	 ****/
	 int selectCountByProperty(Map map); 
	 
	 /****
     *根据主键更新记录
	 ****/
	 int updateByPrimaryKeySelective(SystemCorp record);
	 /**
	  * 列表
	  * @param userName
	  * @param password
	  * @param province
	  * @param city
	  * @param twoUnits
	  * @param address
	  * @param hazardSource
	  * @param companyName
	  * @return
	  */
	 List<SystemCorp> selectSystemCorp(Map map);
	 
	 List<SystemCorp> selectCorpTwoUnits(Map map);
	 
	 
}