package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.ResultMapper;
import contract.dao.RoleMapper;
import contract.dao.UsersMapper;
import contract.pojo.Result;
import contract.pojo.Role;
import contract.pojo.Users;
import contract.service.ResultService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("resultService")
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UsersMapper userMapper;

    /**
     * 分页查询日志信息
     * @param user
     * @param pageNum
     * @param pageSize
     * @param htbh
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public ServiceResponsebg<List<Result>> query(Users user, int pageNum, int pageSize, String htbh, String sj,
                                                 String xm) {
        PageHelper.startPage(pageNum,pageSize);
        String startTime="";
        String endTime="";
        if(sj!=""&&sj!=null ) {
            String date[] = sj.split(",");
            startTime = date[0].toString().substring(1,date[0].toString().length()-1);
            endTime = date[1].toString().substring(1,date[1].toString().length()-1);
        }
        Role role=roleMapper.selectByPrimaryKey(user.getJsid());
        List<Result> list=new ArrayList<>();
        //管理员,总经理,财务询所有日志信息
        if(role.getQxid().longValue()== Const.Role.ROLE_ADMIN||role.getQxid().longValue()== Const.Role.ROLE_ZJL
        ||role.getQxid().longValue()== Const.Role.ROLE_CWQX){
            list=resultMapper.query(htbh,startTime,endTime,xm);
        }
        //部门经理只能查看该部门的日志信息
        if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            //先查询该部门的所有用户
            List<Users> listUser=userMapper.select(user.getSsbm());
            for(int i=0;i<listUser.size();i++){
                List<Result> results=resultMapper.query(htbh,startTime,endTime,listUser.get(i).getXm());
                for(int j=0;j<results.size();j++){
                    //查询出的数据放入一个list集合中分页使用
                    list.add(results.get(j));
                }
            }
        }
        //普通用户只能查看自己的日志信息
        if(role.getQxid().longValue()== Const.Role.ROLE_CUSTOMER){
            list=resultMapper.query(htbh,startTime,endTime,user.getXm());
        }
        PageInfo<Result> pageInfo = new PageInfo<Result>(list);
        return ServiceResponsebg.createBySuccess(pageInfo.getTotal(),list);
    }
}
