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
import com.altra.secuity.dao.mybatis.system.corp.SystemCorpMapper;
import com.altra.secuity.model.system.SystemCorp;

@Service
public class SystemCorpServiceImpl implements ISystemCorpService {
	@Resource
	private SystemCorpMapper systemCorpMapper;
	/**
	 * 根据主键删除
	 * 
	 * @param scId
	 * @return
	 */
	public Json deleteByPrimaryKey(Long scId) throws Exception {
		Json json = new Json();
		int result = -1;
		result = systemCorpMapper.deleteByPrimaryKey(scId);
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
		result = systemCorpMapper.deleteBatchByPrimaryKey(PageUtil.getIdsForList(scId));
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
	public Json insertSelective(SystemCorp record) throws Exception{
		Json json = new Json();
		int result = -1;
		Map<String, Object> conMap = new HashMap<String, Object>();
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScId()))) {
			  conMap.put("scId", record.getScId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScName()))) {
			  conMap.put("scName", record.getScName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScShortName()))) {
			  conMap.put("scShortName", record.getScShortName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScPid()))) {
			  conMap.put("scPid", record.getScPid());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScPname()))) {
			  conMap.put("scPname", record.getScPname());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScTopId()))) {
			  conMap.put("scTopId", record.getScTopId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScTopName()))) {
			  conMap.put("scTopName", record.getScTopName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScCity()))) {
			  conMap.put("scCity", record.getScCity());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScProvince()))) {
			  conMap.put("scProvince", record.getScProvince());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScAddress()))) {
			  conMap.put("scAddress", record.getScAddress());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScInfo()))) {
			  conMap.put("scInfo", record.getScInfo());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScUserInfo()))) {
			  conMap.put("scUserInfo", record.getScUserInfo());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScHolding()))) {
			  conMap.put("scHolding", record.getScHolding());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScSafeResponsib()))) {
			  conMap.put("scSafeResponsib", record.getScSafeResponsib());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScAntiRisk()))) {
			  conMap.put("scAntiRisk", record.getScAntiRisk());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScIsChemical()))) {
			  conMap.put("scIsChemical", record.getScIsChemical());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScChemicalInfo()))) {
			  conMap.put("scChemicalInfo", record.getScChemicalInfo());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScIsHazard()))) {
			  conMap.put("scIsHazard", record.getScIsHazard());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScHazardInfo()))) {
			  conMap.put("scHazardInfo", record.getScHazardInfo());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScLongitude()))) {
			  conMap.put("scLongitude", record.getScLongitude());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScLatitude()))) {
			  conMap.put("scLatitude", record.getScLatitude());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScSipNum()))) {
			  conMap.put("scSipNum", record.getScSipNum());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScOrder()))) {
			  conMap.put("scOrder", record.getScOrder());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getCreateTime()))) {
			  conMap.put("createTime", record.getCreateTime());
			}
		//存在条件判断
		List<SystemCorp> list=systemCorpMapper.selectByPropertyByPage(conMap);
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
			result = systemCorpMapper.insertSelective(record);
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
	public SystemCorp selectByPrimaryKey(Long scId) throws Exception{
		return systemCorpMapper.selectByPrimaryKey(scId);
	}
	
    /**
     * 修改
     * @param record
     * @return
     */
	public Json updateByPrimaryKeySelective(SystemCorp record) throws Exception{
		Json json = new Json();
		int result = -1;
		result = systemCorpMapper.updateByPrimaryKeySelective(record);
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
	public String selectSystemCorpByPage(SystemCorp record, PageUtil page) throws Exception{
		List<SystemCorp> list = new ArrayList<SystemCorp>();
		Map<String, Object> maps = new HashMap<String, Object>();
		// 判断条件 
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScId()))) {
			  maps.put("scId", record.getScId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScName()))) {
			  maps.put("scName", record.getScName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScShortName()))) {
			  maps.put("scShortName", record.getScShortName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScPid()))) {
			  maps.put("scPid", record.getScPid());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScPname()))) {
			  maps.put("scPname", record.getScPname());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScTopId()))) {
			  maps.put("scTopId", record.getScTopId());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScTopName()))) {
			  maps.put("scTopName", record.getScTopName());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScCity()))) {
			  maps.put("scCity", record.getScCity());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScProvince()))) {
			  maps.put("scProvince", record.getScProvince());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScAddress()))) {
			  maps.put("scAddress", record.getScAddress());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScInfo()))) {
			  maps.put("scInfo", record.getScInfo());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScUserInfo()))) {
			  maps.put("scUserInfo", record.getScUserInfo());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScHolding()))) {
			  maps.put("scHolding", record.getScHolding());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScSafeResponsib()))) {
			  maps.put("scSafeResponsib", record.getScSafeResponsib());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScAntiRisk()))) {
			  maps.put("scAntiRisk", record.getScAntiRisk());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScIsChemical()))) {
			  maps.put("scIsChemical", record.getScIsChemical());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScChemicalInfo()))) {
			  maps.put("scChemicalInfo", record.getScChemicalInfo());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScIsHazard()))) {
			  maps.put("scIsHazard", record.getScIsHazard());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScHazardInfo()))) {
			  maps.put("scHazardInfo", record.getScHazardInfo());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScLongitude()))) {
			  maps.put("scLongitude", record.getScLongitude());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScLatitude()))) {
			  maps.put("scLatitude", record.getScLatitude());
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(record.getScSipNum()))) {
			  maps.put("scSipNum", record.getScSipNum());
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
		list = systemCorpMapper.selectByPropertyByPage(maps);
		// 查询总数
		int count = systemCorpMapper.selectCountByProperty(maps);
		// 公共�? - 返回分页json对象
		return PageUtil.getResultJsonArray(list, count, page.getPage());
	}
	
	/**
	 * 模糊条件查询
	*/
	@Override
	public List<SystemCorp> selectSystemCorp(String userName, String password,
			String province, String city, String twoUnits, String address,
			String hazardSource, String companyName) throws Exception {
			List<SystemCorp> list = new ArrayList<SystemCorp>();
		    Map<String, Object> maps = new HashMap<String, Object>();
		   // 判断条件 
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(userName))) {
			  maps.put("scName", userName);
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(password))) {
			  maps.put("password", password);
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(province))) {
			  maps.put("province", province);
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(city))) {
			  maps.put("city", city);
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(twoUnits))) {
			  maps.put("twoUnits", twoUnits);
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(address))) {
			  maps.put("address", address);
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(hazardSource))) {
			  maps.put("hazardSource", hazardSource);
			}
    		if (ValidateUtil.isNullAndIsStr(String.valueOf(companyName))) {
			  maps.put("companyName", companyName);
			}
    		//maps.put("sc_top_id","0");
    		list = systemCorpMapper.selectSystemCorp(maps);
		return list;
	}
	/**
	 *  二级企业
	 */
	@Override
	public List<SystemCorp> selectCorpTwoUnits(String twoUnits,String scname) {
				List<SystemCorp> list = new ArrayList<SystemCorp>();
			    Map<String, Object> maps = new HashMap<String, Object>();
			   // 判断条件 
	    	
	    		if (ValidateUtil.isNullAndIsStr(String.valueOf(twoUnits))) {
				  maps.put("twoUnits", twoUnits);
				}
	    		if (ValidateUtil.isNullAndIsStr(String.valueOf(scname))) {
					  maps.put("scName", scname);
				}
	    		list = systemCorpMapper.selectCorpTwoUnits(maps);
			return list;
		

	}
	
	
	
}