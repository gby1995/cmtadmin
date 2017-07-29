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
import com.altra.secuity.dao.mybatis.system.user.SystemUserMapper;
import com.altra.secuity.model.system.SystemUser;

@Service
public class SystemUserServiceImpl implements ISystemUserService {
	@Resource
	private SystemUserMapper systemUserMapper;
	/**
	 * 根据主键删除
	 * 
	 * @param userId
	 * @return
	 */
	public Json deleteByPrimaryKey(Long userId) throws Exception {
		Json json = new Json();
		int result = -1;
		result = systemUserMapper.deleteByPrimaryKey(userId);
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
	public Json deleteBatchByPrimaryKey(String userId) throws Exception{
		Json json = new Json();
		int result = -1;
		result = systemUserMapper.deleteBatchByPrimaryKey(PageUtil.getIdsForList(userId));
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
	public Json insertSelective(SystemUser record) throws Exception{
		Json json = new Json();
		int result = -1;
		Map<String, Object> conMap = new HashMap<String, Object>();
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserId()))) {
			  conMap.put("userId", record.getUserId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserName()))) {
			  conMap.put("userName", record.getUserName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserPassword()))) {
			  conMap.put("userPassword", record.getUserPassword());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserRealName()))) {
			  conMap.put("userRealName", record.getUserRealName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSex()))) {
			  conMap.put("userSex", record.getUserSex());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserBirth()))) {
			  conMap.put("userBirth", record.getUserBirth());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserNum()))) {
			  conMap.put("userNum", record.getUserNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserTelWork()))) {
			  conMap.put("userTelWork", record.getUserTelWork());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserTelHome()))) {
			  conMap.put("userTelHome", record.getUserTelHome());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserTelMobile()))) {
			  conMap.put("userTelMobile", record.getUserTelMobile());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSipNum()))) {
			  conMap.put("userSipNum", record.getUserSipNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSipFront()))) {
			  conMap.put("userSipFront", record.getUserSipFront());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSipBack()))) {
			  conMap.put("userSipBack", record.getUserSipBack());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSipLevel()))) {
			  conMap.put("userSipLevel", record.getUserSipLevel());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserDeptId()))) {
			  conMap.put("userDeptId", record.getUserDeptId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserDeptName()))) {
			  conMap.put("userDeptName", record.getUserDeptName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserRoleId()))) {
			  conMap.put("userRoleId", record.getUserRoleId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserRoleName()))) {
			  conMap.put("userRoleName", record.getUserRoleName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserPost()))) {
			  conMap.put("userPost", record.getUserPost());
			}
		//存在条件判断
		List<SystemUser> list=systemUserMapper.selectByPropertyByPage(conMap);
		int isExist =0;
		if(null != list &&list.size()>0){
			isExist=list.size();
		}
		
		/**
		 * 需要封装返回json类
		 */
		if(isExist>0){
			json.setSuccess(false);
			json.setMsg("客户名称已经存在！");
		}else{
			result = systemUserMapper.insertSelective(record);
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
	 * @param userId
	 * @return
	 */
	public SystemUser selectByPrimaryKey(Long userId) throws Exception{
		return systemUserMapper.selectByPrimaryKey(userId);
	}
	
    /**
     * 修改
     * @param record
     * @return
     */
	public Json updateByPrimaryKeySelective(SystemUser record) throws Exception{
		Json json = new Json();
		int result = -1;
		result = systemUserMapper.updateByPrimaryKeySelective(record);
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
	public String selectSystemUserByPage(SystemUser record, PageUtil page) throws Exception{
		List<SystemUser> list = new ArrayList<SystemUser>();
		Map<String, Object> maps = new HashMap<String, Object>();
		// 判断条件 
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserId()))) {
			  maps.put("userId", record.getUserId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserName()))) {
			  maps.put("userName", record.getUserName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserPassword()))) {
			  maps.put("userPassword", record.getUserPassword());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserRealName()))) {
			  maps.put("userRealName", record.getUserRealName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSex()))) {
			  maps.put("userSex", record.getUserSex());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserBirth()))) {
			  maps.put("userBirth", record.getUserBirth());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserNum()))) {
			  maps.put("userNum", record.getUserNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserTelWork()))) {
			  maps.put("userTelWork", record.getUserTelWork());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserTelHome()))) {
			  maps.put("userTelHome", record.getUserTelHome());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserTelMobile()))) {
			  maps.put("userTelMobile", record.getUserTelMobile());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSipNum()))) {
			  maps.put("userSipNum", record.getUserSipNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSipFront()))) {
			  maps.put("userSipFront", record.getUserSipFront());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSipBack()))) {
			  maps.put("userSipBack", record.getUserSipBack());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserSipLevel()))) {
			  maps.put("userSipLevel", record.getUserSipLevel());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserDeptId()))) {
			  maps.put("userDeptId", record.getUserDeptId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserDeptName()))) {
			  maps.put("userDeptName", record.getUserDeptName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserRoleId()))) {
			  maps.put("userRoleId", record.getUserRoleId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserRoleName()))) {
			  maps.put("userRoleName", record.getUserRoleName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getUserPost()))) {
			  maps.put("userPost", record.getUserPost());
			}
		// 起始分页
		maps.put("startindex", page.getStartIndex());
		// 结束分页
		maps.put("maxindex", page.getMaxIndex());
		// 查询分页
		list = systemUserMapper.selectByPropertyByPage(maps);
		// 查询总数
		int count = systemUserMapper.selectCountByProperty(maps);
		// 公共类 - 返回分页json对象
		return PageUtil.getResultJsonArray(list, count, page.getPage());
	}
	 
	 /**
	  * 根据用户名密码查询用户
	  * @author liuben
	  * @date 2016.02.07 
	  * @param systemUser
	  * @return SystemUser
	  */
	public SystemUser selectUserByPwd(SystemUser systemUser) {
		return systemUserMapper.selectUserByPwd(systemUser);
	}
}