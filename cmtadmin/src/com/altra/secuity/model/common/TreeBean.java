package com.altra.secuity.model.common;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class TreeBean implements Serializable {
	/**
	 * 树实体类
	 * 
	 * @author baitao 2017-02-15
	 * 
	 */
	private static final long serialVersionUID = 8772142209339712440L;

	// 树节点ID
	private String id;
	// 树节点名称
	private String name;
	// 父节点ID
	@JSONField(name="pId")
	private String pId;
	// 是否是目录
	private boolean isParent = false ;
	// 是否展开 - 默认关闭
	private boolean open = false ;
	// 是否展开 - 默认关闭
	private String icon;
	//是否选中 - 默认未选中
	private boolean checked=false;
	//皮肤
	private String iconSkin;
	
	//子树集合
	private List<TreeBean> treeBeans;
	
	public String getIconSkin() {
		return iconSkin;
	}
	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}
	public List<TreeBean> getTreeBeans() {
		return treeBeans;
	}
	public void setTreeBeans(List<TreeBean> treeBeans) {
		this.treeBeans = treeBeans;
	}
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JSONField(name="pId")
	public String getpId() {
		return pId;
	}
	@JSONField(name="pId")
	public void setpId(String pId) {
		this.pId = pId;
	}
	 
	public boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	

}