package contract.service.impl;

import com.alibaba.fastjson.JSON;
import contract.dao.DepartmentMapper;
import contract.pojo.Department;
import contract.service.DepartmentService;
import contract.utils.DepartmentTree;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     *
     * @return
     */
    @Override
    public ServerResponse<List<Department>> getAllDepartment() {
        return ServerResponse.createBySuccess(departmentMapper.selectAll());
    }

    /**
     * 获取部门树
     *
     * @return
     */
    public Map<String, Object> getDeptTree() {
        //得到源数据
        List<Department> list = departmentMapper.selectAll();
        List<DepartmentTree> departmentTrees = new ArrayList<>();
        for (Department department : list) {
            DepartmentTree departmentTree = new DepartmentTree();
            String s = department.getId().toString();
            departmentTree.setId(department.getId().toString());
            departmentTree.setPid(department.getPid().toString());
            departmentTree.setLabel(department.getBmmc());
            departmentTrees.add(departmentTree);
        }
        //声明最终树
        ArrayList<DepartmentTree> FinaTree = new ArrayList<>();
        //找出一级菜单
        for (DepartmentTree departmentTree : departmentTrees) {
            if (departmentTree.getPid().equals("0")) {
                FinaTree.add(departmentTree);
            }
        }

        //为一级菜单设置子菜单
        for (DepartmentTree departmentTree : FinaTree) {
            //递归
            departmentTree.setChildren(getChild(departmentTree.getId(), departmentTrees));
        }

        HashMap<String, Object> m = new HashMap<>();
        m.put("info", FinaTree);
        return m;
    }

    /**
     * 添加部门
     *
     * @param department
     * @return
     */
    @Override
    public ServerResponse addDept(Department department) {
        departmentMapper.insertSelective(department);
        return ServerResponse.createBySuccessMessage("新建部门成功");
    }

    /**
     * 修改部门信息
     *
     * @param department
     * @return
     */
    @Override
    public ServerResponse updataDept(Department department) {
        int i = departmentMapper.updateByPrimaryKeySelective(department);
        if (i <= 0) {
            ServerResponse.createByErrorMessage("修改失败");
        }
        return ServerResponse.createBySuccessMessage("修改成功");
    }

    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @Override
    public ServerResponse deleteDept(BigDecimal id) {
        departmentMapper.deleteByPrimaryKey(id);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public Department getOneById(BigDecimal id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    private static List<DepartmentTree> getChild(String id, List<DepartmentTree> rootMenu) {
        // 子菜单
        List<DepartmentTree> childList = new ArrayList<>();
        for (DepartmentTree menu : rootMenu) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (menu.getPid().equals(id)) {
                childList.add(menu);
            }
        }

        // 把子菜单的子菜单再循环一遍
        for (DepartmentTree menu : childList) {
            menu.setChildren(getChild(menu.getId(), rootMenu));      // 递归
        }

        // 判断递归结束
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
}
