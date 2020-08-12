package contract.controller;

import contract.dao.UsersMapper;
import contract.pojo.Htqs;
import contract.pojo.Users;
import contract.service.HtqsService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/htqs/")
public class HtqsController {


    @Autowired
    private HtqsService htqsService;

    /**
     * 查询合同期数
     * @param session
     * @param htbh  合同编号
     * @return
     */
    @RequestMapping(value = "query.do", method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse query(HttpSession session,String htbh){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htqsService.query(user,htbh);
    }

    /**
     * 修改合同期数
     * @param session
     * @param htqs
     * @return
     */
    @RequestMapping(value = "update.do",method =RequestMethod.POST)
    @ResponseBody
    private ServerResponse update(HttpSession session, Htqs htqs){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htqsService.update(user,htqs);
    }

    /**
     * 新增合同期数
     * @param session
     * @param htqs
     * @return
     */
    @RequestMapping(value = "xinzeng.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse  xinzeng(HttpSession session,Htqs htqs){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htqsService.xinzeng(user,htqs);
    }

    /**
     * 根据id删除合同期数
     * @param session
     * @param id
     * @return
     */
    @RequestMapping(value ="delete.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse delete(HttpSession session,int id){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htqsService.delete(user,id);
    }
}
