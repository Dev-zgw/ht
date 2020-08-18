package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import contract.dao.*;
import contract.pojo.Ht;
import contract.pojo.Report;
import contract.pojo.Role;
import contract.pojo.Users;
import contract.service.ReportService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/7 16:35
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private RoleMapper roleMapper;


    //查询合同信息
    @Override
    public ServerResponse<List<Report>> getBasicInfo(Users user, int htCount, int htTotalPrice, int departmentPeopleNum, int totalPeopleNum) {
        Role role=roleMapper.selectByPrimaryKey(user.getJsid());
        List<Report> list=new ArrayList<>();
        //管理员
        if(role.getQxid().longValue()== Const.Role.ROLE_ADMIN){
            list = reportMapper.selectBasicInfo(htCount,htTotalPrice,departmentPeopleNum,totalPeopleNum);
        }

        //总经理
        if(role.getQxid().longValue()== Const.Role.ROLE_ZJL){
            list = reportMapper.selectBasicInfo(htCount,htTotalPrice,departmentPeopleNum,totalPeopleNum);
        }

        //部门经理
        if(role.getQxid().longValue()== Const.Role.ROLE_BMJL){
            list = reportMapper.selectBasicInfo(htCount,htTotalPrice,departmentPeopleNum,totalPeopleNum);
        }

        //普通用户
        if(role.getQxid().longValue()== Const.Role.ROLE_CUSTOMER){
            list = reportMapper.selectBasicInfo(htCount,htTotalPrice,departmentPeopleNum,totalPeopleNum);
        }
        return ServerResponse.createBySuccess(list);
    }
}
