package contract.service.impl;

import contract.dao.DepartmentMapper;
import contract.pojo.Department;
import contract.service.DepartmentService;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zgh
 * @create 2020/8/14 14:32
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询部门
     * @return
     */
    @Override
    public ServerResponse<List<Department>> getAllDepartment() {
        return ServerResponse.createBySuccess(departmentMapper.selectAll());
    }
}
