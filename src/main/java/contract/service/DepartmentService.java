package contract.service;

import contract.pojo.Department;
import contract.utils.ServerResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author zgh
 * @create 2020/8/14 14:30
 */
public interface DepartmentService {
    ServerResponse<List<Department>> getAllDepartment();

    Map<String, Object> getDeptTree();

    //添加部门
    ServerResponse addDept(Department department);

    //修改部门
    ServerResponse updataDept(Department department);

    //删除部门
    ServerResponse deleteDept(BigDecimal id);

    Department getOneById(BigDecimal id);
}
