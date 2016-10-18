package com.qm.web.utils;

import java.util.Map;

/**
 * @Description: 分页对象 
 * @author caizhen
 * @date 2015年6月9日 下午5:38:57
 */
public class Pagination {

	private Object	dataList;		// 数据列表

	private Integer	total;			// 总数据量

	private Integer	currentPage;	// 当前页

	private Integer	pageSize;		// 一页数据量
	private Map map;
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Pagination(){}
	
	public Pagination(Object dataList, Integer	total, Integer	currentPage, Integer pageSize){
		this.dataList = dataList;
		this.total = total;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	/**
	 * @return
	 */
//	private int doRtnMaxResult() {
//		return currentPage * pageSize;
//	}

	/**
	 * @return
	 */
//	private int doRtnSkipResult() {
//		return (currentPage - 1) * pageSize;
//	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @return the maxResult
	 */
//	public Integer getMaxResult() {
//		return doRtnMaxResult();
//	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @return the skipResult
	 */
//	public Integer getSkipResult() {
//		return doRtnSkipResult();
//	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getDataList() {
		return dataList;
	}

	public void setDataList(Object dataList) {
		this.dataList = dataList;
	}

	public Integer getPages() {
		if(total == 0)
			return 1;
		return (total % pageSize == 0 ? (total / pageSize)
				: (total / pageSize + 1));
	}

}
