package com.altra.secuity.services.common.tree;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.altra.common.util.page.PageUtil;
import com.altra.secuity.dao.mybatis.common.tree.MonitorTreeMapper;
import com.altra.secuity.model.common.TreeBean;

@Service
public class MonitorTreeServiceImpl implements IMonitorTreeService {
	@Resource
	private MonitorTreeMapper monitorTreeMapper;
	
	/**
	 * 根据企业获取危险源 -> 设备树
	 * @param corpId
	 * @return
	 */
	@Override
	public String getHarzardTree(Long corpId) {
		// 根据企业获取危险源树
		List<TreeBean> harzardTree = monitorTreeMapper.selectByPrimaryKeyFromCorpId(corpId);
		return PageUtil.getResultJsonArray(harzardTree);
	}

	/**
	 * 根据危险源获取设备树
	 * @param corpId
	 * @return
	 */
	@Override
	public String getDevTree(Long appId) {
		List<TreeBean> harzardTree = new ArrayList<TreeBean>();
		// 根据危险源获取设备树
		List<TreeBean> treesec = monitorTreeMapper.selectByPrimaryKeyFromAppId(appId);
		for(TreeBean sec : treesec){
			if("1".equals(sec.getName().split(",")[1])){
				sec.setName(sec.getName().split(",")[0]+" "+"可燃气体传感器");
			}else if("2".equals(sec.getName().split(",")[1])){
				sec.setName(sec.getName().split(",")[0]+" "+"有毒气体传感器");
			}else if("3".equals(sec.getName().split(",")[1])){
				sec.setName(sec.getName().split(",")[0]+" "+"温度传感器");
			}else if("4".equals(sec.getName().split(",")[1])){
				sec.setName(sec.getName().split(",")[0]+" "+"压力传感器");
			}else if("5".equals(sec.getName().split(",")[1])){
				sec.setName(sec.getName().split(",")[0]+" "+"液位传感器");
			}
			sec.setId("dev_"+sec.getId());
			sec.setOpen(true);
			harzardTree.add(sec);
//			TreeBean tb1 = new TreeBean();
//			tb.setId(sec.getId()+":140");
//			tb.setpId(sec.getId());
//			tb.setName("汽油气");
//			harzardTree.add(sec);
//			//----
//			TreeBean tb2 = new TreeBean();
//			tb.setId(sec.getId()+":141");
//			tb.setpId(sec.getId());
//			tb.setName("天然气");
//			harzardTree.add(sec);
//			//---
//			TreeBean tb3 = new TreeBean();
//			tb.setId(sec.getId()+":142");
//			tb.setpId(sec.getId());
//			tb.setName("甲醇");
//			harzardTree.add(sec);
//			//---
//			TreeBean tb4 = new TreeBean();
//			tb.setId(sec.getId()+":143");
//			tb.setpId(sec.getId());
//			tb.setName("乙醇");
//			harzardTree.add(sec);
			
		}
		return PageUtil.getResultJsonArray(harzardTree);
	}
	
	/**
	 * 根企業ID获取企业树
	 * @param town
	 * @return
	 */
	@Override
	public String gettopCorpTree(Long corpId) {
		List<TreeBean> corpTree = monitorTreeMapper.gettopCorpTree(corpId);
		return  PageUtil.getResultJsonArray(corpTree);
	}

}
