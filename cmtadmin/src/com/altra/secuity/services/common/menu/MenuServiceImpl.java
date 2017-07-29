package com.altra.secuity.services.common.menu;

/**
 * 树结构service层接口
 * 
 * @author baitao 2017/7/15
 * 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.altra.secuity.dao.mybatis.common.menu.MenuMapper;
import com.altra.secuity.model.common.MenuBean;
import com.altra.secuity.model.system.SystemUser;

@Service
public class MenuServiceImpl implements IMenuService {
	@Resource
	private MenuMapper menuMapper;
 
	 /**
     * 根据当前用户获取权限菜单树
     * @param account
     * @return
     */
	public List<MenuBean> selectMenusByUser(SystemUser systemUser)
			throws Exception {
		// 调用DAO查询普通权限下根分组
		Map<String,String> map = new HashMap<String,String>();
		map.put("actType", "1");
		map.put("userId",  String.valueOf(systemUser.getUserId()));
		List<MenuBean> menu = menuMapper.selectMenusByUser(map);
					return menu;
	}


	 /**
     * 根据当前用户获取菜单
     * @param account
     * @return
     */
	@Override
	public String selectChildMenusByUser(SystemUser systemUser, String pid)
			throws Exception {
				// 调用DAO查询普通权限下根分组
				Map<String,String> map = new HashMap<String,String>();
				map.put("actType", String.valueOf("1"));
				map.put("userId",  String.valueOf(systemUser.getUserId()));
				map.put("pid",  pid);
				List<MenuBean> menu = menuMapper.selectChildMenusByUser(map);
				List<MenuBean> menu1 =new ArrayList<MenuBean>();
				for(MenuBean m : menu){
					if(pid.equals(m.getPid())){
						menu1.add(m);
					} 
				}
				for(MenuBean m : menu){
					for(MenuBean ms : menu1){
					if(m.getPid().equals(ms.getId())){
						if(ms.getChildren() == null){
							List<MenuBean> menu2 =new ArrayList<MenuBean>();
							menu2.add(m);
							ms.setChildren(menu2);
						}else{
							List<MenuBean> menu2 =ms.getChildren();
							menu2.add(m);
							ms.setChildren(menu2);
						}
						
					} 
					}
				}
		return JSON.toJSONString(menu1);
	}



}
