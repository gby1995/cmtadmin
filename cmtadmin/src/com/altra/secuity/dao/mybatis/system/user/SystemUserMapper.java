package com.altra.secuity.dao.mybatis.system.user;

import java.util.List;
import java.util.Map;

import com.altra.secuity.model.system.SystemUser;

public interface SystemUserMapper {

	 
     /*****
     *根据主键查询
     ****/
     SystemUser selectByPrimaryKey(Long userId);
	
	 /****
	 *根据主键删除
	 ****/
     int deleteByPrimaryKey(Long userId);
     
     /****
	 *根据主键批量删除
	 ****/
     int deleteBatchByPrimaryKey(List<String> list);
     
     /****
	 *新增
	 ****/
     int insertSelective(SystemUser record);
     
     /****
	 *根据属性分页查询
	 ****/
     List<SystemUser> selectByPropertyByPage(Map map);
     
     /****
     *根据属性查询记录数
	 ****/
	 int selectCountByProperty(Map map); 
	 
	 /****
     *根据主键更新记录
	 ****/
	 int updateByPrimaryKeySelective(SystemUser record);
	 
	 /**
	  * 根据用户名密码查询用户
	  * @author liuben
	  * @date 2016.02.07 
	  * @param record
	  * @return SystemUser
	  */
	SystemUser selectUserByPwd(SystemUser record);
}