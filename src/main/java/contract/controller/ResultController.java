package contract.controller;

import contract.pojo.Users;
import contract.service.ResultService;
import contract.utils.Const;
import contract.utils.ServerResponse;
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

    /**
     * 分页查看日志信息
     * @param session
     * @param currentPage
     * @param pageSize
     * @param htbh
     * @param startTime
     * @param endTime
     * @param xm
     * @return
     */
    @RequestMapping(value = "query.do",method = RequestMethod.POST)
    @ResponseBody
    private ServiceResponsebg query(HttpSession session,
                                    @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                    String htbh, String startTime, String endTime, String xm){
//        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
//        if(user==null){
//            return ServiceResponsebg.createByErrorMessage("用户未登陆");
//        }
        int i = 0;
       return resultService.query(currentPage,pageSize,htbh,startTime,endTime,xm);
    }

    @RequestMapping(value = "deleteAll.do",method = RequestMethod.POST)
    public ServerResponse deleteAll(){
        return resultService.deleteAll();
    }
}
