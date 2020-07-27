package contract.controller;

import contract.pojo.Users;
import contract.service.ResultService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/result/")
public class ResultController {

    @Autowired
    private ResultService resultService;

    /**
     * 分页查看日志信息
     * @param session
     * @param pageNum    页码
     * @param pageSize   每页显示条数
     * @param htbh       合同编号
     * @param startTime  开始时间
     * @param endTime    结束时间
     * @return
     */
    @RequestMapping(value = "query.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse query(HttpSession session,int pageNum, int pageSize,String htbh,String startTime,
                                 String endTime){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
       return resultService.query(user,pageNum,pageSize,htbh,startTime,endTime);
    }
}
