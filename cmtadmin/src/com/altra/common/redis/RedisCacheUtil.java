package com.altra.common.redis;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.altra.common.redis.JedisUtil.Lists;
import com.altra.common.redis.JedisUtil.Strings;

public class RedisCacheUtil {
	private static RedisCacheUtil redisCacheUtil=new RedisCacheUtil();
	Lists lists= null;
	Strings strings=null;
	
	RedisCacheUtil(){
		JedisUtil.init();
		lists= JedisUtil.getInstance().new Lists();
		strings=JedisUtil.getInstance().new Strings();
	}

	public static RedisCacheUtil getInstance(){
		return redisCacheUtil;
	}
	
	/****
	 * redis缓存加载 Map<keyStr+redisKey,RedisObject>
	 * @param keyStr 缓存标识
	 * @param unKey  唯一标识
	 * @param list   对象集合
	 * @return
	 */
	public Boolean loadlist(String keyStr,List<RedisObject> list,int... indexDB){
		try{
			if(keyStr!=null &&!keyStr.equals("")&&list!=null&& list.size()>0){
				clearCache(keyStr,indexDB);
				List<String> rlist= lists.lrange(keyStr, 0, -1,indexDB);
				List<String> rlist2= new ArrayList<String>();
				Map<String,Integer> rMap2=new HashMap<String,Integer>();
				//添加新
				String temps=null;
				for(int i=0;i<list.size();i++){
					temps=list.get(i).getRedisKey();
//					if(!rlist2.contains(keyStr+temps));{
					if(rMap2.get(keyStr+temps)==null){	
						 Long r=	lists.lpush(keyStr, keyStr+temps,indexDB);
						 if(r>0){
							strings.set(keyStr+temps,JSON.toJSONString(list.get(i)),indexDB);
						 }
						 rlist2.add(keyStr+temps);
						 rMap2.put(keyStr+temps, 1);
					}
				}
				//删除不存在的，rlist不在rlist2中的进行删除操作
				List<String> diff=getDiffrent(rlist,rlist2);
				for(int i=0;i<diff.size();i++){
					strings.del(diff.get(i),indexDB);
					lists.lrem(keyStr, 1, diff.get(i),indexDB);
				}
				rlist=null;
				rlist2=null;
				rMap2=null;
			}else{
				return false;
			}
		}catch(Exception e){
			
		}
		
		return true;
	}
	
	/*****************
	 * 缓存添加,修改
	 * @param keyStr
	 * @param obj
	 * @return
	 */
	public Boolean addCache(String keyStr,RedisObject obj,int... indexDB){
		try {
			if(keyStr!=null &&!keyStr.equals("")&&obj!=null){
				List<String> rlist= lists.lrange(keyStr, 0, -1,indexDB);
				Long r=0l;
				if(!rlist.contains(keyStr+obj.getRedisKey())){
					r=lists.lpush(keyStr, keyStr+obj.getRedisKey(),indexDB);
				}else{
					r=1l;
				}
				if(r>0){
				    strings.set(keyStr+obj.getRedisKey(),JSON.toJSONString(obj),indexDB);
				    return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/************
	 * 缓存删除
	 * @param keyStr
	 * @param obj
	 * @return
	 */
	public Boolean delCache(String keyStr,RedisObject obj,int...indexDB ){
		try {
			if(keyStr!=null &&!keyStr.equals("")&&obj!=null){
				List<String> rlist= lists.lrange(keyStr, 0, -1,indexDB);
				Long r=0l;
				if(rlist.contains(keyStr+obj.getRedisKey())){
					r=lists.lrem(keyStr,1, keyStr+obj.getRedisKey(),indexDB);
				}else{
					r=1l;
				}
				if(r>0){
				    strings.del(keyStr+obj.getRedisKey(),indexDB);
				    return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	/************
	 * 根据key查询缓存
	 * @param keyStr
	 * @param unKey
	 * @return
	 */
	public RedisObject getCache(String keyStr,String unKey,int... indexDB){
		try {
			RedisObject obj=null;
			String reideValue =null;
				reideValue = strings.get(keyStr+unKey,indexDB);
			if(reideValue!=null){
				obj= JSONObject.parseObject(reideValue, RedisObject.class);
			}
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/****
	 * 缓存清空
	 * @param keyStr
	 * @return
	 */
	public Boolean clearCache(String keyStr,int...indexDB){
		try {
			List<String> rlist=lists.lrange(keyStr, 0, -1,indexDB);
			for(int i=0;i<rlist.size();i++){
				strings.del(rlist.get(i),indexDB);
				lists.lrem(keyStr, 1, rlist.get(i),indexDB);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/****
	 * 获取缓存长度
	 * @param keyStr
	 * @return
	 */
	public int getCacheLength(String keyStr,int...indexDB){
		try {
			List<String> rlist=lists.lrange(keyStr, 0, -1,indexDB);
			if(rlist!=null && rlist.size()>0){
				return rlist.size();
			}else{
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	/*****
	 * 获取指定key所有缓存
	 * @param keyStr
	 * @return
	 */
	public List<RedisObject> getAll(String keyStr,int...indexDB){
		List<RedisObject> list= new ArrayList<RedisObject>();
		try {
			List<String> rlist=lists.lrange(keyStr, 0, -1,indexDB);
			if(rlist!=null && rlist.size()>0){
				RedisObject obj=null;
				String reideValue=null;
				for(String item:rlist){
					 reideValue = strings.get(item,indexDB);
					 if(reideValue!=null){
							obj= JSONObject.parseObject(reideValue, RedisObject.class);
							list.add(obj);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*****
	 * 获取在集合list1里存在，list2中不存在的元素
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<String> getDiffrent(List<String> list1, List<String> list2) 
    {           
           Map<String,Integer> map = new HashMap<String,Integer>(list1.size());
           List<String> diff = new ArrayList<String>();
           List<String> maxList = list1;
           List<String> minList = list2;
           
           for (String string : maxList) 
           {
              map.put(string, 1);                    
           }
           
           for (String string : minList) 
           {
               Integer cc = map.get(string);                    
               if(cc!=null)                    
               {
                   map.put(string, ++cc);
                   continue;                    
               }                            
           }
           
           for(Map.Entry<String, Integer> entry:map.entrySet())                    
           {                    
               if(entry.getValue()==1)                    
               {                    
                   diff.add(entry.getKey());   
               }                    
           }                               
           return diff;                    
    }
	/*****
	 * 获取指定key所有缓存 -- 正序
	 * @param keyStr
	 * @return
	 */
	public List<RedisObject> getAllAsc(String keyStr,int...indexDB){
		List<RedisObject> list= new ArrayList<RedisObject>();
		try {
			List<String> rlist=lists.lrange(keyStr, 0, -1,indexDB);
			if(rlist!=null && rlist.size()>0){
				RedisObject obj=null;
				String reideValue=null;
				for(int i = rlist.size() -1; i >= 0; i--){
				 String item = rlist.get(i);
					 reideValue = strings.get(item,indexDB);
					 if(reideValue!=null){
							obj= JSONObject.parseObject(reideValue, RedisObject.class);
							list.add(obj);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
