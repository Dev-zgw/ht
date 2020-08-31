package contract.controller;
import contract.dao.UsersMapper;
import contract.pojo.Ht;
import contract.pojo.Users;
import contract.service.HtService;
import contract.service.ReportService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/7 16:32
 */

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询合同信息
     * @param session
     * @param pageNum   页码
     * @param pageSize  每页显示条数
     * @param htfl      合同分类
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param fzr       负责人
     * @param htnrhtnr  合同金额
     * @param htzt      合同状态
     * @param dqsheng   地区-省
     * @param diqushi   地区-市
     * @return
     */
    @RequestMapping(value = "getquery.do", method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse getquery(HttpSession session, int pageNum, int pageSize, String htfl, String startTime,
                                    String endTime, String fzr, String htzt, String dqsheng, String diqushi,int htnrhtnr){
       /* Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }*/
        Users user = usersMapper.selectByPrimaryKey(new BigDecimal(1));
        //return reportService.query(user,pageNum,pageSize,htfl,startTime,endTime,fzr,htzt,dqsheng,diqushi,htnrhtnr);
        return null;
    }

    @RequestMapping(value = "getBasicInfo.do", method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse getBasicInfo(HttpSession session,int htCount,int htTotalPrice,int departmentPeopleNum,int totalPeopleNum){
        Users user = usersMapper.selectByPrimaryKey(new BigDecimal(1));
        return reportService.getBasicInfo(user,htCount,htTotalPrice,departmentPeopleNum,totalPeopleNum);
    }

}
