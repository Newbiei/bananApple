package com.bananApple.util;

/**
 * 通用静态变量 [一句话功能简述]
 */
public class Constants
{
    public static final String W_CBLWORD="D:\\ywWorld\\";// Word文档存放路径
    public static final String L_CBLWORD="/opt/ywWorld/";// Word文档存放路径
	
	public static final int PAGE_SIZE = 3;

	public static final String YES = "Y";

	public static final String NO = "N";

	public static final String SUCCESS = "success";

	public static final String FAIL = "fail";

	/**
	 * 当前用户信息
	 */
	public static final String LOGIN_USER = "staffId";

	/**
	 * 当前用户拥有的权限
	 */
	public static final String LOGIN_AUTHORITY = "authority";

	/**
	 * 继续操作URL
	 */
	public static final String CONTINUE_URL = "continueUrl";

	/**
	 * 返回操作URL
	 */
	public static final String RETURN_URL = "returnUrl";

	/**操作类型*/
	public static class PubOperateType {

		// 登录
		public static final int LOGIN_IN = 1;
		
		// 登出
		public static final int LOGIN_OUT = 2;

		// 初始化左侧菜单
		public static final int GET_LEFT_LIST = 3;

		// 新增
		public static final int ADD = 4;
		
		// 删除
		public static final int DELETE = 5;
		
		// 修改
		public static final int UPDATE = 6;
		
		// 查询
		public static final int QUERY = 7;

		// 修改人员角色
		public static final int UPDATE_STAFF_ROLE = 8;
		
		// 修改角色菜单
		public static final int UPDATE_ROLE_MENU = 9;
		
		//app签到
		public static final int APP_SIGN_IN = 10;
		
		// 导入
		public static final int IMPORT = 11;
		
		// 导出
		public static final int EXPORT = 12;
		
		//app获取个人信息
		public static final int APP_GET_STAFF_INFORMATION = 13;
		
		//app修改密码
		public static final int APP_CHANGE_PASSWORD = 14;
		
		//app获取任务详细描述
		public static final int APP_GET_CHECK_CONTENT = 15;
		
		//app获取人员列表
		public static final int APP_GET_STAFF_LIST = 16;
		
		//app提交任务详细描述
		public static final int APP_SUBMIT_CHECK = 17;
		
		//app判断用户当天是否签到
		public static final int APP_JUDGE_ALREADY_SIGNIN = 18;
		
	}
	
	public static final String TOPIC_NAME = "topic";
}
