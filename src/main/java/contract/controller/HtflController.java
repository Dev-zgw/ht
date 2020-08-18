package contract.controller;

import contract.dao.UsersMapper;
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
import java.math.BigDecimal;

@Controller
@RequestMapping("/htfl/")
public class HtflController {

    @Autowired
    private HtflService htflService;

    @Autowired
    private UsersMapper usersMapper;

    /**
     * 查询合同分类
     * @param session
     * @return
     */
    @RequestMapping(value = "query.do" , method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse getquery(String userid){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
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
    private ServerResponse delete(String userid,int id){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
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
    private ServerResponse insert(String userid, Htfl htfl){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        return htflService.insert(user, htfl);
    }

}
