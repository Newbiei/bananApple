package com.bananApple.annotation;

import com.springBootAdmin.system.entity.PubOperateLog;
import com.springBootAdmin.system.service.PubOperateLogService;
import com.springBootAdmin.util.CheckMobile;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

/**
 * @Description:统一记录操作日志信息
 */
// 该注解表示该类为切面类
@Aspect
// 注入依赖
@Component
public class SaveOperateLogAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 操作日志管理接口
	 */
	@Resource
	private PubOperateLogService pubOperateLogService;

	// Controller层切点
	@Pointcut("@annotation(com.springBootAdmin.annotation.SaveOperateLog)")
	public void saveOperateLog() {}

	// 操作日志Id
	Long operateId = null;

	/**
	 * @Description:前置通知记录用户操作记录日志
	 */
	@Before("within(com.springBootAdmin..controller..*) && @annotation(param))")
	public void doBefore(JoinPoint joinPoint, SaveOperateLog param) throws IOException {
		logger.info(">>>>>>>>>>>>>>前置通知开始>>>>>>>>>>>>>>");

		Object[] args = joinPoint.getArgs();
		HttpServletRequest request = (HttpServletRequest) args[0];
		String menu = param.menu();
		Integer operateType = Integer.valueOf(param.operateType());
		
		Boolean isMobile = CheckMobile.check(request);
		String source = isMobile ? "PHONE" : "PC";
		logger.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
		
		long staffId;
		
		PubOperateLog operateLog = new PubOperateLog();
		if(isMobile) {
			staffId = Long.valueOf(request.getParameter("staffId").toString());
			operateLog.setNotes(request.getParameter("notes"));
		}else{
			staffId = Long.valueOf(request.getSession().getAttribute("staffId").toString());
		}
		operateLog.setStaffId(staffId);
		operateLog.setSource(source);
		operateLog.setMenu(menu);
		operateLog.setOperateType(operateType);
		operateLog.setOperateStatus(3);
		PubOperateLog ope = pubOperateLogService.addOperateLog(operateLog);
		
		operateId = ope.getOperateId();
		String operateTypeName = pubOperateLogService.getOperateTypeById(operateType);
		
		logger.info("操作ID：" + operateId + "，操作人ID：" + staffId + "， 操作来源：" + source + "，操作菜单：" + menu + "，操作类型：" + operateTypeName);
		
		logger.info(">>>>>>>>>>>>>>前置通知结束>>>>>>>>>>>>>>");
	}

	/**
	 * @Description:在执行完操作后更新操作日志
	 */
	@After("saveOperateLog()")
	public void doAfter(JoinPoint joinPoint)
	{
		logger.info("<<<<<<<<<<<<<<后置通知开始<<<<<<<<<<<<<<");

		pubOperateLogService.updateOperateLog(operateId, new Date(), 1);
		logger.info("操作ID：" + operateId + "，更新操作记录为成功！");

		logger.info("<<<<<<<<<<<<<<后置通知结束<<<<<<<<<<<<<<");
	}

	/**
	 * @Description:异常处理更新
	 */
	@AfterThrowing("saveOperateLog()")
	public void exceptionMethod()
	{
		// 更新操作状态为失败
		if (null != operateId)
		{
			pubOperateLogService.updateOperateLog(operateId, new Date(), 2);
		}
		logger.error(">>>>>>>>>>>>>>>>>>>>>保存操作日志异常<<<<<<<<<<<<<<<<<<<<<");
	}

}
