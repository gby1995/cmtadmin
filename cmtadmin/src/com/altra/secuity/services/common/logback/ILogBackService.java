package com.altra.secuity.services.common.logback;

public interface ILogBackService {

	/**
	 * 平台日志调用
	 * 
	 * @message 日志信息
	 * @author boolen false不过滤   true过滤
	 */
	void PlatformLogBack(String message,boolean lb) throws Exception;
	/**
	 * 其他日志调用
	 * 
	 * @message 日志信息
	 * @author boolen false不过滤   true过滤
	 */
	void OtherLogBack(String message,boolean lb) throws Exception;
	/**
	 * 异常日志调用
	 * 
	 * @message 日志信息
	 * @e 异常堆栈
	 * @author boolen false不过滤   true过滤
	 */
	void ExceptionLogBack(String message,Exception e ,boolean lb) throws Exception;
	/**
	 * 第三方接口日志调用
	 * 
	 * @message 日志信息
	 * @e 异常堆栈
	 * @author boolen false不过滤   true过滤
	 */
	void InterfaceLogBack(String message,boolean lb) throws Exception;
}
