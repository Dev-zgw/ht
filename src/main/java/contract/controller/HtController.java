package contract.controller;

import contract.dao.UsersMapper;
import contract.pojo.Ht;
import contract.pojo.Users;
import contract.service.HtService;
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
import java.util.List;

@Controller
@RequestMapping("/ht/")
public class HtController {

    @Autowired
    private HtService htService;

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
     * @param htzt      合同状态
     * @param dqsheng   地区-省
     * @param diqushi   地区-市
     * @return
     */
    @RequestMapping(value = "getquery.do", method = RequestMethod.POST)
    @ResponseBody
    private ServiceResponsebg<List<Ht>> getquery(HttpSession session, @RequestParam(value = "page", defaultValue = "1") int pageNum,
                                                 @RequestParam(value = "limit", defaultValue = "10") int pageSize, String htfl, String qsrq,
                                                 String fzr,String ssfzr, String htzt, String dqsheng, String diqushi, String je){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServiceResponsebg.createByErrorMessage("用户未登陆");
        }
        return htService.query(user,pageNum,pageSize,htfl,qsrq,fzr,ssfzr,htzt,dqsheng,diqushi,je);
    }

    /**
     * 合同修改
     * @param session
     * @param ht
     * @return
     */
    @RequestMapping(value = "update.do", method =RequestMethod.POST)
    @ResponseBody
    private ServerResponse update(HttpSession session, Ht ht){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htService.update(user,ht);
    }

    //查询所有用户
    @RequestMapping(value = "queryfzr.do",method =RequestMethod.POST)
    @ResponseBody
    private ServerResponse queryfzr(HttpSession session){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htService.queryfzr();
    }

    //查询所有实施用户
    @RequestMapping(value = "queryssfzr.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse queryssfzr(HttpSession session){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htService.queryssfzr();
    }

    /**
     * 合同驳回/确认
     * @param session
     * @param id
     * @param htzt
     * @return
     */
    @RequestMapping(value ="updatezt.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse updatezt(HttpSession session,int id, String htzt){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htService.updatezt(user,id,htzt);
    }

    /**
     * 合同录入
     * @param session
     * @param ht
     * @return
     */
    @RequestMapping(value = "xinzeng.do", method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse xinzeng(HttpSession session, Ht ht){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htService.xinzeng(user,ht);
    }

    /**
     * 合同删除
     * @param session
     * @paramid
     * @return
     */
    @RequestMapping(value = "delete.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse delete(HttpSession session,int id){
        Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return htService.delete(user,id);
    }
}
