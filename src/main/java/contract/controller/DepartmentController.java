package contract.controller;

import contract.service.DepartmentService;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
     * @return
     */
    @RequestMapping(value = "get.do", method = RequestMethod.POST)
    public ServerResponse getAllDepartment(){
        return departmentService.getAllDepartment();
    }
}
