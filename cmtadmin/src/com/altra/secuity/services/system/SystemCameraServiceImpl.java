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
import com.altra.secuity.dao.mybatis.system.camera.SystemCameraMapper;
import com.altra.secuity.model.system.SystemCamera;

@Service
public class SystemCameraServiceImpl implements ISystemCameraService {
	@Resource
	private SystemCameraMapper systemCameraMapper;
	/**
	 * 根据主键删除
	 * 
	 * @param scId
	 * @return
	 */
	public Json deleteByPrimaryKey(Long scId) throws Exception {
		Json json = new Json();
		int result = -1;
		result = systemCameraMapper.deleteByPrimaryKey(scId);
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
	public Json deleteBatchByPrimaryKey(String scId) throws Exception{
		Json json = new Json();
		int result = -1;
		result = systemCameraMapper.deleteBatchByPrimaryKey(PageUtil.getIdsForList(scId));
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
	public Json insertSelective(SystemCamera record) throws Exception{
		Json json = new Json();
		int result = -1;
		Map<String, Object> conMap = new HashMap<String, Object>();
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScId()))) {
			  conMap.put("scId", record.getScId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScName()))) {
			  conMap.put("scName", record.getScName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScNum()))) {
			  conMap.put("scNum", record.getScNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScCorpId()))) {
			  conMap.put("scCorpId", record.getScCorpId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScCorpName()))) {
			  conMap.put("scCorpName", record.getScCorpName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScTopCorpId()))) {
			  conMap.put("scTopCorpId", record.getScTopCorpId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScTopCorpName()))) {
			  conMap.put("scTopCorpName", record.getScTopCorpName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScSipNum()))) {
			  conMap.put("scSipNum", record.getScSipNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScWebLink()))) {
			  conMap.put("scWebLink", record.getScWebLink());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScLoginName()))) {
			  conMap.put("scLoginName", record.getScLoginName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScLoginPwd()))) {
			  conMap.put("scLoginPwd", record.getScLoginPwd());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScNvrName()))) {
			  conMap.put("scNvrName", record.getScNvrName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScNvrPwd()))) {
			  conMap.put("scNvrPwd", record.getScNvrPwd());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScOrder()))) {
			  conMap.put("scOrder", record.getScOrder());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getCreateTime()))) {
			  conMap.put("createTime", record.getCreateTime());
			}
		//存在条件判断
		List<SystemCamera> list=systemCameraMapper.selectByPropertyByPage(conMap);
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
			result = systemCameraMapper.insertSelective(record);
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
	 * @param scId
	 * @return
	 */
	public SystemCamera selectByPrimaryKey(Long scId) throws Exception{
		return systemCameraMapper.selectByPrimaryKey(scId);
	}
	
    /**
     * 修改
     * @param record
     * @return
     */
	public Json updateByPrimaryKeySelective(SystemCamera record) throws Exception{
		Json json = new Json();
		int result = -1;
		result = systemCameraMapper.updateByPrimaryKeySelective(record);
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
     * 模糊条件查询分页查询数据列表
     * @param record
     * @param page
     * @return
     */
	public String selectByGroup(String sid, PageUtil page) throws Exception{
		List<SystemCamera> list = new ArrayList<SystemCamera>();
		Map<String, Object> maps = new HashMap<String, Object>();
		// 判断条件 
		if (ValidateUtil.isNullAndIsStr(sid) ){
			  maps.put("scId", PageUtil.getIdsForList(sid));
			}
  		
		// 起始分页
		maps.put("startindex", page.getStartIndex());
		// 结束分页
		maps.put("maxindex", page.getMaxIndex());
		// 查询分页
		list = systemCameraMapper.selectByGroup(maps);
		// 查询总数
		int count = systemCameraMapper.selectCountByGroup(maps);
		// 公共�? - 返回分页json对象
		return PageUtil.getResultJsonArray(list, count, page.getPage());
	}

	@Override
	public SystemCamera selectByGroupUtils(Long scId) throws Exception {
		// TODO Auto-generated method stub
		return systemCameraMapper.selectByGroupUtils(scId);
	}
	/**
	 * 分页查询数据列表
	*/
	public String selectSystemCameraByPage(SystemCamera record, PageUtil page) throws Exception{
		List<SystemCamera> list = new ArrayList<SystemCamera>();
		Map<String, Object> maps = new HashMap<String, Object>();
		// 判断条件 
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScId()))) {
			  maps.put("scId", record.getScId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScName()))) {
			  maps.put("scName", record.getScName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScNum()))) {
			  maps.put("scNum", record.getScNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScCorpId()))) {
			  maps.put("scCorpId", record.getScCorpId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScCorpName()))) {
			  maps.put("scCorpName", record.getScCorpName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScTopCorpId()))) {
			  maps.put("scTopCorpId", record.getScTopCorpId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScTopCorpName()))) {
			  maps.put("scTopCorpName", record.getScTopCorpName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScSipNum()))) {
			  maps.put("scSipNum", record.getScSipNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScWebLink()))) {
			  maps.put("scWebLink", record.getScWebLink());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScLoginName()))) {
			  maps.put("scLoginName", record.getScLoginName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScLoginPwd()))) {
			  maps.put("scLoginPwd", record.getScLoginPwd());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScNvrName()))) {
			  maps.put("scNvrName", record.getScNvrName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScNvrPwd()))) {
			  maps.put("scNvrPwd", record.getScNvrPwd());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScOrder()))) {
			  maps.put("scOrder", record.getScOrder());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getCreateTime()))) {
			  maps.put("createTime", record.getCreateTime());
			}
		// 起始分页
		maps.put("startindex", page.getStartIndex());
		// 结束分页
		maps.put("maxindex", page.getMaxIndex());
		// 查询分页
		list = systemCameraMapper.selectByPropertyByPage(maps);
		// 查询总数
		int count = systemCameraMapper.selectCountByProperty(maps);
		// 公共�? - 返回分页json对象
		return PageUtil.getResultJsonArray(list, count, page.getPage());
	}
	 

}