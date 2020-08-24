package com.bananApple.system.service.serviceImpl;

import com.bananApple.system.dao.StaffDepartmentDao;
import com.bananApple.system.service.StaffDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 班组业务逻辑实现类
 */
@Service("StaffDepartmentService")
public class StaffDepartmentServiceImpl implements StaffDepartmentService {
    // 注入班组的dao层
    @Resource
    private StaffDepartmentDao staffDepartmentDao;

    /**
     * 班组首页查询信息
     * @param request
     * @return
     */
    @Override
    public List<HashMap> selStaffDepartmentAll(HttpServletRequest request) {
        // 获取前台传过来的参数
        String departmentName = request.getParameter("departmentName") == null ? "" : request.getParameter("departmentName");
        String staffType = request.getParameter("staffType") == null ? "" :request.getParameter("staffType");
        String areaId = request.getParameter("areaId") == null ? "" : request.getParameter("areaId");

        // 创建map集合
        Map<String,Object> map = new HashMap<String,Object>();
        // 将前台的值存入map中
        map.put("departmentName",departmentName);
        map.put("staffType",staffType);
        map.put("areaId",areaId);

        // 调用班组dao层的查询方法将map传过去
        List<HashMap> hashmap= staffDepartmentDao.selStaffDepartmentAll(map);

        return hashmap;
    }

    /**
     * 班组添加信息
     * @param request
     * @return
     */
    @Override
    public int addStaffDepartment(HttpServletRequest request) {
        // 获取前台传过来的参数
        String departmentName= request.getParameter("departmentName") == null ? "" : request.getParameter("departmentName");
//        String areaId= request.getParameter("areaId") == null ? "" : request.getParameter("areaId");
        String staffType= request.getParameter("staffType") == null ? "" : request.getParameter("staffType");
        // 获取登录的账号id
        String staffId = request.getSession().getAttribute("staffId").toString();
        // 使创建人就为当前登录的账号
        String createOp = staffId == null ? "" : staffId;
        // 修改人和创建人一样
        String updateOp = createOp;
        String status= request.getParameter("status") == null ? "" : request.getParameter("status");
        String remark= request.getParameter("remark") == null ? "" : request.getParameter("remark");

        // 创建map集合
        Map<String,Object> map =new HashMap<String,Object>();
        // 将值全部存到map中
        map.put("departmentName",departmentName);
//        map.put("areaId",areaId);
        map.put("staffType",staffType);
        map.put("createOp",createOp);
        map.put("updateOp",updateOp);
        map.put("status",status);
        map.put("remark",remark);

        // 调用班组dao层中的添加方法，将map传过去
        int i =staffDepartmentDao.addStaffDepartment(map);
        return i;
    }

    /**
     * 根据班组id删除班组信息（修改班组的状态）
     * @param request
     * @return
     */
    @Override
    public int delStaffDepartmentById(HttpServletRequest request) {
        // 获取前台传过来的班组id
        String departmentId = request.getParameter("departmentId") == null ? "" : request.getParameter("departmentId");

        // 调用班组dao层中删除方法（修改班组状态），将班组id传过去
        int i = staffDepartmentDao.delStaffDepartmentById(departmentId);
        // 将删除结果返回
        return i;
    }

    /**
     * 获取班组中所有的用户类型
     * @return
     */
    @Override
    public List<Map<String, Object>> selStaffType() {
        // 直接调用班组dao中的查询用户类型方法
        List<Integer> list = staffDepartmentDao.selStaffType();

        // 创建List类型的map
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        // 循环得到list中所有的值
        for (Integer l:list) {
            // 创建map集合
            Map<String,Object> map = new HashMap<>();
            // 每次循环创建一个新的String对象用于被赋值
            String staffTypeName = new String();
            if(l == 1){
                staffTypeName = "移动";
            }else if(l == 2){
                staffTypeName = "电信";
            }else if(l == 3){
                staffTypeName = "铁塔";
            }else if(l == 4){
                staffTypeName = "联通";
            }else {
                staffTypeName = "";
            }
            // 每次循环结束将l和staffTypeName都存放在map中
            map.put("l",l);
            map.put("staffTypeName",staffTypeName);
            // 将map集合放入listmap集合中
            listmap.add(map);
        }

        return listmap;
    }

    /**
     * 根据班组id查询班组信息
     * @param request
     * @return
     */
    @Override
    public List<Map<String, Object>> selDepartmentById(HttpServletRequest request) {
        // 获取前台传过来的班组id
        String departmentId = request.getParameter("departmentId") == null ? "" : request.getParameter("departmentId");
        // 调用班组dao层中的根据班组id查询班组信息方法
        List<Map<String, Object>> list = staffDepartmentDao.selDepartmentById(departmentId);
        // 将查询到的结果返回给controller
        return list;
    }

    /**
     * 根据班组id修改班组信息
     * @param request
     * @return
     */
    @Override
    public int updDepartmentById(HttpServletRequest request) {
        // 获取前端修改时所带的参数
        String departmentId = request.getParameter("departmentId") == null ? "" : request.getParameter("departmentId");
        String departmentName = request.getParameter("departmentName") == null ? "" : request.getParameter("departmentName");
        String staffType = request.getParameter("staffType") == null ? "" : request.getParameter("staffType");
        // 获取登录的账号id
        String staffId = request.getSession().getAttribute("staffId").toString();
        // 使创建人就为当前登录的账号
        String updateOp = staffId == null ? "" : staffId;
        String status = request.getParameter("status") == null ? "" : request.getParameter("status");
        String remark = request.getParameter("remark") == null ? "" : request.getParameter("remark");

        Map<String,Object> map = new HashMap<>();
        map.put("departmentId",departmentId);
        map.put("departmentName",departmentName);
        map.put("staffType",staffType);
        map.put("updateOp",updateOp);
        map.put("status",status);
        map.put("remark",remark);

        // 调用班组dao中的根据id修改班组信息方法
        int i =staffDepartmentDao.updDepartmentById(map);

        // 将修改结果返回给controller
        return i;
    }
}
