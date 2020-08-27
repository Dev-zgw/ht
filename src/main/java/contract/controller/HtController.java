package contract.controller;

import contract.dao.UsersMapper;
import contract.pojo.Ht;
import contract.pojo.Users;
import contract.service.HtService;
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
import java.util.Date;
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
    private ServiceResponsebg<List<Ht>> getquery( @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,String userid, String htfl, String qsrq,
                                                 String fzr,String ssfzr, String htzt, String dqsheng, String diqushi, String je){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        return htService.query(user,currentPage,pageSize,htfl,qsrq,fzr,ssfzr,htzt,dqsheng,diqushi,je);
    }

    /**
     * 合同修改
     * @param session
     * @param ht
     * @return
     */
    @RequestMapping(value = "update.do", method =RequestMethod.POST)
    @ResponseBody
    private ServerResponse update(int id,String userid, String htbh, Long qsrq,Long htqsrq,Long htzzrq,String fzr,String ssfzr,String yymc,String yyjb,
                                  String dqsheng,String dqshi,String htfl,String htnrhtnr,String nywfje,Long nywfsj,String xxkxm,
                                  String xxklxfs,String cwkxm,String cwklxfs,String ywdjr,String ywdjrlxfs,String bz){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        Ht ht=new Ht();
        ht.setId(new BigDecimal(id));
        ht.setHtbh(htbh);
        ht.setQsrq(new Date(qsrq));
        ht.setHtqsrq(new Date(htqsrq));
        ht.setHtzzrq(new Date(htzzrq));
        ht.setFzrid(new BigDecimal(fzr));
        ht.setSsfzrid(new BigDecimal(ssfzr));
        ht.setYymc(yymc);
        ht.setYyjb(yyjb);
        ht.setDqsheng(dqsheng);
        ht.setDqshi(dqshi);
        ht.setHtfl(htfl);
        ht.setHtnrhtnr(new BigDecimal(htnrhtnr));
        ht.setNywfje(new BigDecimal(nywfje));
        ht.setNywfsj(new Date(nywfsj));
        ht.setXxkxm(xxkxm);
        ht.setXxklxfs(xxklxfs);
        ht.setCwkxm(cwkxm);
        ht.setCwklxfs(cwklxfs);
        ht.setYwdjr(ywdjr);
        ht.setYwdjrlxfs(ywdjrlxfs);
        ht.setBz(bz);
        return htService.update(user,ht);
    }

    //查询所有用户
    @RequestMapping(value = "queryfzr.do",method =RequestMethod.POST)
    @ResponseBody
    private ServerResponse queryfzr(){
        return htService.queryfzr();
    }

    //查询所有实施用户
    @RequestMapping(value = "queryssfzr.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse queryssfzr(){
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
    private ServerResponse updatezt(String userid,int id, String htzt){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
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
    private ServerResponse xinzeng(String userid, String htbh, Long qsrq,Long htqsrq,Long htzzrq,String fzr,String ssfzr,String yymc,String yyjb,
                                   String dqsheng,String dqshi,String htfl,String htnrhtnr,String nywfje,Long nywfsj,String xxkxm,
                                   String xxklxfs,String cwkxm,String cwklxfs,String ywdjr,String ywdjrlxfs,String bz){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        Ht ht=new Ht();
        ht.setHtbh(htbh);
        ht.setQsrq(new Date(qsrq));
        ht.setHtqsrq(new Date(htqsrq));
        ht.setHtzzrq(new Date(htzzrq));
        ht.setFzrid(new BigDecimal(fzr));
        ht.setSsfzrid(new BigDecimal(ssfzr));
        ht.setYymc(yymc);
        ht.setYyjb(yyjb);
        ht.setDqsheng(dqsheng);
        ht.setDqshi(dqshi);
        ht.setHtfl(htfl);
        ht.setHtnrhtnr(new BigDecimal(htnrhtnr));
        ht.setNywfje(new BigDecimal(nywfje));
        ht.setNywfsj(new Date(nywfsj));
        ht.setXxkxm(xxkxm);
        ht.setXxklxfs(xxklxfs);
        ht.setCwkxm(cwkxm);
        ht.setCwklxfs(cwklxfs);
        ht.setYwdjr(ywdjr);
        ht.setYwdjrlxfs(ywdjrlxfs);
        ht.setBz(bz);
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
    private ServerResponse delete(String userid,int id){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        return htService.delete(user,id);
    }
}
