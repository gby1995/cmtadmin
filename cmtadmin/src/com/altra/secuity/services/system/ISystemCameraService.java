package com.altra.secuity.services.system;

import com.altra.common.util.page.PageUtil;
import com.altra.secuity.model.system.SystemCamera;
import com.altra.common.util.page.Json;

public interface ISystemCameraService {

	/**
	 * 根据主键删除
	 * 
	 * @param scId
	 * @return
	 */
	Json deleteByPrimaryKey(Long scId) throws Exception;
	
	/**
	 * 根据主键批量删除
	 * 
	 * @param list
	 * @return
	 */
	Json deleteBatchByPrimaryKey(String scId) throws Exception;
	
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	Json insertSelective(SystemCamera record) throws Exception;
	
	/**
	 * 根据主键查询对象
	 * @param scId
	 * @return
	 */
	SystemCamera selectByPrimaryKey(Long scId) throws Exception;
	
    /**
     * 修改
     * @param record
     * @return
     */
	Json updateByPrimaryKeySelective(SystemCamera record) throws Exception;
	
    /**
     * 分页查询数据列表
     * @param record
     * @param page
     * @return
     */
	String selectSystemCameraByPage(SystemCamera record, PageUtil page) throws Exception;
	 
	/**
	 * 根据单位主键查询对象
	 * @param scId
	 * @return
	 */
	SystemCamera selectByGroupUtils(Long scId) throws Exception;
	
	
	String selectByGroup(String  sid, PageUtil page) throws Exception;

}