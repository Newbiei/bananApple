package com.bananApple.system.system.service;

import com.springBootAdmin.system.entity.PubOperateLog;
import com.springBootAdmin.system.entity.PubOperateType;

import java.util.Date;
import java.util.List;

/**
 * @Description:操作日志管理业务层接口
 */
public interface PubOperateLogService {

	/**
	 * @Description:新增操作日志
	 */
	public PubOperateLog addOperateLog(PubOperateLog operateLog);

	/**
	 * @Description: 查询导出选中的操作日志
	 */
	public List<PubOperateLog> getListExportOperateLog(Long[] ids);

	/**
	 * @Description:更新操作完成时间
	 */
	public void updateOperateLog(long operateId, Date endDate, int status);

	/**
	 * @Description:获取操作类型
	 */
	public List<PubOperateType> getOperateTypeList();

	/**
	 * @Description:获取设备操作类型
	 */
	public List<PubOperateType> getEqpOperateTypeList();

	/**
	 * @Description:根据Id获取数据字典类型
	 */
	public String getOperateTypeById(Integer operateType);

	/**
	 * @Description:查询所有的操作日志
	 */
	public List<PubOperateLog> selectAllOperateLog();

	/**
	 * @Description:查询设备操作日志
	 */
	public List<PubOperateLog> selectEqpOperateLog();

	/**
	 * @Description:插入操作历史表数据
	 */
	public void insertToHisOperateLog(PubOperateLog log);

	/**
	 * @Description:清空操作日志表
	 */
	public void deleteOperateLog();

	/**
	 * @Description:清空设备操作日志表
	 */
	public void deleteEqpOperateLog();
}
