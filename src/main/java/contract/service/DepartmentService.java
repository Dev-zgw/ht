package contract.service;

import contract.pojo.Department;
import contract.utils.ServerResponse;

import java.util.List;

/**
 * @author zgh
 * @create 2020/8/14 14:30
 */
public interface DepartmentService {
    ServerResponse<List<Department>> getAllDepartment();
}
