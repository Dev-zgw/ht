package contract.controller;

import contract.service.RoleService;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zgh
 * @create 2020/7/30 22:30
 */
@RestController
@RequestMapping("/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public ServiceResponsebg getRoleList() {
        return roleService.selectRoleList();

    }
}
