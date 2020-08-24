package com.bananApple.system.criteria;

import java.util.Date;

public abstract class AbstractQueryCriteria<T> implements QueryCriteria<T> {

	/**
     * 
     */
	private static final long serialVersionUID = 1066745938038100542L;

	/**
	 * 当前页
	 */
	private Integer pageNum = 1;

	/**
	 * 每页记录数
	 */
	private Integer pageSize = 10;

	/**
	 * 排序字段
	 */
	private String sort;

	/**
	 * 排序类型:asc,desc
	 */
	private String dir;

	/**
	 * 开始日期(String)
	 */
	private String queryStartDateStr;

	/**
	 * 结束日期(String)
	 */
	private String queryEndDateStr;

	/**
	 * 开始日期(java.util.Date)
	 */
	private Date queryStartDate;

	/**
	 * 结束日期(java.util.Date)
	 */
	private Date queryEndDate;

	public String getQueryStartDateStr() {
		return queryStartDateStr;
	}

	public void setQueryStartDateStr(String queryStartDateStr) {
		this.queryStartDateStr = queryStartDateStr;
	}

	public String getQueryEndDateStr() {
		return queryEndDateStr;
	}

	public void setQueryEndDateStr(String queryEndDateStr) {
		this.queryEndDateStr = queryEndDateStr;
	}

	public Date getQueryStartDate() {
		return queryStartDate;
	}

	public void setQueryStartDate(Date queryStartDate) {
		this.queryStartDate = queryStartDate;
	}

	public Date getQueryEndDate() {
		return queryEndDate;
	}

	public void setQueryEndDate(Date queryEndDate) {
		this.queryEndDate = queryEndDate;
	}

	public String getDir() {
		return this.dir;
	}

	public Integer getPageNum() {
		return getCurPage(this.pageNum);
	}

	public Integer getPageSize() {
		return getPageSize(this.pageSize);
	}

	public String getSort() {
		return this.sort;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * 获取页容量
	 * 
	 * @param pageSize
	 *            页容量
	 * @return
	 */
	private int getPageSize(Integer pageSize) {
		int size = 10;
		if ((null != pageSize) && (0 < pageSize.intValue())) {
			size = pageSize.intValue();
		}
		return size;
	}

	/**
	 * 获取当前页数
	 * 
	 * @param curPage
	 *            当前页数
	 * @return
	 */
	private int getCurPage(Integer curPage) {
		if ((null != curPage) && (0 < curPage.intValue())) {
			return curPage.intValue();
		}
		return 1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AbstractQueryCriteria [pageNum=");
		builder.append(pageNum);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", sort=");
		builder.append(sort);
		builder.append(", dir=");
		builder.append(dir);
		builder.append(", queryStartDateStr=");
		builder.append(queryStartDateStr);
		builder.append(", queryEndDateStr=");
		builder.append(queryEndDateStr);
		builder.append(", queryStartDate=");
		builder.append(queryStartDate);
		builder.append(", queryEndDate=");
		builder.append(queryEndDate);
		builder.append("]");
		return builder.toString();
	}

}