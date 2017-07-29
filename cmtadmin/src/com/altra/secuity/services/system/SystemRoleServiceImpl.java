package com.altra.secuity.services.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.altra.common.util.page.ValidateUtil;
import com.altra.common.util.page.PageUtil;
import com.altra.common.util.page.Json;
import com.altra.secuity.dao.mybatis.system.role.SystemRoleMapper;
import com.altra.secuity.model.system.SystemRole;

@Service
public class SystemRoleServiceImpl implements ISystemRoleService {
	@Resource
	private SystemRoleMapper systemRoleMapper;
	/**
	 * 根据主键删除
	 * 
	 * @param srId
	 * @return
	 */
	public Json deleteByPrimaryKey(Long srId) throws Exception {
		Json json = new Json();
		int result = -1;
		result = systemRoleMapper.deleteByPrimaryKey(srId);
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
	public Json deleteBatchByPrimaryKey(String srId) throws Exception{
		Json json = new Json();
		int result = -1;
		result = systemRoleMapper.deleteBatchByPrimaryKey(PageUtil.getIdsForList(srId));
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
	 * 新增
	 * @param record
	 * @return
	 */
	public Json insertSelective(SystemRole record) throws Exception{
		Json json = new Json();
		int result = -1;
		Map<String, Object> conMap = new HashMap<String, Object>();
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSrId()))) {
			  conMap.put("srId", record.getSrId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSrCode()))) {
			  conMap.put("srCode", record.getSrCode());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSrName()))) {
			  conMap.put("srName", record.getSrName());
			}
		//存在条件判断
		List<SystemRole> list=systemRoleMapper.selectByPropertyByPage(conMap);
		int isExist =0;
		if(null != list &&list.size()>0){
			isExist=list.size();
		}
		
		/**
		 * �?要封装返回json�?
		 */
		if(isExist>0){
			json.setSuccess(false);
			json.setMsg("客户名称已经存在�?");
		}else{
			result = systemRoleMapper.insertSelective(record);
			if (result > 0) {
				json.setSuccess(true);
				json.setMsg(Json.ADD_SUCCESS);
			} else {
				json.setSuccess(false);
				json.setMsg(Json.ADD_FAIL);
			}
		}
		return json;
	}
	
	/**
	 * 根据主键查询对象
	 * @param srId
	 * @return
	 */
	public SystemRole selectByPrimaryKey(Long srId) throws Exception{
		return systemRoleMapper.selectByPrimaryKey(srId);
	}
	
    /**
     * 修改
     * @param record
     * @return
     */
	public Json updateByPrimaryKeySelective(SystemRole record) throws Exception{
		Json json = new Json();
		int result = -1;
		result = systemRoleMapper.updateByPrimaryKeySelective(record);
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
	public String selectSystemRoleByPage(SystemRole record, PageUtil page) throws Exception{
		List<SystemRole> list = new ArrayList<SystemRole>();
		Map<String, Object> maps = new HashMap<String, Object>();
		// 判断条件 
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSrId()))) {
			  maps.put("srId", record.getSrId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSrCode()))) {
			  maps.put("srCode", record.getSrCode());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSrName()))) {
			  maps.put("srName", record.getSrName());
			}
		// 起始分页
		maps.put("startindex", page.getStartIndex());
		// 结束分页
		maps.put("maxindex", page.getMaxIndex());
		// 查询分页
		list = systemRoleMapper.selectByPropertyByPage(maps);
		// 查询总数
		int count = systemRoleMapper.selectCountByProperty(maps);
		// 公共�? - 返回分页json对象
		return PageUtil.getResultJsonArray(list, count, page.getPage());
	}
	 
	/**
     * 分页查询数据列表(与权限表,用户表关�?)
     * @author liuben
	 * @date 2016.02.14 
     * @param record
     * @param page
     * @return String
     */
	public String selectSystemRoleByPageByAction(SystemRole record, PageUtil page) throws Exception{
		List<SystemRole> list = new ArrayList<SystemRole>();
		Map<String, Object> maps = new HashMap<String, Object>();
		
		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSrCode()))) {
			maps.put("srCode", record.getSrCode());
		}
  		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getSrName()))) {
  			maps.put("srName", record.getSrName());
		}
		// 起始分页
		maps.put("startindex", page.getStartIndex());
		// 结束分页
		maps.put("maxindex", page.getMaxIndex());
		// 查询分页
		list = systemRoleMapper.selectByPropertyByPageByAction(maps);
		// 查询总数
		int count = systemRoleMapper.selectCountByPropertyByAction(maps);
		// 公共�? - 返回分页json对象
		return PageUtil.getResultJsonArray(list, count, page.getPage());
	}

}