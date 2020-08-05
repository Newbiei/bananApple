package com.bananApple.filter;

import org.apache.commons.lang.StringUtils;

/**
 * sql过滤
 * 
 * @author zhangc
 * @date 20191008
 */
public class SQLFilter {

    /**
     * SQL注入过滤
     * 
     * @param str
     *            待验证的字符串
     */
    public static String sqlInject(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        // 去掉'|"|;|\字符
        //str = StringUtils.replace(str, "'", "");
        //str = StringUtils.replace(str, "\"", "");
        //str = StringUtils.replace(str, ";", "");
        //str = StringUtils.replace(str, "\\", "");

        // 转换成小写
        String strNew = str.toLowerCase();

        // 非法字符
        String[] keywords = { "master", "truncate", "insert", "select", "delete", "update", "declare", "alert",
                "create", "drop","from","where",".text(",".val(","setValue","getValue" };
        // 判断是否包含非法字符
        for (String keyword : keywords) {
            if (strNew.indexOf(keyword)>-1) {
            	int index=strNew.indexOf(keyword);
            	str=str.substring(0, index)+str.substring(index+keyword.length(), str.length());
                //str=str.replaceAll(keyword, "");
            }
        }

        return str;
    }
}