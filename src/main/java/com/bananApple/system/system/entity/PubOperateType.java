package com.bananApple.system.system.entity;

/**
 * @Description: 操作日志类型
 */
public class PubOperateType extends AbstractModel {
	
	private static final long serialVersionUID = 7413050456490436595L;

	private String operateType; // 操作类型

	private String operateTypeName; // 操作类型名称

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getOperateTypeName() {
		return operateTypeName;
	}

	public void setOperateTypeName(String operateTypeName) {
		this.operateTypeName = operateTypeName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PubOperateType [operateType=");
		builder.append(operateType);
		builder.append(", operateTypeName=");
		builder.append(operateTypeName);
		builder.append("]");
		return builder.toString();
	}
}
