package com.altra.secuity.services.system;

import com.altra.common.util.page.Json;
import com.altra.common.util.page.PageUtil;
import com.altra.secuity.model.system.SystemUser;

public interface ISystemUserService {

	/**
	 * 根据主键删除
	 * 
	 * @param userId
	 * @return
	 */
	Json deleteByPrimaryKey(Long userId) throws Exception;
	
	/**
	 * 根据主键批量删除
	 * 
	 * @param list
	 * @return
	 */
	Json deleteBatchByPrimaryKey(String userId) throws Exception;
	
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	Json insertSelective(SystemUser record) throws Exception;
	
	/**
	 * 根据主键查询对象
	 * @param userId
	 * @return
	 */
	SystemUser selectByPrimaryKey(Long userId) throws Exception;
	
    /**
     * 修改
     * @param record
     * @return
     */
	Json updateByPrimaryKeySelective(SystemUser record) throws Exception;
	
    /**
     * 分页查询数据列表
     * @param record
     * @param page
     * @return
     */
	String selectSystemUserByPage(SystemUser record, PageUtil page) throws Exception;
	 
	/**
	  * 根据用户名密码查询用户
	  * @author liuben
	  * @date 2016.02.07 
	  * @param systemUser
	  * @return SystemUser
	  */
	SystemUser selectUserByPwd(SystemUser systemUser) throws Exception;
}