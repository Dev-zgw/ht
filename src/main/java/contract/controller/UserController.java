package contract.controller;

import contract.pojo.Users;
import contract.service.UserService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ServerResponse<Users> login(HttpSession session, @Param("name") String name, @Param("password") String password) {
        ServerResponse<Users> login = userService.login(name, password);
        if (login.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, login.getData());
        }
        return login;
    }

    /**
     * 修改用户信息
     *
     * @param users
     * @return
     */
    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    public ServerResponse updateUserInfo(Users users) {
        return userService.updateByPrimaryKeySelective(users);
    }

    /**
     * 分页查询列表
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    public ServiceResponsebg getRoleList(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                         @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                         String xm, Integer bmid, String zzzt) {
        return userService.selectUserList(currentPage, pageSize, xm, bmid, zzzt);
    }

    /**
     * 根据id查询一个用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getOne.do", method = RequestMethod.POST)
    public ServerResponse getUserById(@RequestParam(value = "id") int id) {
        return userService.getOneById(id);
    }

    /**
     * 添加用户
     *
     * @param users
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public ServerResponse addUser(Users users) {
        return userService.addUser(users);
    }

    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    public ServerResponse deleteUserById(@RequestParam(value = "id") int id) {
        return userService.deleteUser(id);
    }

    /**
     * 时间转换器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }



}
