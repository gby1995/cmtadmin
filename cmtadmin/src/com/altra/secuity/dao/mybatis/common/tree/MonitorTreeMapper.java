package com.altra.secuity.dao.mybatis.common.tree;

import java.util.List;
import com.altra.secuity.model.common.TreeBean;

public interface MonitorTreeMapper {

	/**
	 * 根据企业主键查询获取当前危险源树菜单
	 * @date 2016.02.14
	 */
	List<TreeBean> selectByPrimaryKeyFromCorpId(long cropId);
	/**
	 * 根据危险源主键查询获取当前设备树菜单
	 * @date 2016.02.14
	 */
	List<TreeBean> selectByPrimaryKeyFromAppId(long appId);
	
	/**
	 * 根据公司ID获取企业树菜单
	 * @date 2016.03.15
	 */
	List<TreeBean> gettopCorpTree(Long corpId);
}