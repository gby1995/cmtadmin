package com.altra.secuity.controller.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.altra.common.util.page.ValidateUtil;
import com.altra.common.util.page.PageUtil;
import com.altra.common.util.page.Json;
import com.altra.secuity.model.system.SystemCamera;
import com.altra.secuity.model.system.SystemCorp;
import com.altra.secuity.model.system.SystemUser;
import com.altra.secuity.services.system.SystemCameraServiceImpl;
import com.altra.secuity.services.system.SystemCorpServiceImpl;
import com.altra.secuity.services.system.SystemRoleServiceImpl;
import com.altra.secuity.services.system.SystemUserServiceImpl;

@Controller
public class InterController {
	@Resource
	private SystemUserServiceImpl systemUserServiceImpl;
	@Resource
	private SystemRoleServiceImpl systemRoleServiceImpl;
	@Resource
	private SystemCorpServiceImpl systemCorpServiceImpl;
	@Resource
	private SystemCameraServiceImpl systemCameraServiceImpl;

	/**
	 * 测试
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/mytest", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String mytest(HttpServletRequest request, String param) {
		Json result = new Json();
		System.out.println(param);
		Map<String, String> map = new HashMap<String, String>();
		map.put("ceshi", "111");
		try {
			result.setSuccess(true);
			result.setMsg(Json.DEL_SUCCESS);
			result.setObj(map);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			e.printStackTrace();
		}
		return JSONObject.toJSONString(result);
	}

	/**
	 * 获取组织构架 String
	 * 
	 * @author CEICT
	 * @param request
	 * @param userName
	 * @param password
	 * @param province
	 * @param city
	 * @param twoUnits
	 * @param address
	 * @param hazardSource
	 * @param companyName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandUnits", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String groupLandUnits(HttpServletRequest request,
			@Param(value = "userName") String userName,
			@Param(value = "password") String password,
			@Param(value = "province") String province,
			@Param(value = "city") String city,
			@Param(value = "twoUnits") String twoUnits,
			@Param(value = "address") String address,
			@Param(value = "hazardSource") String hazardSource,
			@Param(value = "companyName") String companyName) {
		List<SystemCorp> list = new ArrayList<SystemCorp>();
		JSONArray array = null;
		JSONArray arraylist = new JSONArray();
		Json result = new Json();
		JSONObject object = null;
		JSONObject children_object = null;
		SystemUser systemUser1 = new SystemUser();
		systemUser1.setUserName(userName);
		systemUser1.setUserPassword(password);
		// 根据密码登录,返回用户对象，判断密码和用户名是否正�?
		SystemUser systemUser2 = systemUserServiceImpl
				.selectUserByPwd(systemUser1);
		if (null != systemUser2) {
			request.getSession().setAttribute("systemUser", systemUser2);
			try {
				list = systemCorpServiceImpl.selectSystemCorp(userName,
						password, province, city, twoUnits, address,
						hazardSource, companyName);

				for (SystemCorp corp : list) {
					object = new JSONObject();
					array = new JSONArray();
					List<SystemCorp> corptemp = systemCorpServiceImpl
							.selectCorpTwoUnits(corp.getScId() + "", null);

					if (corptemp.size() > 0) {
						for (SystemCorp corps : corptemp) {
							children_object = new JSONObject();
							children_object.put("sipNumber", corps.getScId());
							children_object.put("hazardSource",
									corps.getScHazardInfo());
							children_object.put(
									"latitudeLongitude",
									corps.getScLatitude() + ","
											+ corps.getScLongitude());
							children_object.put("dangeroutChemical",
									corps.getScIsChemical());
							children_object.put("twoUnits", corps.getScName());
							array.add(children_object);
						}

					}
					object.put("companyName", corp.getScName());
					object.put("sipNumber", corp.getScId());
					object.put("hazardSource", corp.getScHazardInfo());
					object.put("latitudeLongitude", corp.getScLatitude() + ","
							+ corp.getScLongitude());
					object.put("dangeroutChemical", corp.getScIsChemical());
					object.put("children", array);
					// hazardSource

					arraylist.add(object);
					result.setSuccess(true);
					result.setMsg(arraylist.toJSONString());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result.setMsg(Json.EXCEPTION);
				result.setSuccess(false);
				e.printStackTrace();
			}
		} else {
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
		}
		return JSONObject.toJSONString(result.getMsg());

	}

	/**
	 * 获取摄像�? String
	 * 
	 * @author CEICT
	 * @param request
	 * @param sip
	 * @param companyName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandUnitsMsg", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String groupLandUnitsMsg(HttpServletRequest request,
			@Param(value = "sip") String sip, String companyName) {
		List<SystemCorp> list = new ArrayList<SystemCorp>();
		JSONArray array = new JSONArray();
		JSONArray arraylist = new JSONArray();
		Json result = new Json();
		JSONObject object = null;
		JSONObject children_object = null;
		// 根据密码登录,返回用户对象，判断密码和用户名是否正�?
		//
		if (ValidateUtil.isNullAndIsStr(request.getSession().getAttribute(
				"systemUser"))) {
			try {
				SystemCamera systemCamera = systemCameraServiceImpl
						.selectByGroupUtils(Long.valueOf(sip));
				object = new JSONObject();
				if (null != systemCamera) {
					object.put("sipNumber", systemCamera.getCorp_id().getScId());
					object.put("staffSituation", systemCamera.getCorp_id()
							.getScSafeResponsib());
					object.put("hazardSource", systemCamera.getCorp_id()
							.getScHazardInfo());
					object.put("latitudeLongitude", systemCamera.getCorp_id()
							.getScLatitude()
							+ ","
							+ systemCamera.getCorp_id().getScLongitude());
					object.put("dangeroutChemical", systemCamera.getCorp_id()
							.getScChemicalInfo());
					object.put("companyName", systemCamera.getCorp_id()
							.getScName());
					object.put("picture", systemCamera.getCorp_id()
							.getScProvince());
					object.put("twoUnits", systemCamera.getCorp_id()
							.getScPname());
					object.put("holdingSituation", systemCamera.getCorp_id()
							.getScId());
					object.put("risk", systemCamera.getCorp_id()
							.getScAntiRisk());
					object.put("hazardSourceRange", systemCamera.getCorp_id()
							.getScIsHazard());
					object.put("address", systemCamera.getCorp_id()
							.getScAddress());
					object.put("companyProfile", systemCamera.getCorp_id()
							.getScInfo());
					object.put("dangeroutChemicalRange", systemCamera
							.getCorp_id().getScChemicalInfo());
					systemCamera.setCorp_id(null);
					object.put("shexiangtou", systemCamera);
					result.setSuccess(true);
					result.setMsg(object.toJSONString());
				}

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				e.printStackTrace();
				result.setMsg(Json.EXCEPTION);
				result.setSuccess(false);
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg(Json.EXCEPTION);
				result.setSuccess(false);
				e.printStackTrace();
			}
		} else {
			result.setMsg(Json.LOG_FAIL);
			result.setSuccess(false);
		}
		return JSONObject.toJSONString(result.getMsg());

	}

	/**
	 * 单位添加 String
	 * 
	 * @author CEICT
	 * @param request
	 * @param companyName
	 * @param twoUnits
	 * @param city
	 * @param companyProfile
	 * @param hazardSource
	 * @param staffSituation
	 * @param holdingSituation
	 * @param safety
	 * @param risk
	 * @param dangerousChemicalRange
	 * @param picture
	 * @param sipNumber
	 * @param latitudeLongitude
	 * @param province
	 * @param simpleName
	 * @param hazardSourceRange
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandUnitsAdd", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String groupLandUnitsAdd(
			HttpServletRequest request,
			@Param(value = "companyName ") String companyName,
			@Param(value = "twoUnits") String twoUnits,
			@Param(value = "city") String city,
			@Param(value = "companyProfile") String companyProfile,
			@Param(value = "hazardSource") String hazardSource,
			@Param(value = "staffSituation") String staffSituation,
			@Param(value = "holdingSituation") String holdingSituation,
			@Param(value = "safety") String safety,
			@Param(value = "risk") String risk,
			@Param(value = "dangerousChemicalRange") String dangerousChemicalRange,
			@Param(value = "picture") String picture,
			@Param(value = "sipNumber") String sipNumber,
			@Param(value = "latitudeLongitude") String latitudeLongitude,
			@Param(value = "province") String province,
			@Param(value = "simpleName") String simpleName,
			@Param(value = "hazardSourceRange") String hazardSourceRange) {
		List<SystemCorp> list = new ArrayList<SystemCorp>();
		Json result = new Json();
		JSONObject object = null;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// 根据密码登录,返回用户对象，判断密码和用户名是否正�?
		SystemCorp systemCorp = new SystemCorp();
		systemCorp.setScCity(city);
		systemCorp.setScChemicalInfo(dangerousChemicalRange);
		systemCorp.setScAntiRisk(risk);
		systemCorp.setScHolding(holdingSituation);
		systemCorp.setScInfo(companyProfile);
		systemCorp.setScProvince(province);
		systemCorp.setScPname(twoUnits);
		systemCorp.setScSafeResponsib(safety);
		systemCorp.setScTopId(sipNumber);
		systemCorp.setCreateTime(format.format(new Date()));
		if (ValidateUtil.isNullAndIsStr(latitudeLongitude)) {
			String[] str = latitudeLongitude.split(",");
			systemCorp.setScLatitude(str[0]);
			systemCorp.setScLongitude(str[1]);
		}
		if (null != request.getSession().getAttribute("systemUser")) {
			request.getSession().getAttribute("systemUser");
			try {
				systemCorpServiceImpl.insertSelective(systemCorp);
				object = new JSONObject();
				object.put("failureMessage", null);
				object.put("success", true);
			} catch (Exception e1) {
				object = new JSONObject();
				object.put("failureMessage", Json.ADD_FAIL);
				object.put("success", false);
				e1.printStackTrace();
			}

		} else {
			object = new JSONObject();
			object.put("failureMessage", Json.LOG_FAIL);
			object.put("success", false);
		}
		return JSONObject.toJSONString(object);

	}

	/**
	 * 单位修改 String
	 * 
	 * @author CEICT
	 * @param request
	 * @param companyName
	 * @param twoUnits
	 * @param city
	 * @param companyProfile
	 * @param hazardSource
	 * @param staffSituation
	 * @param holdingSituation
	 * @param safety
	 * @param risk
	 * @param dangerousChemicalRange
	 * @param picture
	 * @param sipNumber
	 * @param latitudeLongitude
	 * @param province
	 * @param simpleName
	 * @param hazardSourceRange
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandUnitsUpdate", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String groupLandUnitsUpdate(
			HttpServletRequest request,
			@Param(value = "companyName ") String companyName,
			@Param(value = "twoUnits") String twoUnits,
			@Param(value = "city") String city,
			@Param(value = "companyProfile") String companyProfile,
			@Param(value = "hazardSource") String hazardSource,
			@Param(value = "staffSituation") String staffSituation,
			@Param(value = "holdingSituation") String holdingSituation,
			@Param(value = "safety") String safety,
			@Param(value = "risk") String risk,
			@Param(value = "dangerousChemicalRange") String dangerousChemicalRange,
			@Param(value = "picture") String picture,
			@Param(value = "sipNumber") String sipNumber,
			@Param(value = "latitudeLongitude") String latitudeLongitude,
			@Param(value = "province") String province,
			@Param(value = "simpleName") String simpleName,
			@Param(value = "hazardSourceRange") String hazardSourceRange) {
		List<SystemCorp> list = new ArrayList<SystemCorp>();
		Json result = new Json();
		JSONObject object = null;
		// 根据密码登录,返回用户对象，判断密码和用户名是否正�?
		SystemCorp systemCorp = new SystemCorp();
		systemCorp.setScCity(city);
		systemCorp.setScChemicalInfo(dangerousChemicalRange);
		systemCorp.setScAntiRisk(risk);
		systemCorp.setScHolding(holdingSituation);
		systemCorp.setScInfo(companyProfile);
		systemCorp.setScProvince(province);
		systemCorp.setScPname(twoUnits);
		systemCorp.setScSafeResponsib(safety);
		systemCorp.setScTopId(sipNumber);
		if (ValidateUtil.isNullAndIsStr(latitudeLongitude)) {
			String[] str = latitudeLongitude.split(",");
			systemCorp.setScLatitude(str[0]);
			systemCorp.setScLongitude(str[1]);
		}
		if (null != request.getSession().getAttribute("systemUser")) {
			request.getSession().getAttribute("systemUser");
			try {
				Json json = systemCorpServiceImpl
						.updateByPrimaryKeySelective(systemCorp);
				object = new JSONObject();
				object.put("failureMessage", null);
				object.put("success", true);
			} catch (Exception e1) {
				object = new JSONObject();
				object.put("failureMessage", Json.UPDATE_FAIL);
				object.put("success", false);
				e1.printStackTrace();
			}

		} else {
			object = new JSONObject();
			object.put("failureMessage", Json.LOG_FAIL);
			object.put("success", false);
		}
		return JSONObject.toJSONString(object);

	}

	/**
	 * 单位删除 String
	 * 
	 * @author CEICT
	 * @param request
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandUnitsDelete", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String groupLandUnitsDelete(HttpServletRequest request,

	@Param(value = "ids") String ids) {
		long key = Long.parseLong(request.getParameter("ids"));
		Json result = new Json();
		JSONObject object = null;
		if (null != request.getSession().getAttribute("systemUser")) {
			request.getSession().getAttribute("systemUser");
			try {
				Json json = systemCorpServiceImpl.deleteBatchByPrimaryKey(ids);
				object = new JSONObject();
				object.put("failureMessage", null);
				object.put("success", true);
			} catch (Exception e1) {
				object = new JSONObject();
				object.put("failureMessage", Json.DEL_FAIL);
				object.put("success", false);
				e1.printStackTrace();
			}

		} else {
			object = new JSONObject();
			object.put("failureMessage", Json.LOG_FAIL);
			object.put("success", false);
		}
		return JSONObject.toJSONString(object);

	}

	/**
	 * 摄像头添�? String
	 * 
	 * @author CEICT
	 * @param request
	 * @param name
	 * @param sipNumber
	 * @param unitSipNumber
	 * @param equiCode
	 * @param unit
	 * @param webUrl
	 * @param webSiteName
	 * @param webSiteWord
	 * @param nvrName
	 * @param nvrWord
	 * @param picture
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandSxtAdd", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String groupLandSxtAdd(HttpServletRequest request,
			@Param(value = "name ") String name,
			@Param(value = "sipNumber") String sipNumber,
			@Param(value = "unitSipNumber") String unitSipNumber,
			@Param(value = "equiCode") String equiCode,
			@Param(value = "unit") String unit,
			@Param(value = "webUrl") String webUrl,
			@Param(value = "webSiteName") String webSiteName,
			@Param(value = "webSiteWord") String webSiteWord,
			@Param(value = "nvrName") String nvrName,
			@Param(value = "nvrWord") String nvrWord,
			@Param(value = "picture") String picture) {
		List<SystemCorp> list = new ArrayList<SystemCorp>();
		Json result = new Json();
		JSONObject object = null;
		// 根据密码登录,返回用户对象，判断密码和用户名是否正�?
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SystemCamera systemCamera = new SystemCamera();
		systemCamera.setScCorpId(Long.valueOf(unitSipNumber));
		systemCamera.setScName(name);
		systemCamera.setScNvrName(nvrName);
		systemCamera.setScSipNum(sipNumber);
		systemCamera.setScWebLink(webUrl);
		systemCamera.setScLoginName(webSiteName);
		systemCamera.setScLoginPwd(webSiteWord);
		systemCamera.setScNvrPwd(nvrWord);
		systemCamera.setCreateTime(format.format(new Date()));
		if (null != request.getSession().getAttribute("systemUser")) {
			request.getSession().getAttribute("systemUser");
			try {
				Json json = systemCameraServiceImpl
						.insertSelective(systemCamera);
				object = new JSONObject();
				object.put("failureMessage", null);
				object.put("success", true);
			} catch (Exception e1) {
				object = new JSONObject();
				object.put("failureMessage", Json.ADD_FAIL);
				object.put("success", false);
				e1.printStackTrace();
			}

		} else {
			object = new JSONObject();
			object.put("failureMessage", Json.LOG_FAIL);
			object.put("success", false);
		}
		return JSONObject.toJSONString(object);

	}

	/**
	 * 摄像头修�? String
	 * 
	 * @author CEICT
	 * @param request
	 * @param name
	 * @param sipNumber
	 * @param unitSipNumber
	 * @param equiCode
	 * @param unit
	 * @param webUrl
	 * @param webSiteName
	 * @param webSiteWord
	 * @param nvrName
	 * @param nvrWord
	 * @param picture
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandSxtUpdate", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String groupLandSxtUpdate(HttpServletRequest request,
			@Param(value = "name ") String name,
			@Param(value = "sipNumber") String sipNumber,
			@Param(value = "unitSipNumber") String unitSipNumber,
			@Param(value = "equiCode") String equiCode,
			@Param(value = "unit") String unit,
			@Param(value = "webUrl") String webUrl,
			@Param(value = "webSiteName") String webSiteName,
			@Param(value = "webSiteWord") String webSiteWord,
			@Param(value = "nvrName") String nvrName,
			@Param(value = "nvrWord") String nvrWord,
			@Param(value = "picture") String picture) {
		List<SystemCorp> list = new ArrayList<SystemCorp>();
		Json result = new Json();
		JSONObject object = null;
		// 根据密码登录,返回用户对象，判断密码和用户名是否正�?
		SystemCamera systemCamera = new SystemCamera();
		systemCamera.setScCorpId(Long.valueOf(unitSipNumber));
		systemCamera.setScName(name);
		systemCamera.setScNvrName(nvrName);
		systemCamera.setScSipNum(sipNumber);
		systemCamera.setScWebLink(webUrl);
		systemCamera.setScLoginName(webSiteName);
		systemCamera.setScLoginPwd(webSiteWord);
		systemCamera.setScNvrPwd(nvrWord);
		if (null != request.getSession().getAttribute("systemUser")) {
			request.getSession().getAttribute("systemUser");
			try {
				Json json = systemCameraServiceImpl
						.updateByPrimaryKeySelective(systemCamera);
				object = new JSONObject();
				object.put("failureMessage", null);
				object.put("success", true);
			} catch (Exception e1) {
				object = new JSONObject();
				object.put("failureMessage", Json.UPDATE_FAIL);
				object.put("success", false);
				e1.printStackTrace();
			}

		} else {
			object = new JSONObject();
			object.put("failureMessage", Json.LOG_FAIL);
			object.put("success", false);
		}
		return JSONObject.toJSONString(object);

	}

	/**
	 * 摄像头删�?
	 * 
	 * @param request
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandSxtDelete", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String groupLandSxtDelete(HttpServletRequest request,

	@Param(value = "ids") String ids) {
		long key = Long.parseLong(request.getParameter("ids"));
		Json result = new Json();
		JSONObject object = null;
		if (null != request.getSession().getAttribute("systemUser")) {
			request.getSession().getAttribute("systemUser");
			try {
				Json json = systemCameraServiceImpl
						.deleteBatchByPrimaryKey(ids);
				object = new JSONObject();
				object.put("failureMessage", null);
				object.put("success", true);
			} catch (Exception e1) {
				object = new JSONObject();
				object.put("failureMessage", Json.DEL_FAIL);
				object.put("success", false);
				e1.printStackTrace();
			}

		} else {
			object = new JSONObject();
			object.put("failureMessage", Json.LOG_FAIL);
			object.put("success", false);
		}
		return JSONObject.toJSONString(object);

	}

	/**
	 * 单位查询
	 * 
	 * @param request
	 * @param simpleName
	 * @param hazardSource
	 * @param twoUnits
	 * @param province
	 * @param address
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandUnitsQuery", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String groupLandUnitsQuery(HttpServletRequest request,
			@Param(value = "simpleName") String simpleName,
			@Param(value = "hazardSource") String hazardSource,
			@Param(value = "twoUnits") String twoUnits,
			@Param(value = "province") String province,
			@Param(value = "address") String address,
			@Param(value = "pageSize") String pageSize,
			@Param(value = "page") String page) {
		String json = "";
		JSONObject object = null;
		if (null != request.getSession().getAttribute("systemUser")) {
			try {
				SystemCorp systemCorpO = new SystemCorp();
				systemCorpO.setScInfo(simpleName);
				systemCorpO.setScHazardInfo(hazardSource);
				systemCorpO.setScPname(twoUnits);
				systemCorpO.setScProvince(province);
				systemCorpO.setScAddress(address);
				// 判断是否有查询条�?
				if (ValidateUtil.isNullAndIsStr(systemCorpO)) {
                   System.out.println( );
				}
				// 条件+分页查询
				json = systemCorpServiceImpl.selectSystemCorpByPage(
						systemCorpO, PageUtil.getPageBean(page, pageSize));
			} catch (Exception e) {
				Json result = new Json();
				result.setMsg(Json.EXCEPTION);
				result.setSuccess(false);
				json = JSONObject.toJSONString(result);
				e.printStackTrace();
			}
		} else {
			object = new JSONObject();
			object.put("failureMessage", Json.LOG_FAIL);
			object.put("success", false);
		}
		return json;

	}

	/**
	 * 摄像头查�?
	 * 
	 * @param request
	 * @param simpleName
	 * @param equiCode
	 * @param name
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/groupLandUnits/groupLandSxtQuery", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String groupLandSxtQuery(HttpServletRequest request,
			@Param(value = "simpleName") String simpleName,
			@Param(value = "equiCode") String equiCode,
			@Param(value = "name") String name,
			@Param(value = "pageSize") String pageSize,
			@Param(value = "page") String page) {
		List<SystemCorp> corplist = new ArrayList<SystemCorp>();
		String json = "";
		JSONObject object = null;
		if (null != request.getSession().getAttribute("systemUser")) {
			try {
				SystemCamera systemCamera = new SystemCamera();
				systemCamera.setScName(name);
				systemCamera.setScNum(equiCode);
				SystemCorp systemCorp = new SystemCorp();
				systemCorp.setScInfo(simpleName);
				systemCamera.setCorp_id(systemCorp);
				// 判断是否有查询条�?
				if (ValidateUtil.isNullAndIsStr(systemCamera)) {

				}
				// 条件+分页查询
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("scName", simpleName);
				String sid = "";
				corplist = systemCorpServiceImpl.selectCorpTwoUnits(null,
						simpleName);
				for (int i = 0; i < corplist.size(); i++) {
					sid += corplist.get(i).getScId() + ",";
				}
				System.out.println(sid);
				json = systemCameraServiceImpl.selectByGroup(sid,
						PageUtil.getPageBean(page, pageSize));
			} catch (Exception e) {
				Json result = new Json();
				result.setMsg(Json.EXCEPTION);
				result.setSuccess(false);
				json = JSONObject.toJSONString(result);
				e.printStackTrace();
			}
		} else {
			object = new JSONObject();
			object.put("failureMessage", Json.LOG_FAIL);
			object.put("success", false);
		}
		return json;

	}
}