package contract.controller;

import contract.pojo.Htfl;
import contract.pojo.Users;
import contract.service.HtflService;
import contract.utils.Const;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/htfl/")
public class HtflController {

    @Autowired
    private HtflService htflService;

    /**
     * 查询合同分类
     * @param session
     * @return
     */
    @RequestMapping(value = "query.do" , method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse getquery(HttpSession session){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htflService.query();
    }

    /**
     * 删除合同分类
     * @param session
     * @param id
     * @return
     */
    @RequestMapping(value = "delete.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse delete(HttpSession session,int id){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htflService.delete(user,id);
    }

    /**
     * 新增合同分类
     * @param session
     * @param htfl
     * @return
     */
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse insert(HttpSession session, Htfl htfl){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htflService.insert(user, htfl);
    }

}
