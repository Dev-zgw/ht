package contract.controller;

import contract.dao.UsersMapper;
import contract.pojo.Users;
import contract.service.ResultService;
import contract.utils.Const;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("/result/")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 分页查看日志信息
     * @param session
     * @param pageNum    页码
     * @param pageSize   每页显示条数
     * @param htbh       合同编号
     * @return
     */
    @RequestMapping(value = "query.do",method = RequestMethod.POST)
    @ResponseBody
    private ServiceResponsebg query(HttpSession session, @RequestParam(value = "currentPage", defaultValue = "1") int pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, String htbh, String sj,
                                    String xm){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServiceResponsebg.createByErrorMessage("用户未登陆");
        }
       return resultService.query(pageNum,pageSize,htbh,sj,xm);
    }
}
