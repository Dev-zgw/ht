package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.UsersMapper;
import contract.pojo.Users;
import contract.service.UserService;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


/**
 * @author zgh
 * @create 2020/7/28 11:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    @Override
    public ServerResponse<Users> login(String name, String password) {
        int selectOne = usersMapper.selectOne(name);
        if (selectOne == 0) {
            return ServerResponse.createByErrorMessage("用户不存在！");
        }
        Users users = usersMapper.selectByUP(name, password);
        if (users == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createBySuccess("登录成功", users);
    }

    /**
     * 修改信息
     *
     * @param users
     * @return
     */
    @Override
    public ServerResponse updateByPrimaryKeySelective(Users users) {
        int i = usersMapper.updateByPrimaryKeySelective(users);
        if (i == 1) {
            return ServerResponse.createBySuccessMessage("用户信息修改成功");
        }
        return ServerResponse.createByErrorMessage("用户信息修改失败");
    }


    /**
     * 查询所有用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ServiceResponsebg<List<Users>> selectUserList(int pageNum, int pageSize, String xm, Integer bmid, String zzzt) {
        PageHelper.startPage(pageNum, pageSize);
        List<Users> users = usersMapper.selectUserList(xm, bmid, zzzt);
        PageInfo<Users> userPageInfo = new PageInfo<>(users);
        return ServiceResponsebg.createBySuccess(userPageInfo.getTotal(), users);

    }

    @Override
    public ServerResponse addUser(Users users) {
        int i = usersMapper.insertSelective(users);
        if (i == 1) {
            return ServerResponse.createBySuccessMessage("添加用户成功");
        }
        return ServerResponse.createByErrorMessage("添加用户失败");
    }

    @Override
    public ServerResponse deleteUser(int id) {
        int i = usersMapper.deleteByPrimaryKey(BigDecimal.valueOf(id));
        if (i == 1) {
            return ServerResponse.createBySuccessMessage("用户已删除");
        }
        return ServerResponse.createByErrorMessage("用户删除失败");
    }


    @Override
    public ServerResponse<Users> getOneById(int id) {
        Users users = usersMapper.selectByPrimaryKey(BigDecimal.valueOf(id));
        return ServerResponse.createBySuccess(users);
    }
}
