package com.altra.common.util.page;

/**
 * 
 * JSON模型 用户后台向前台返回的JSON对象
 * 
 * @author fwm 2016.7.11
 */
public class Json implements java.io.Serializable {

	public static String ADD_SUCCESS = "添加成功！";
	public static String UPDATE_SUCCESS = "修改成功！";
	public static String DEL_SUCCESS = "删除成功！";
	public static String ADD_FAIL = "添加失败！";
	public static String UPDATE_FAIL = "修改失败！";
	public static String DEL_FAIL = "删除失败！";
	public static String EXCEPTION = "操作异常！";
	public static String ISEXIST = "名称重复！";
	public static String OPT_SUCCESS = "操作成功！";
	public static String OPT_FAIL = "操作失败！";
	public static String LOG_FAIL = "未登录！";

	private static final long serialVersionUID = -6342433687279283059L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	// 返回操作的主键
	private String objId = "";
	
	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public boolean isSuccess() {
		return success;
	}

	public int code;
	
	
	public static String getADD_SUCCESS() {
		return ADD_SUCCESS;
	}

	public static void setADD_SUCCESS(String aDD_SUCCESS) {
		ADD_SUCCESS = aDD_SUCCESS;
	}

	public static String getUPDATE_SUCCESS() {
		return UPDATE_SUCCESS;
	}

	public static void setUPDATE_SUCCESS(String uPDATE_SUCCESS) {
		UPDATE_SUCCESS = uPDATE_SUCCESS;
	}

	public static String getDEL_SUCCESS() {
		return DEL_SUCCESS;
	}

	public static void setDEL_SUCCESS(String dEL_SUCCESS) {
		DEL_SUCCESS = dEL_SUCCESS;
	}

	public static String getADD_FAIL() {
		return ADD_FAIL;
	}

	public static void setADD_FAIL(String aDD_FAIL) {
		ADD_FAIL = aDD_FAIL;
	}

	public static String getUPDATE_FAIL() {
		return UPDATE_FAIL;
	}

	public static void setUPDATE_FAIL(String uPDATE_FAIL) {
		UPDATE_FAIL = uPDATE_FAIL;
	}

	public static String getDEL_FAIL() {
		return DEL_FAIL;
	}

	public static void setDEL_FAIL(String dEL_FAIL) {
		DEL_FAIL = dEL_FAIL;
	}

	public static String getEXCEPTION() {
		return EXCEPTION;
	}

	public static void setEXCEPTION(String eXCEPTION) {
		EXCEPTION = eXCEPTION;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
