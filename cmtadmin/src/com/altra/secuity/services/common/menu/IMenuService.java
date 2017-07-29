package com.altra.secuity.services.common.menu;

import java.util.List;

import com.altra.secuity.model.common.MenuBean;
import com.altra.secuity.model.system.SystemUser;



/**
 * 菜单结构service层接口
 * 
 * @author baitao 2017/7/15
 * 
 */
public interface IMenuService {
	 /**
     * 根据当前用户获取菜单
     * @param account
     * @return
     */
	List<MenuBean> selectMenusByUser(SystemUser systemUser) throws Exception;
	 /**
     * 根据当前用户获取菜单
     * @param account
     * @return
     */
	String selectChildMenusByUser(SystemUser systemUser,String pid) throws Exception;
	 
}
