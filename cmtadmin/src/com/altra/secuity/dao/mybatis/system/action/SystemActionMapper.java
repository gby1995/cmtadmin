package com.altra.secuity.dao.mybatis.system.action;

import java.util.List;

import com.altra.secuity.model.system.SystemAction;

/**
 * 权限dao层接口（仅注册时使用）
 * @author liuben
 * @date 2017.03.10
 */
public interface SystemActionMapper {
	/**
	 * 全查询企业端所有权限（仅注册时使用）
	 * @author liuben
	 * @date 2017.03.10
	 */
	List<SystemAction> selectAllCorpAction();

}
