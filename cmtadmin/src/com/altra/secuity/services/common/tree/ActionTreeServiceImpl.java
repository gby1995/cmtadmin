package com.altra.secuity.services.common.tree;

/**
 * 树结构service层接口
 * 
 * @author baitao 2017/7/15
 * 
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.altra.common.util.page.PageUtil;
import com.altra.secuity.dao.mybatis.common.tree.ActionTreeMapper;
import com.altra.secuity.model.common.TreeBean;
import com.altra.secuity.model.system.SystemUser;

@Service
public class ActionTreeServiceImpl implements ITreeService {
	@Resource
	private ActionTreeMapper actionTreeMapper;

	/**
	 * 根据当前用户获取权限菜单树
	 * 
	 * @param account
	 * @return
	 */
	public String selectTreeNodeByUser(SystemUser systemUser) throws Exception {
		// 调用DAO查询普通权限下根分组
		Map<String, String> map = new HashMap<String, String>();
		map.put("actType", "1");
		map.put("userId", String.valueOf(systemUser.getUserId()));
		List<TreeBean> trees = actionTreeMapper.selectTreeNodeByUser(map);
		

		return PageUtil.getResultJsonArray(trees);
	}

}
