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
import com.altra.secuity.dao.mybatis.logs.login.LogsLoginMapper;
import com.altra.secuity.model.logs.LogsLogin;

@Service
public class LogsLoginServiceImpl implements ILogsLoginService {
   
	public final static String LOGIN = "登录";
	
	public final static String LEAVE= "离开";
	
	@Resource
	private LogsLoginMapper logsLoginMapper;
	/**
	 * 根据主键删除
	 * 
	 * @param loginId
	 * @return
	 */
	public Json deleteByPrimaryKey(Long loginId) throws Exception {
		Json json = new Json();
		int result = -1;
		result = logsLoginMapper.deleteByPrimaryKey(loginId);
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
	public Json deleteBatchByPrimaryKey(String loginId) throws Exception{
		Json json = new Json();
		int result = -1;
		result = logsLoginMapper.deleteBatchByPrimaryKey(PageUtil.getIdsForList(loginId));
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
	 * @param loginId
	 * @return
	 */
	public LogsLogin selectByPrimaryKey(Long loginId) throws Exception{
		return logsLoginMapper.selectByPrimaryKey(loginId);
	}
	
    /**
     * 修改
     * @param record
     * @return
     */
	public Json updateByPrimaryKeySelective(LogsLogin record) throws Exception{
		Json json = new Json();
		int result = -1;
		result = logsLoginMapper.updateByPrimaryKeySelective(record);
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
	public String selectLogsLoginByPage(LogsLogin record, PageUtil page) throws Exception{
		List<LogsLogin> list = new ArrayList<LogsLogin>();
		Map<String, Object> maps = new HashMap<String, Object>();
		// 判断条件 
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getLoginId()))) {
			  maps.put("loginId", record.getLoginId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getLoginDate()))) {
			  maps.put("loginDate", record.getLoginDate());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getLoginName()))) {
			  maps.put("loginName", record.getLoginName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getLoginRole()))) {
			  maps.put("loginRole", record.getLoginRole());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getLoginContent()))) {
			  maps.put("loginContent", record.getLoginContent());
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
		list = logsLoginMapper.selectByPropertyByPage(maps);
		// 查询总数
		int count = logsLoginMapper.selectCountByProperty(maps);
		// 公共�? - 返回分页json对象
		return PageUtil.getResultJsonArray(list, count, page.getPage());
	}
	 

}