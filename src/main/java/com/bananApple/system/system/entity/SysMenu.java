package com.bananApple.system.system.entity;

import lombok.Data;

@Data
public class SysMenu {

    private String menuId;
    private String parentMenuId;
    private String menuLevel;
    private String menuName;
    private String url;

}
