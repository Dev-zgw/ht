package contract.controller;

import contract.pojo.Department;
import contract.service.DepartmentService;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zgh
 * @create 2020/8/14 14:40
 */
@RestController
@RequestMapping("/department/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有部门
     *
     * @return
     */
    @RequestMapping(value = "get.do", method = RequestMethod.POST)
    public Map<String, Object> getAllDepartment() {
        return departmentService.getDeptTree();
    }

    @RequestMapping(value = "getOne.do", method = RequestMethod.POST)
    public Department getAllDepartment(String id) {
        return departmentService.getOneById(new BigDecimal(id));
    }

    /**
     * 添加部门
     * @param bmmc
     * @param pid
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public ServerResponse addDept(String bmmc, String pid) {
        Department department = new Department();
        department.setBmmc(bmmc);
        department.setPid(new BigDecimal(pid));
        return departmentService.addDept(department);
    }

    /**
     * 修改部门
     * @param id
     * @param bmmc
     * @param pid
     * @return
     */
    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    public ServerResponse updateDept(String id, String bmmc, String pid) {
        Department department = new Department();
        department.setId(new BigDecimal(id));
        department.setBmmc(bmmc);
        department.setPid(new BigDecimal(pid));
        return departmentService.updataDept(department);
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    public ServerResponse deleteDept(String id) {
        return departmentService.deleteDept(new BigDecimal(id));
    }


}
