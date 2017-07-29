package com.altra.secuity.services.common.tree;


/**
 * 实时监控危险源services层接口
 */
public interface IMonitorTreeService {

	/**
	 * 根据企业获取危险源 -> 设备树
	 * @param corpId
	 * @return
	 */
	String getHarzardTree(Long corpId);
	/**
	 * 根据危险源获取设备树
	 * @param corpId
	 * @return
	 */
	String getDevTree(Long appId);
	
	/**
	 * 根企業ID获取企业树
	 * @param town
	 * @return
	 */
	public String gettopCorpTree(Long corpId);
}