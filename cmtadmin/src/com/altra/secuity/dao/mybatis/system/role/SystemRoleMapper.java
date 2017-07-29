package com.altra.secuity.dao.mybatis.system.role;

import java.util.List;
import java.util.Map;

import com.altra.secuity.model.system.SystemRole;

public interface SystemRoleMapper {

	 
     /*****
     *根据主键查询
     ****/
     SystemRole selectByPrimaryKey(Long srId);
	
	 /****
	 *根据主键删除
	 ****/
     int deleteByPrimaryKey(Long srId);
     
     /****
	 *根据主键批量删除
	 ****/
     int deleteBatchByPrimaryKey(List<String> list);
     
     /****
	 *新增
	 ****/
     int insertSelective(SystemRole record);
     
     /****
	 *根据属性分页查询
	 ****/
     List<SystemRole> selectByPropertyByPage(Map map);
     
     /****
     *根据属性查询记录数
	 ****/
	 int selectCountByProperty(Map map); 
	 
	 /****
     *根据主键更新记录
	 ****/
	 int updateByPrimaryKeySelective(SystemRole record);
	 
	 /**
      * 根据属性分页查询 (与权限表联查)
      * @author liuben
      * @date 2016.02.14 
      * @param map
      * @return List<SystemRole>
      */
      List<SystemRole> selectByPropertyByPageByAction(Map map);
      
      /**
       * 根据属查询记录条数(与权限表联查)
       * @author liuben
       * @date 2016.02.14 
       * @param map
       * @return int
       */
 	 int selectCountByPropertyByAction(Map map); 
}