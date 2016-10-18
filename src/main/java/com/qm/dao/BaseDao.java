package com.qm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 封装基本的增删改查方法的dao接口
 * 创建日期：2014年8月4日
 * @author niezhegang
 */
public interface BaseDao<T> {
	/**
	 * 插入一条记录，返回新增对象ID
	 * @param obj
	 * @return
	 * 创建日期：2014年8月4日
	 * 修改说明：
	 * @author niezhegang
	 */
	public Long insert(T obj) ;
	
	/**
	 * 根据ID删除一条对象
	 * @param id
	 * 创建日期：2014年8月4日
	 * 修改说明：
	 * @author niezhegang
	 */
	public void delete(Long id);
	
	/**
	 * 修改一条对象
	 * @param obj
	 * 创建日期：2014年8月4日
	 * 修改说明：
	 * @author niezhegang
	 */
	public void update(T obj) ;
	
	/**
	 * 根据ID查询一个对象
	 * @param id
	 * @return
	 * 创建日期：2014年8月4日
	 * 修改说明：
	 * @author niezhegang
	 */
	public T select(Long id) ;
	/**
	 * 获取所有对象
	 * @return
	 * 创建日期：2014年8月4日
	 * 修改说明：
	 * @author niezhegang
	 */
	public List<T> selectAll();
	/**
	 * @Title: selectTotal 
	 * @Description: 数据总量查询
	 * @author caizhen   
	 * @param @param qryMap
	 * @param @return    设定文件 
	 * @throws
	 */
	Integer selectTotal(Map<String, Object> qryMap);
}
