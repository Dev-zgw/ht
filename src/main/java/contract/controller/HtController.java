package contract.controller;

import contract.dao.UsersMapper;
import contract.pojo.Users;
import contract.service.HtService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("/ht/")
public class HtController {

    @Autowired
    private HtService htService;

    @Autowired
    private UsersMapper userMapper;

    /**
     * 查询合同信息
     * @param session
     * @param pageNum   页码
     * @param pageSize  每页显示条数
     * @param htfl      合同分类
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param fzr       负责人
     * @param htzt      合同状态
     * @return
     */
    @RequestMapping(value = "getquery.do", method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse getquery(HttpSession session, int pageNum, int pageSize,String htfl,String startTime,
                                    String endTime,String fzr,String htzt){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htService.query(user,pageNum,pageSize,htfl,startTime,endTime,fzr,htzt);
    }


}
