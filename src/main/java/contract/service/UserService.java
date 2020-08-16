package contract.service;

import contract.pojo.Users;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;

import java.util.List;

/**
 * @author zgh
 * @create 2020/7/28 11:27
 */
public interface UserService {
    //登录
    ServerResponse<Users> login(String name, String password);

    //修改
    ServerResponse updateByPrimaryKeySelective(Users users);

    //查询用户列表
    ServiceResponsebg<List<Users>> selectUserList(int pageNum, int pageSize, String xm, Integer bmid, String zzzt);

    //添加
    ServerResponse addUser(Users users);

    //查询一个user
    ServerResponse<Users> getOneById(int id);

    //删除user
    ServerResponse deleteUser(int id);
}
