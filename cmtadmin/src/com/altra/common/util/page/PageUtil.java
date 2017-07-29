package com.altra.common.util.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;

/**
 * 分页封装对象类
 * @author baitao
 *
 */
public class PageUtil {
	
	// 结束值
	private int maxIndex;
	// 起始值
	private int startIndex;
	// 当前页
	private int page;
	// 每页取多少条
	private int rows;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getMaxIndex() {
		return maxIndex;
	}
	public void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	/**
	 * 根据请求对象自动封装返回分页对象
	 * @author baitao
	 * @date 2016.7.10 
	 * @param request
	 * @return PageUtil
	 */
	public static PageUtil getPageBean(HttpServletRequest request){
		int page = 1;
		if(request.getParameter("page") != null && !"".equals(request.getParameter("page")))
		 page = Integer.parseInt(request.getParameter("page"));
		int rows = 10;
		if(request.getParameter("page") != null && !"".equals(request.getParameter("page")))
		 rows = Integer.parseInt(request.getParameter("rows"));
		PageUtil pageBean = new PageUtil();
		pageBean.setStartIndex((page - 1) * rows);
		pageBean.setMaxIndex(page * rows);
		pageBean.setPage(page);
		pageBean.setRows(rows);
		return pageBean;
	}
	/**
	 * PageUtil
	 * @author CEICT
	 * @param pages
	 * @param pageSize
	 * @return
	 */
	public static PageUtil getPageBean(String pages,String pageSize){
		int page=1;
		if(pages != null && !"".equals(pages))
		page = Integer.parseInt(pages);
		int rows = 10;
		if(pages != null && !"".equals(pages))
		rows = Integer.parseInt(pageSize);
		PageUtil pageBean = new PageUtil();
		pageBean.setStartIndex((page - 1) * rows);
		pageBean.setMaxIndex(page * rows);
		pageBean.setPage(page);
		pageBean.setRows(rows);
		return pageBean;
	}
	
	
	/**
	 *  将查询结果封装成json对象数组
	 * @author baitao
	 * @date 2016.7.10  
	 * @param list
	 * @param count
	 * @param pages
	 * @return String
	 */
	public static String getResultJsonArray(Object list,int count,int pages){
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map 
		jsonMap.put("rows", list);// rows键 存放每页记录 list 
		int total = 0;
		if (count % 10 == 0) {
			total = count / 10;
		} else {
			total = count / 10 + 1;
		}
		jsonMap.put("page", pages);// rows键 存放每页记录 list
		jsonMap.put("total", total);// rows键 存放每页记录 list 
		jsonMap.put("records", count);// rows键 存放每页记录 list 
		String jsonArray = JSON.toJSONString(jsonMap);// 格式化result 
		return jsonArray;
	}
	
	/**
	 * 将主键封装成对象,用于删除多个对象或一个时使用
	 * @author baitao
	 * @date 2016.7.10 
	 * @param list
	 * @param count
	 * @param pages
	 * @return List<String>
	 */
	public static List<String> getIdsForList(String ids){
	List<String> list = new ArrayList<String>();
	String[] idsString = ids.split(",");
	for (int i = 0; i < idsString.length; i++) {
		list.add(idsString[i]);
	}
	return list;
	}
	/**
	 *  将查询结果封装成json对象数组
	 * @author baitao
	 * @date 2016.7.10  
	 * @param list
	 * @param count
	 * @param pages
	 * @return String
	 */
	public static String getResultJsonArray(Object list){
		String jsonArray = JSON.toJSONString(list);// 格式化result 
		return jsonArray;
	}
	/**
	 *  将查询结果封装成json对象数组
	 * @author baitao
	 * @date 2016.7.17  
	 * @param obj
	 * @param count
	 * @param pages
	 * @return String
	 */
	public static String getResultJsonObj(Object obj){
		String jsonArray = JSON.toJSONString(obj);// 格式化result 
		return jsonArray;
	}
}
