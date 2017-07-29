package com.altra.secuity.services.logs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.altra.common.util.page.Json;
import com.altra.common.util.page.PageUtil;
import com.altra.common.util.page.ValidateUtil;
import com.altra.secuity.dao.mybatis.logs.records.LogsRecordsMapper;
import com.altra.secuity.dao.mybatis.system.user.SystemUserMapper;
import com.altra.secuity.model.logs.LogsRecords;

@Service
public class LogsRecordsServiceImpl implements ILogsRecordsService {
	@Resource
	private LogsRecordsMapper logsRecordsMapper;
	@Resource
	// 系统管理/用户管理dao�?
	private SystemUserMapper systemUserMapper;
	
	
	public final static String ADD_FLAG = "ADD";//添加操作标识
	
	public final static String DEL_FLAG = "DEL";//删除操作标识
	
	public final static String UPDATE_FLAG = "UPDATE";//修改操作标识
	
	/**
	 * 根据主键删除
	 * 
	 * @param reId
	 * @return
	 */
	public Json deleteByPrimaryKey(Long reId) throws Exception {
		Json json = new Json();
		int result = -1;
		result = logsRecordsMapper.deleteByPrimaryKey(reId);
		if (result > 0) {
			json.setSuccess(true);
			json.setMsg(Json.DEL_SUCCESS);
		} else {
			json.setSuccess(false);
			json.setMsg(Json.DEL_FAIL);
		}
		return json;
	}
	
	/**
	 * 根据主键批量删除
	 * 
	 * @param list
	 * @return
	 */
	public Json deleteBatchByPrimaryKey(String reId) throws Exception{
		Json json = new Json();
		int result = -1;
		result = logsRecordsMapper.deleteBatchByPrimaryKey(PageUtil.getIdsForList(reId));
		if (result > 0) {
			json.setSuccess(true);
			json.setMsg(Json.DEL_SUCCESS);
		} else {
			json.setSuccess(false);
			json.setMsg(Json.DEL_FAIL);
		}
		return json;
	}
	
	/**
	 * 根据主键查询对象
	 * @param reId
	 * @return
	 */
	public LogsRecords selectByPrimaryKey(Long reId) throws Exception{
		return logsRecordsMapper.selectByPrimaryKey(reId);
	}
	
    /**
     * 修改
     * @param record
     * @return
     */
	public Json updateByPrimaryKeySelective(LogsRecords record) throws Exception{
		Json json = new Json();
		int result = -1;
		result = logsRecordsMapper.updateByPrimaryKeySelective(record);
		if (result > 0) {
			json.setSuccess(true);
			json.setMsg(Json.UPDATE_SUCCESS);
		} else {
			json.setSuccess(false);
			json.setMsg(Json.UPDATE_FAIL);
		}
		return json;
	}
	
    /**
     * 分页查询数据列表
     * @param record
     * @param page
     * @return
     */
	public String selectLogsRecordsByPage(LogsRecords record, PageUtil page) throws Exception{
		List<LogsRecords> list = new ArrayList<LogsRecords>();
		Map<String, Object> maps = new HashMap<String, Object>();
		// 判断条件 
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getReId()))) {
			  maps.put("reId", record.getReId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getReDate()))) {
			  maps.put("reDate", record.getReDate());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getReName()))) {
			  maps.put("reName", record.getReName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getReRole()))) {
			  maps.put("reRole", record.getReRole());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getReType()))) {
			  maps.put("reType", record.getReType());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getReContent()))) {
			  maps.put("reContent", record.getReContent());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getCorpId()))) {
			  maps.put("corpId", record.getCorpId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getFirDate()))) {
    			  maps.put("firDate", record.getFirDate());
    		}
      		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSecDate()))) {
    			  maps.put("secDate", record.getSecDate());
    		}
		// 起始分页
		maps.put("startindex", page.getStartIndex());
		// 结束分页
		maps.put("maxindex", page.getMaxIndex());
		// 查询分页
		list = logsRecordsMapper.selectByPropertyByPage(maps);
		// 查询总数
		int count = logsRecordsMapper.selectCountByProperty(maps);
		// 公共�? - 返回分页json对象
		return PageUtil.getResultJsonArray(list, count, page.getPage());
	}
	 

}