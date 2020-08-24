package com.bananApple.system.service.serviceImpl;

import com.bananApple.system.dao.StaffDao;
import com.bananApple.system.service.StaffService;
import com.bananApple.util.ExcelExportUtil;
import com.bananApple.util.PasswordGenerateUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("StaffService")
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDao staffDao;

    /**
     * 新增人员
     */
    @Override
    public String addStaff(HttpServletRequest request) {
        String staffNo = request.getParameter("staffNo") == null ? "" : request.getParameter("staffNo");
        String staffName = request.getParameter("staffName") == null ? "" : request.getParameter("staffName");
        String realName = request.getParameter("realName") == null ? "" : request.getParameter("realName");
        String phone = request.getParameter("phone") == null ? "" : request.getParameter("phone");
        String areaId = request.getParameter("areaId") == null ? "" : request.getParameter("areaId");
        String staffPass = request.getParameter("staffPass") == null ? "" : request.getParameter("staffPass");
        staffPass = PasswordGenerateUtil.getPassword(staffPass, staffNo, 2);
        String staffCard = request.getParameter("staffCard") == null ? "" : request.getParameter("staffCard");
        String email = request.getParameter("email") == null ? "" : request.getParameter("email");
        String staffType = request.getParameter("staffType") == null ? "" : request.getParameter("staffType");
        String departmentId = request.getParameter("departmentId") == null ? "" : request.getParameter("departmentId");
        String positionId = request.getParameter("positionId") == null ? "" : request.getParameter("positionId");
        String remark = request.getParameter("remark") == null ? "" : request.getParameter("remark");
        String staffId = request.getSession().getAttribute("staffId").toString();
        String createOp = staffId == null ? "" : staffId;

        Map<String, Object> map = new HashMap<>();
        map.put("staffNo", staffNo);
        map.put("staffName", staffName);
        map.put("realName", realName);
        map.put("phone", phone);
        map.put("areaId", areaId);
        map.put("staffPass", staffPass);
        map.put("staffCard", staffCard);
        map.put("email", email);
        map.put("staffType", staffType);
        map.put("departmentId", departmentId);
        map.put("positionId", positionId);
        map.put("remark", remark);
        map.put("createOp", createOp);

        int result = staffDao.addStaff(map);
        return result + "";
    }

    /**
     * 查询人员
     */
    @Override
    public List<Map<String, Object>> queryStaff(HttpServletRequest request) {
        String staffName = request.getParameter("staffName") == null ? "" : request.getParameter("staffName");
        String staffNo = request.getParameter("staffNo") == null ? "" : request.getParameter("staffNo");
        String realName = request.getParameter("realName") == null ? "" : request.getParameter("realName");
        String areaId = request.getParameter("areaId") == null ? "" : request.getParameter("areaId");
        String departmentId = request.getParameter("departmentId") == null ? "" : request.getParameter("departmentId");
        String staffType = request.getParameter("staffType") == null ? "" : request.getParameter("staffType");
        staffType = ("0").equals(staffType) ? "" : staffType;

        Map<String, Object> map = new HashMap<>();
        map.put("staffName", staffName);
        map.put("staffNo", staffNo);
        map.put("realName", realName);
        map.put("areaId", areaId);
        map.put("staffType", staffType);
        map.put("departmentId", departmentId);

        return staffDao.queryStaff(map);
    }

    /**
     * 通过staffId查人员信息
     */
    @Override
    public List<Map<String, Object>> getStaffById(HttpServletRequest request) {
        String staffId = request.getParameter("staffId");
        List<Map<String, Object>> list = staffDao.getStaffById(staffId);
        return list;
    }

    /**
     * 更新人员信息
     */
    @Override
    public String updateStaff(HttpServletRequest request) {
        String staffId = request.getParameter("staffId") == null ? "" : request.getParameter("staffId");
        if (("").equals(staffId))	return "error";
        String staffNo = request.getParameter("staffNo") == null ? "" : request.getParameter("staffNo");
        String staffName = request.getParameter("staffName") == null ? "" : request.getParameter("staffName");
        String realName = request.getParameter("realName") == null ? "" : request.getParameter("realName");
        String status = request.getParameter("status") == null ? "" : request.getParameter("status");
        String phone = request.getParameter("phone") == null ? "" : request.getParameter("phone");
        String areaId = request.getParameter("areaId") == null ? "" : request.getParameter("areaId");
        String staffPass = request.getParameter("staffPass") == null ? "" : request.getParameter("staffPass");
        if (!("").equals(staffPass)) {
            staffPass = PasswordGenerateUtil.getPassword(staffPass, staffNo, 2);
        }
        String staffCard = request.getParameter("staffCard") == null ? "" : request.getParameter("staffCard");
        String email = request.getParameter("email") == null ? "" : request.getParameter("email");
        String staffType = request.getParameter("staffType") == null ? "" : request.getParameter("staffType");
        String departmentId = request.getParameter("departmentId") == null ? "" : request.getParameter("departmentId");
        String positionId = request.getParameter("positionId") == null ? "" : request.getParameter("positionId");
        String remark = request.getParameter("remark") == null ? "" : request.getParameter("remark");
        String loginStaffId = request.getSession().getAttribute("staffId").toString();
        String updateOp = loginStaffId == null ? "" : loginStaffId;

        Map<String, Object> map = new HashMap<>();
        map.put("staffId", staffId);
        map.put("staffNo", staffNo);
        map.put("staffName", staffName);
        map.put("realName", realName);
        map.put("status", status);
        map.put("phone", phone);
        map.put("areaId", areaId);
        map.put("staffPass", staffPass);
        map.put("staffCard", staffCard);
        map.put("email", email);
        map.put("staffType", staffType);
        map.put("departmentId", departmentId);
        map.put("positionId", positionId);
        map.put("remark", remark);
        map.put("updateOp", updateOp);

        int result = staffDao.updateStaff(map);
        return result + "";
    }

    /**
     * 根据staffId查角色
     */
    @Override
    public List<Map<String, Object>> queryStaffRole(String staffId) {
        return staffDao.queryStaffRole(staffId);
    }

    /**
     * 通过staffId修改角色
     */
    @Override
    public String updateStaffRole(HttpServletRequest request) {
        String staffId = request.getParameter("staffId") == null ? "" : request.getParameter("staffId");

        String op = request.getSession().getAttribute("staffId").toString();
        String createOp = op == null ? "" : op;

        String row = request.getParameter("row");
        JSONArray json = JSONArray.fromObject(row);
        List<Object> roleIdList = new ArrayList<>();
        for (int i = 0; i < json.size(); i++) {
            JSONObject object = json.getJSONObject(i);
            roleIdList.add(object.get("ROLE_ID"));
        }

        // 先删除所有角色
        staffDao.deleteStaffRole(staffId);
        // 再新增选择的角色
        for (int i = 0; i < roleIdList.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("staffId", staffId);
            map.put("roleId", roleIdList.get(i));
            map.put("createOp", createOp);
            staffDao.addStaffRole(map);
        }

        return "1";
    }

    /**
     * 逻辑删除人员
     */
    @Override
    public String deleteStaff(HttpServletRequest request) {
        String staffId = request.getParameter("staffId") == null ? "" : request.getParameter("staffId");
        Map<String, Object> map = new HashMap<>();
        map.put("staffId", staffId);
        int result = staffDao.deleteStaff(map);
        return result + "";
    }

    @Override
    public void exportStaff(HttpServletRequest request, HttpServletResponse response) {
        String staffName = request.getParameter("staffName") == null ? "" : request.getParameter("staffName");
        String staffNo = request.getParameter("staffNo") == null ? "" : request.getParameter("staffNo");
        String realName = request.getParameter("realName") == null ? "" : request.getParameter("realName");
        String areaId = request.getParameter("areaId") == null ? "" : request.getParameter("areaId");

        Map<String, Object> map = new HashMap<>();
        map.put("staffName", staffName);
        map.put("staffNo", staffNo);
        map.put("realName", realName);
        map.put("areaId", areaId);

        String filePath = request.getSession().getServletContext().getRealPath("/").replace("\\", "/");

        filePath = filePath + ExcelExportUtil.TEMP_DOWN_EXCEL_PATH + ".xls";
        // 生成文件的路径
        try {
            // 汇总信息
            List<Map<String, Object>> list = staffDao.queryStaff(map);
            HSSFWorkbook wb = new HSSFWorkbook();
            // 工作簿
            HSSFSheet sheet = wb.createSheet("人员信息汇总");
            // 单元格样式
            HSSFCellStyle cellStyle = ExcelExportUtil.getGroomCellStyle(wb);
            // 工作簿 头部 标题样式
            HSSFCellStyle headStyle = ExcelExportUtil.getGroomHeaderStyle(wb);
            String[] title={"用户编号", "用户名称", "真实姓名", "地区", "班组", "手机号", "身份证号", "电子邮箱", "用户类型", "创建人", "创建时间", "修改人", "修改时间"};//设置标头
            int[] len={4000,4000,4000,4000,4000,4000,6000,5000,4000,4000,5000,4000,5000};//设置列宽
            String[] key={"STAFF_NO","STAFF_NAME","REAL_NAME", "AREA_NAME","DEPARTMENT_NAME","PHONE","STAFF_CARD","EMAIL","STAFF_TYPE","CREATE_OP","CREATE_DATE","UPDATE_OP","UPDATE_DATE"};//设置数据集key

            ExcelExportUtil.creatHeaderRow(sheet, headStyle,title,len);//创建头部
            ExcelExportUtil.insertValueRow(sheet, cellStyle, list, key);//插入数据

            FileOutputStream fos = new FileOutputStream(filePath);
            wb.write(fos);
            fos.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // 下载文件
        ExcelExportUtil.downLoadExcel(request, response, filePath, "人员信息汇总");
    }
}
