package com.altra.secuity.dao.mybatis.system.camera;

import java.util.List;
import java.util.Map;
import com.altra.secuity.model.system.SystemCamera;

public interface SystemCameraMapper {

	 
     /*****
     *根据主键查询
     ****/
     SystemCamera selectByPrimaryKey(Long scId);
	
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
     int insertSelective(SystemCamera record);
     
     /****
	 *根据属性分页查询
	 ****/
     List<SystemCamera> selectByPropertyByPage(Map map);
     
     /****
     *根据属性查询记录数
	 ****/
	 int selectCountByProperty(Map map); 
	 
	 /****
     *根据主键更新记录
	 ****/
	 int updateByPrimaryKeySelective(SystemCamera record);
	 
	 SystemCamera selectByGroupUtils(Long scId);
	 List<SystemCamera>  selectByGroup(Map map) ;
	 int selectCountByGroup(Map map); 
		
}