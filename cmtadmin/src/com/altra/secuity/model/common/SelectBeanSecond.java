package com.altra.secuity.model.common;

import java.util.List;

/**
 * 二级下拉框
 * @author liuben
 *
 */
public class SelectBeanSecond {
	
	private List<SelectBean> name;
	
	private String value;
	
	public SelectBeanSecond() {
	}

	public List<SelectBean> getName() {
		return name;
	}

	public void setName(List<SelectBean> name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	 
	

}
