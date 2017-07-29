/**
 * 
 */
package com.altra.common.util.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.altra.common.util.page.ValidateUtil;
import com.altra.secuity.model.system.SystemUser;


/**
 * 请求对象工具类
 */
public class RequestUtil {
	 
	/**
	 * 根据session获取当前用户信息
	 * @param request
	 * @return
	 */
	public static SystemUser getAccount(HttpServletRequest request){
		if(ValidateUtil.isNullAndIsStr(request.getSession().getAttribute("systemUser"))){
			return (SystemUser)request.getSession().getAttribute("systemUser");
		}else{
			return new SystemUser();
		}
	}
	
    /**
     * 取小数点后一位
     * @param data
     * @return
     */
    public static String getDoubleData(Double data){
    	java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#0.0");
        try {
			String d = data == null ? "0" : df.format(data) + "";
			return d;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
        return "0";
    }
    
    //时间转换(string--->long)
	public static long ChangeDateString(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date aa = null;
		try {
			aa = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aa.getTime() / 1000;
	}
}
