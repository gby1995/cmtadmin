package com.altra.secuity.dao.mybatis.common.menu;

import java.util.List;
import java.util.Map;

import com.altra.secuity.model.common.MenuBean;

/**
 * 菜单接口
 * @author baitao 2017-02-16
 *
 */
public interface MenuMapper {
	 /**
     * 根据当前用户获取权限菜单树一级
     * @param account
     * @return
     */
	List<MenuBean> selectMenusByUser(Map<String,String> map);
	
	/**
	 * 根据一级菜单获取二级菜单
	 * @author baitao
	 * @date 2016.02.22
	 */
	List<MenuBean> selectChildMenusByUser(Map<String,String> map);
}
