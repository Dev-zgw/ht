package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.HtMapper;
import contract.dao.RoleMapper;
import contract.dao.UsersMapper;
import contract.pojo.Ht;
import contract.pojo.Role;
import contract.pojo.Users;
import contract.service.HtService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("htService")
public class HtServiceImpl implements HtService {

    @Autowired
    private HtMapper htMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UsersMapper userMapper;

    //查询合同信息
    @Override
    public ServerResponse<List<Ht>> query(Users user, int pageNum, int pageSize, String htfl, String startTime,
                                          String endTime, String fzr, String htzt) {
        Role role=roleMapper.selectByPrimaryKey(user.getJsid());
        PageHelper.startPage(pageNum,pageSize);
        List<Ht> list=new ArrayList<>();
        //管理员查询所有合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ADMIN){
            list=htMapper.select(htfl,startTime,endTime,fzr,htzt);
        }

        //总经理权限查看合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ZJL){
            list=htMapper.select(htfl,startTime,endTime,fzr,htzt);
        }

        //部门经理只能查看该部门的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            //先查询该部门的所有用户
            List<Users> listUser=userMapper.select(user.getSsbm());

            for(int i=0;i<listUser.size();i++){
                //分别查询每个用户的合同
                List<Ht> htList=htMapper.selectyh(listUser.get(i).getId(),htfl,startTime,endTime,htzt);
                for(int j=0;j<htList.size();j++){
                    //查询出的数据放入一个list集合中分页使用
                    list.add(htList.get(j));
                }
            }
        }

        //普通用户只能查看自己的合同信息
        if(role.getQxid().longValue()== Const.Role.ROLE_CUSTOMER){
            list=htMapper.selectyh(user.getId(),htfl,startTime,endTime,htzt);
        }
        PageInfo<Ht> pageInfo = new PageInfo<Ht>(list);
        return ServerResponse.createBySuccess(pageInfo.getTotal(),list);
    }

}
