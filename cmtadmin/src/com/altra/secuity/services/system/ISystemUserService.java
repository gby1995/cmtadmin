package com.altra.secuity.services.system;

import com.altra.common.util.page.Json;
import com.altra.common.util.page.PageUtil;
import com.altra.secuity.model.system.SystemUser;

public interface ISystemUserService {

	/**
	 * ��������ɾ��
	 * 
	 * @param userId
	 * @return
	 */
	Json deleteByPrimaryKey(Long userId) throws Exception;
	
	/**
	 * ������������ɾ��
	 * 
	 * @param list
	 * @return
	 */
	Json deleteBatchByPrimaryKey(String userId) throws Exception;
	
	/**
	 * ����
	 * @param record
	 * @return
	 */
	Json insertSelective(SystemUser record) throws Exception;
	
	/**
	 * ����������ѯ����
	 * @param userId
	 * @return
	 */
	SystemUser selectByPrimaryKey(Long userId) throws Exception;
	
    /**
     * �޸�
     * @param record
     * @return
     */
	Json updateByPrimaryKeySelective(SystemUser record) throws Exception;
	
    /**
     * ��ҳ��ѯ�����б�
     * @param record
     * @param page
     * @return
     */
	String selectSystemUserByPage(SystemUser record, PageUtil page) throws Exception;
	 
	/**
	  * �����û��������ѯ�û�
	  * @author liuben
	  * @date 2016.02.07 
	  * @param systemUser
	  * @return SystemUser
	  */
	SystemUser selectUserByPwd(SystemUser systemUser) throws Exception;
}