package com.bananApple.system.entity;

import java.util.List;

public class Pages
{
	private int pageNum = 0;
	private int pageSize = 10;
	private int total;
	private List<?> rows;

	public Pages()
	{
		super();
	}

	public Pages(int pageNum, int pageSize)
	{
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		this.pageNum = pageNum;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getTotal()
	{
		return total;
	}

	public void setTotal(int total)
	{
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
