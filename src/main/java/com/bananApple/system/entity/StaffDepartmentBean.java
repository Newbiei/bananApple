package com.bananApple.system.entity;

import lombok.Data;

import java.util.Date;

/**
 * 班组实体类
 */
@Data
public class StaffDepartmentBean {
    // 属性
    private int department_id;// 班组id
    private String department_name;// 班组名称
    private int area_id;// 地区id
    private int staff_type;// 用户类型
    private int create_op;// 创建人
    private Date create_date;// 创建时间
    private int update_op;// 修改人
    private Date update_date;// 修改时间
    private int status;// 状态  0在用   1删除
    private String remark;// 备注

}
