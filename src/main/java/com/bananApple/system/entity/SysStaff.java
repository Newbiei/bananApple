package com.bananApple.system.entity;

import lombok.Data;

@Data
public class SysStaff {
    private String staffId;
    private String staffNo;
    private String staffPass;
    private String staffName;
    private String realName;
    private String phone;
    private String email;
    private String areaId;
    private String areaName;
    private String staffCard;
    private String staffType;
    private String departmentId;
    private String departmentName;
    private String remark;
    private String createOp;
    private String createDate;
    private String updateOp;
    private String updateDate;
    private String status;
}
