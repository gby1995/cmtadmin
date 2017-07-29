package com.altra.secuity.services.logs;

import com.altra.common.util.page.Json;
import com.altra.common.util.page.PageUtil;
import com.altra.secuity.model.logs.LogsRecords;

public interface ILogsRecordsService {

	/**
	 * 根据主键删除
	 * 
	 * @param reId
	 * @return
	 */
	Json deleteByPrimaryKey(Long reId) throws Exception;
	
	/**
	 * 根据主键批量删除
	 * 
	 * @param list
	 * @return
	 */
	Json deleteBatchByPrimaryKey(String reId) throws Exception;
	
	
	/**
	 * 根据主键查询对象
	 * @param reId
	 * @return
	 */
	LogsRecords selectByPrimaryKey(Long reId) throws Exception;
	
    /**
     * 修改
     * @param record
     * @return
     */
	Json updateByPrimaryKeySelective(LogsRecords record) throws Exception;
	
    /**
     * 分页查询数据列表
     * @param record
     * @param page
     * @return
     */
	String selectLogsRecordsByPage(LogsRecords record, PageUtil page) throws Exception;
	 

}