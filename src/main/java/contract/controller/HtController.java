package contract.controller;

import contract.dao.UsersMapper;
import contract.pojo.Ht;
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
     * @param htjemax   合同金额最大值
     * @param htjemin   合同金额最小值
     * @return
     */
    @RequestMapping(value = "getquery.do", method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse getquery(HttpSession session, int pageNum, int pageSize,String htfl,String startTime,
                                    String endTime,String fzr,String htzt,String dqsheng,String diqushi,String htjemax,String htjemin){
       /* Users user=(Users) session.getAttribute(Const.CURRENT_USER);
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }*/
        Users user = usersMapper.selectByPrimaryKey(new BigDecimal(1));
        return htService.query(user,pageNum,pageSize,htfl,startTime,endTime,fzr,htzt,dqsheng,diqushi,htjemax,htjemin);
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
