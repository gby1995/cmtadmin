package com.altra.common.redis;
/****
 * redis存储数据key管理
 * @author Administrator
 *
 */
public class RedisKey {
     public final static String TRADE_="TRADES_"; //行业类型
     public final static String BUSSINESTYPE_="BUSSINESTYPE_"; //企业类型
     public final static String PRODUTIVE_="PRODUTIVE_";  //生产用途
     public final static String TRADES_SEC_="TRADES_SEC_";  //行业类型二级
     public final static String FIELD_="FIELD_";  //行业领域
     public final static String ECOTY_="ECOTY_";  //经济类型
     public final static String COMDEP_="COMDEP_"; //行业主管部门
     public final static String HSTY_="HSTY_";  //危化品单位类型
     public final static String SCALE_="SCALE_";  //企业规模
     public final static String LICENCENAME_="LICENCENAME_";  //证照名称
     public final static String STATE_="STATE_";  //状态
     public final static String APPLYTYPE_="APPLYTYPE_";  //备案申请类型
     public final static String CHEMICALTYPE_="CHEMICALTYPE_";  //危险化学品单位类型
     public final static String MATERIALS_="MATERIALS_";  //备案材料清单
     public final static String APPCANCEL_="APPCANCEL_";  //核销申请附件
     public final static String  SYSTEMHSDEVICE_="SYSTEMHSDEVICE_";  //传感器设备
     
     /**
 	 * redis分区定义 
 	 */
      public static int  tradeindex=1;  //行业类型
      public static int  bussinessTypeindex=2;  //行业类型
      public static int  productiveindex=3;  //生产用途
      public static int  tradesecindex=4;  //行业类型二级 
      public static int  fieldindex=5;  //行业领域
      public static int  ecotyindex=6; //经济类型
      public static int  comdepindex=7;  //行业主管部门
      public static int  hstyindex=8;  //危化品单位类型
      public static int  scaleindex=9; //企业规模
      public static int  licenceNameindex=10; //证照名称
      public static int  stateindex=11;  //状态
      public static int  applyTypeindex=12;  //备案申请类型
      public static int  chemicalTypeindex=13;  //危险化学品单位类型
      public static int  materialsindex=14;  //备案材料清单
      public static int  appcancelindex=15;  //核销申请附件
      public static int  systemHsDeviceindex=0;  //传感器设备
}
