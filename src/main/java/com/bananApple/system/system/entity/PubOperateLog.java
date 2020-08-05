package com.bananApple.system.system.entity;

import java.util.Date;

/**
 * @Description:操作日志实体类
 */
public class PubOperateLog extends AbstractModel {
	private static final long serialVersionUID = -3564896216917089168L;

	private Long operateId; // 操作ID

	private Long staffId; // 员工ID

	private String name; // 员工姓名

	private String source; // 操作来源 PHONE、PC

	private String menu; // 操作菜单

	private Date startDate; // 操作开始时间

	private Date endDate; // 操作结束时间

	private Integer operateType; // 操作类型

	private Integer operateStatus; // 操作状态（成功、失败、操作中）

	private PubOperateType pubOperateType; // 操作类型实体

	private Integer deviceid; // 设备ID

	private String deviceName; // 设备名称

	private String notes; // 备注

	public PubOperateLog()
	{
		this.pubOperateType = new PubOperateType();
	}

	public Long getOperateId()
	{
		return operateId;
	}

	public void setOperateId(Long operateId)
	{
		this.operateId = operateId;
	}

	public Long getStaffId()
	{
		return staffId;
	}

	public void setStaffId(Long staffId)
	{
		this.staffId = staffId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source == null ? null : source.trim();
	}

	public String getMenu()
	{
		return menu;
	}

	public void setMenu(String menu)
	{
		this.menu = menu == null ? null : menu.trim();
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public Integer getOperateType()
	{
		return operateType;
	}

	public void setOperateType(Integer operateType)
	{
		this.operateType = operateType;
	}

	public Integer getOperateStatus()
	{
		return operateStatus;
	}

	public void setOperateStatus(Integer operateStatus)
	{
		this.operateStatus = operateStatus;
	}

	public PubOperateType getPubOperateType()
	{
		return pubOperateType;
	}

	public void setPubOperateType(PubOperateType pubOperateType)
	{
		this.pubOperateType = pubOperateType;
	}

	public Integer getDeviceid()
	{
		return deviceid;
	}

	public void setDeviceid(Integer deviceid)
	{
		this.deviceid = deviceid;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("PubOperateLog [operateId=");
		builder.append(operateId);
		builder.append(", staffId=");
		builder.append(staffId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", source=");
		builder.append(source);
		builder.append(", menu=");
		builder.append(menu);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", operateType=");
		builder.append(operateType);
		builder.append(", operateStatus=");
		builder.append(operateStatus);
		builder.append(", pubOperateType=");
		builder.append(pubOperateType);
		builder.append("]");
		return builder.toString();
	}

	public String getDeviceName()
	{
		return deviceName;
	}

	public void setDeviceName(String deviceName)
	{
		this.deviceName = deviceName;
	}

	public String getNotes()
	{
		return notes;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}
}
