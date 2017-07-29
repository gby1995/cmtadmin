package com.altra.secuity.services.logs;

import com.altra.common.util.page.Json;
import com.altra.common.util.page.PageUtil;
import com.altra.secuity.model.logs.LogsLogin;

public interface ILogsLoginService {

	/**
	 * 根据主键删除
	 * 
	 * @param loginId
	 * @return
	 */
	Json deleteByPrimaryKey(Long loginId) throws Exception;
	
	/**
	 * 根据主键批量删除
	 * 
	 * @param list
	 * @return
	 */
	Json deleteBatchByPrimaryKey(String loginId) throws Exception;
	
	/**
	 * 根据主键查询对象
	 * @param loginId
	 * @return
	 */
	LogsLogin selectByPrimaryKey(Long loginId) throws Exception;
	
    /**
     * 修改
     * @param record
     * @return
     */
	Json updateByPrimaryKeySelective(LogsLogin record) throws Exception;
	
    /**
     * 分页查询数据列表
     * @param record
     * @param page
     * @return
     */
	String selectLogsLoginByPage(LogsLogin record, PageUtil page) throws Exception;
	 

}