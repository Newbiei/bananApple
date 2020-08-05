package com.bananApple.system.criteria;

import com.springBootAdmin.system.entity.PubOperateLog;

public class PubOperateLogCriteria extends AbstractQueryCriteria<PubOperateLog> {

	private static final long serialVersionUID = 1L;

	private PubOperateLog model;

	public PubOperateLogCriteria() {
		this.model = new PubOperateLog();
	}

	public PubOperateLogCriteria(PubOperateLog model) {
		this.model = model;
	}

	public PubOperateLog getModel() {
		return model;
	}

	public void setModel(PubOperateLog model) {
		this.model = model;
	}

}
