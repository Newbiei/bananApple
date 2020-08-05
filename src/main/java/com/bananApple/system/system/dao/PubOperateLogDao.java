package com.bananApple.system.system.dao;

import com.springBootAdmin.system.criteria.PubOperateLogCriteria;
import com.springBootAdmin.system.entity.PubOperateLog;
import com.springBootAdmin.system.entity.PubOperateType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description:操作日志DAO层
 */
@Mapper
public interface PubOperateLogDao
{

	public int insert(PubOperateLog record);

	/**
	 * @Description:操作日志分页查询
	 */
	public List<PubOperateLog> getListByPage(@Param("bean") PubOperateLogCriteria bean);

	/**
	 * @Description:设备操作日志分页查询
	 */
	public List<PubOperateLog> getEqpOperateListByPage(@Param("bean") PubOperateLogCriteria bean);

	/**
	 * @Description:查询导出选中的操作日志
	 */
	public List<PubOperateLog> getListExportOperateLog(@Param("ids") Long[] ids);

	/**
	 * @Description:更新操作完成时间
	 */
	public void updateOperateLog(@Param("operateId") long operateId, @Param("endDate") Date endDate, @Param("status") int status);

	/**
	 * @Description:获取操作类型列表
	 */
	public List<PubOperateType> getOperateTypeList();

	/**
	 * @Description:获取设备操作类型列表
	 */
	public List<PubOperateType> getEqpOperateTypeList();

	/**
	 * @Description:根据Id查询操作类型
	 */
	public String getOperateTypeById(@Param("operateType") Integer operateType);

	/**
	 * @Description:查询所有的操作日志
	 */
	public List<PubOperateLog> selectAllOperateLog();

	/**
	 * @Description:查询设备操作日志
	 */
	public List<PubOperateLog> selectEqpOperateLog();

	/**
	 * @Description:插入历史表数据
	 */
	public void insertToHisOperateLog(PubOperateLog log);

	/**
	 * @Description:清空操作日志表数据
	 */
	public void deleteOperateLog();

	/**
	 * @Description:清空操作日志表数据
	 */
	public void deleteEqpOperateLog();
	
	public List pubOperateLog(Map map);

}