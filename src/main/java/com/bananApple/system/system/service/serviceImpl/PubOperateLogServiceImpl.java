package com.bananApple.system.system.service.serviceImpl;

import com.springBootAdmin.system.dao.PubOperateLogDao;
import com.springBootAdmin.system.entity.PubOperateLog;
import com.springBootAdmin.system.entity.PubOperateType;
import com.springBootAdmin.system.service.PubOperateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Description:日志管理实现类
 */
@Service("pubOperateLogService")
public class PubOperateLogServiceImpl implements PubOperateLogService {

	@Resource
	private PubOperateLogDao pubOperateLogDao;

	@Override
	public List<PubOperateLog> getListExportOperateLog(Long[] ids)
	{
		return pubOperateLogDao.getListExportOperateLog(ids);
	}

	/**
	 * @Description:新增操作日志
	 */
	@Override
	public PubOperateLog addOperateLog(PubOperateLog operateLog)
	{
		pubOperateLogDao.insert(operateLog);
		return operateLog;
	}

	@Override
	public void updateOperateLog(long operateId, Date endDate, int status)
	{
		pubOperateLogDao.updateOperateLog(operateId, endDate, status);
	}

	@Override
	public List<PubOperateType> getOperateTypeList()
	{
		return pubOperateLogDao.getOperateTypeList();
	}

	@Override
	public String getOperateTypeById(Integer operateType)
	{
		return pubOperateLogDao.getOperateTypeById(operateType);
	}

	@Override
	public List<PubOperateLog> selectAllOperateLog()
	{
		return pubOperateLogDao.selectAllOperateLog();
	}

	@Override
	public void insertToHisOperateLog(PubOperateLog log)
	{
		pubOperateLogDao.insertToHisOperateLog(log);
	}

	@Override
	public void deleteOperateLog()
	{
		pubOperateLogDao.deleteOperateLog();
	}


	@Override
	public List<PubOperateType> getEqpOperateTypeList()
	{
		return pubOperateLogDao.getEqpOperateTypeList();
	}

	@Override
	public List<PubOperateLog> selectEqpOperateLog()
	{
		return pubOperateLogDao.selectEqpOperateLog();
	}

	@Override
	public void deleteEqpOperateLog()
	{
		pubOperateLogDao.deleteEqpOperateLog();
	}

}
