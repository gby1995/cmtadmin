package com.altra.secuity.dao.mybatis.common.tree;

import java.util.List;
import java.util.Map;

import com.altra.secuity.model.common.TreeBean;

/**
 * 权限菜单树接口
 * @author baitao 2017-02-16
 *
 */
public interface ActionTreeMapper {
	 /**
     * 根据当前用户获取权限菜单树
     * @param account
     * @return
     */
	List<TreeBean> selectTreeNodeByUser(Map<String,String> map);
	
	/**
	 * 根据主键查询获取当前角色树菜单
	 * @author liuben
	 * @date 2016.02.14
	 * @param roleId
	 * @return SystemRole
	 */
	List<TreeBean> selectByPrimaryKeyFromRoleId(Map<String,String> map);
}
