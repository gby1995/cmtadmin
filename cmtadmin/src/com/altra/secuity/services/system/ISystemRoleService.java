package com.altra.secuity.services.system;

import com.altra.common.util.page.PageUtil;
import com.altra.secuity.model.system.SystemRole;
import com.altra.common.util.page.Json;

public interface ISystemRoleService {

	/**
	 * 根据主键删除
	 * 
	 * @param srId
	 * @return
	 */
	Json deleteByPrimaryKey(Long srId) throws Exception;
	
	/**
	 * 根据主键批量删除
	 * 
	 * @param list
	 * @return
	 */
	Json deleteBatchByPrimaryKey(String srId) throws Exception;
	
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	Json insertSelective(SystemRole record) throws Exception;
	
	/**
	 * 根据主键查询对象
	 * @param srId
	 * @return
	 */
	SystemRole selectByPrimaryKey(Long srId) throws Exception;
	
    /**
     * 修改
     * @param record
     * @return
     */
	Json updateByPrimaryKeySelective(SystemRole record) throws Exception;
	
    /**
     * 分页查询数据列表
     * @param record
     * @param page
     * @return
     */
	String selectSystemRoleByPage(SystemRole record, PageUtil page) throws Exception;
	 

	/**
     * 分页查询数据列表(与权限表,用户表关�?)
     * @author liuben
	 * @date 2016.02.14 
     * @param record
     * @param page
     * @return String
     */
	public String selectSystemRoleByPageByAction(SystemRole record, PageUtil page) throws Exception;
}