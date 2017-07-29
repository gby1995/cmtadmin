package com.altra.secuity.services.common.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogBackServiceImpl implements ILogBackService{
	static final Logger log = LoggerFactory.getLogger(LogBackServiceImpl.class);
	/**
	 * 平台日志调用
	 * 
	 * @message 日志信息
	 * @author boolen false不过滤   true过滤
	 */
    public void PlatformLogBack(String message,boolean lb){  
    	if(lb==false){
    		log.info(message);
    	}
    } 
	/**
	 * 其他日志调用
	 * 
	 * @message 日志信息
	 * @author boolen false不过滤   true过滤
	 */
    public void OtherLogBack(String message,boolean lb){  
    	if(lb==false){
    		log.warn(message);
    	}
    } 
	/**
	 * 异常日志调用
	 * 
	 * @message 日志信息
	 * @e 异常堆栈
	 * @author boolen false不过滤   true过滤
	 */
    public void ExceptionLogBack(String message,Exception e,boolean lb){  
    	if(lb==false){
    		log.error(message,e);  
    	}
    } 
    
	/**
	 * 第三方接口日志调用
	 * 
	 * @message 日志信息
	 * @author boolen false不过滤   true过滤
	 */
    public void InterfaceLogBack(String message,boolean lb){  
    	if(lb==false){
    		log.debug(message);  
    	}
    } 
}
