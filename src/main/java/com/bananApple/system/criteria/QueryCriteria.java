package com.bananApple.system.criteria;

import java.io.Serializable;

public abstract interface QueryCriteria<T> extends Serializable {

	public abstract T getModel();

	public abstract void setModel(T paramT);

	public abstract String getSort();

	public abstract void setSort(String paramString);

	public abstract String getDir();

	public abstract void setDir(String paramString);

	public abstract Integer getPageNum();

	public abstract void setPageNum(Integer paramInteger);

	public abstract Integer getPageSize();

	public abstract void setPageSize(Integer paramInteger);

}