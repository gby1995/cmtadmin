package com.altra.secuity.model.common;

import com.alibaba.fastjson.annotation.JSONField;

public class HyBasictype implements java.io.Serializable{
    /**
	 * 数据字典类型
	 * @author baitao
	 * @date 2016.7.14
	 */
	private static final long serialVersionUID = 1L;
	// id
	@JSONField(name="tId")
	private Long tId;
	// 名称
	@JSONField(name="tName")
	private String tName;
    // 备注
	@JSONField(name="tCommon")
	private String tCommon;

    
	@JSONField(name="tId")
    public Long gettId() {
		return tId;
	}
	@JSONField(name="tId")
	public void settId(Long id) {
		tId = id;
	}

	@JSONField(name="tName")
    public String gettName() {
        return tName;
    }
	@JSONField(name="tName")
    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }
	@JSONField(name="tCommon")
    public String gettCommon() {
        return tCommon;
    }
	@JSONField(name="tCommon")
    public void settCommon(String tCommon) {
        this.tCommon = tCommon == null ? null : tCommon.trim();
    }
}