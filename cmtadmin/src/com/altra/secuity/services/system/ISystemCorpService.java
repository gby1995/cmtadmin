package com.altra.secuity.services.system;

import java.util.List;
import com.altra.common.util.page.PageUtil;
import com.altra.secuity.model.system.SystemCorp;
import com.altra.common.util.page.Json;

public interface ISystemCorpService {

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
	Json insertSelective(SystemCorp record) throws Exception;
	
	/**
	 * 根据主键查询对象
	 * @param scId
	 * @return
	 */
	SystemCorp selectByPrimaryKey(Long scId) throws Exception;
	
    /**
     * 修改
     * @param record
     * @return
     */
	Json updateByPrimaryKeySelective(SystemCorp record) throws Exception;
	
    /**
     * 分页查询数据列表
     * @param record
     * @param page
     * @return
     */
	String selectSystemCorpByPage(SystemCorp record, PageUtil page) throws Exception;
	/**
	 * 数据列表
	 * @return
	 */
	List<SystemCorp> selectSystemCorp(String userName  ,
			 String password ,
			 String province  ,
			 String city ,
			 String twoUnits ,
			 String address ,
			 String hazardSource ,
			 String companyName) throws Exception;
	/**
	 * 根据上级id得到单位
	 * @param twoUnits
	 * @return
	 */
	 List<SystemCorp> selectCorpTwoUnits(String twoUnits,String scname);
}