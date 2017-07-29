package com.altra.common.util.redis;

import java.util.Hashtable;
import java.util.Map;


public class Constants {
	/** redis最大活动链接 */
	public static int REDIS_MAX_ACTIVE = 500;
	/** redis最大ide */
	public static int REDIS_MAX_IDLE = 50;
	/**  redis最大等待时间  */
	public static long REDIS_MAX_WAIT = 100;
	/**  redis测试  */
	public static boolean TEST_ON_BORROW = true;
	/*****redis IP****/
	public static String REDIS_IP="192.168.66.26";//"192.168.66.82";
	//public static String REDIS_IP="127.0.0.1";
	/*****redis端口*****/
	public static int REDIS_PORT=6379;
	/** 应用程序物理磁盘绝对地址 */
	public static String APP_ROOT_PATH = "";
	public static String webBasePath="";//web发布url路径
	public static String basePath="";//项目物理路径
	public static String resourcePathName="";
	/** 图片服务器物理磁盘地址 */
	public static String uploadServerPath = "";
	/** 图片服务器地址 */
	public static String upload = "http://192.168.18.148:808/";
	/** 是否打印流水日志 */
	public static boolean isPrint = true;
	/** 图片缓存扫描间隔 */
	public static int PhotoGaphCacheTime = 300;
	/** 图片缓存过期时间 */
	public static int PhotoGaphExpiredTime = 300;
	/** 硬件服务器与安装服务的映射关系表 */
	public static Map<String, String> SoftHardMapping = new Hashtable<String, String>();
	/**是否启动Ip拦截器*/
	public static boolean isInterceptor = false;
	/**平台是否开机启动*/
	public static boolean isBoot = false;
	/**第八时区问题*/
	public static long TimeZone = 8*60*60L;
	/****位置云登陆用户名****/
	public static String userName="";
	/****位置云登陆密码****/
	public static String passWord="";
	/****位置云登陆服务分区编码****/
	public static int  areaCode=0;
	/**服务站查询默认范围值*/
	public static int SERVICE_STATION_DIS_RANGE=10000;//单位为米
	/**服务站负荷能力默认值*/
	public static int SERVICE_STATION_OVERLOAD=200;
	/** APP版本升级版本号 */
	public static String androidVersion = "1.0";
	public static String iosVersion = "1.0";
	/**
	 * 一级分隔符 0x08 0x07 0x07 \||
	 */
	public final static String FIRST_CHAR = (char) 0x08 + "" + (char) 0x07 + ""
			+ (char) 0x07; // "";

	/**
	 * 二級分割符 0x08 0x06 \|
	 */
	public final static String SECOND_SPLIT = (char) 0x08 + "" + (char) 0x07;

	/**
	 * 三级 分隔内容项为若干行 0x08  \
	 */
	public final static String THIRD_SPLIT_CHAR = ((Character) ((char) 0x08))
			.toString();// "";

	/**
	 * 四级分隔符 0x07 |
	 */
	public final static String FOURTH_SPLIT_CHAR = ((Character) ((char) 0x07))
			.toString();
	/**
	 * 结束符 ox1A ox1A 
	 */
	public final static String END_CHAR = (char) 0x1A + "" + (char) 0x1A; // "";
	
	/**
	 * 是否过滤日志 默认为不过滤
	 */
	public final static boolean LogBack =false;
	
	
	//摄像头用户名

	//摄像头密码
	
}
