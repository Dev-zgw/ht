package contract.controller;

import contract.dao.UsersMapper;
import contract.pojo.Ht;
import contract.pojo.Htfl;
import contract.pojo.Users;
import contract.service.HtService;
import contract.service.HtflService;
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
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/htfl/")
public class HtflController {

    @Autowired
    private HtflService htflService;

    @Autowired
    private HtService htService;

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
    private ServerResponse deletes(String userid,int id){
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
    private ServerResponse insert(String userid, String flmc){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        return htflService.insert(user, flmc);
    }





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
    private ServiceResponsebg<List<Ht>> getquery(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, String userid, String htfl, String qsrq,
                                                 String fzr, String ssfzr, String htzt, String dqsheng, String diqushi, String je,String htbh,String sfjxfw){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        return htService.query(user,currentPage,pageSize,htfl,qsrq,fzr,ssfzr,htzt,dqsheng,diqushi,je,htbh,sfjxfw);
    }

    /**
     * 合同修改
     * @param session
     * @param ht
     * @return
     */
    @RequestMapping(value = "update.do", method =RequestMethod.POST)
    @ResponseBody
    private ServerResponse update(int id,String userid, String htbh,String htmc,String qsrq,String htqsrq,String htzzrq,String fzr,String ssfzr,String yymc,String yyjb,
                                  String dqsheng,String dqshi,String htfl,String htnrhtnr,String nywfje,String nywfsj,String xxkxm,
                                  String xxklxfs,String cwkxm,String cwklxfs,String ywdjr,String ywdjrlxfs,String bz,String sfgb,String sfjxfw,String yjqysj,String xmqksm) {
        Users user = usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        Ht ht = new Ht();
        ht.setSfgb(sfgb);
        ht.setSfjxfw(sfjxfw);
        if(!("").equals(yjqysj)){
            ht.setYjqysj(new Date(Long.parseLong(yjqysj)));
        }
        ht.setXmqksm(xmqksm);
        ht.setId(new BigDecimal(id));
        ht.setHtbh(htbh);
        ht.setHtmc(htmc);
        if (!("").equals(qsrq)) {

            ht.setQsrq(new Date(Long.parseLong(qsrq)));
        }
        if (!("").equals(htqsrq)) {
            ht.setHtqsrq(new Date(Long.parseLong(htqsrq)));
        }
        if (!("").equals(htzzrq)) {
            ht.setHtzzrq(new Date(Long.parseLong(htzzrq)));
        }
        if (!("").equals(fzr)) {
            ht.setFzrid(new BigDecimal(fzr));
            ht.setFzr(usersMapper.selectByPrimaryKey(ht.getFzrid()).getXm());
        }
        if (!("").equals(ssfzr)) {
            ht.setSsfzrid(new BigDecimal(ssfzr));
            ht.setSsfzr(usersMapper.selectByPrimaryKey(ht.getSsfzrid()).getXm());
        }
        ht.setYymc(yymc);
        ht.setYyjb(yyjb);
        ht.setDqsheng(dqsheng);
        ht.setDqshi(dqshi);
        ht.setHtfl(htfl);

        if (!("").equals(htnrhtnr)) {
            ht.setHtnrhtnr(new BigDecimal(htnrhtnr));
        }
        if (!("").equals(nywfje)) {
            ht.setNywfje(new BigDecimal(nywfje));
        }
        if (!("".equals(nywfsj))) {
            ht.setNywfsj(new Date(Long.parseLong(nywfsj)));
        }
        ht.setXxkxm(xxkxm);
        ht.setXxklxfs(xxklxfs);
        ht.setCwkxm(cwkxm);
        ht.setCwklxfs(cwklxfs);
        ht.setYwdjr(ywdjr);
        ht.setYwdjrlxfs(ywdjrlxfs);
        ht.setBz(bz);
        return htService.update(user, ht);
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
        private ServerResponse xinzeng(String userid, String htbh, String htmc,String qsrq,String htqsrq,String htzzrq,String fzr,String ssfzr,String yymc,String yyjb,
                String dqsheng,String dqshi,String htfl,String htnrhtnr,String nywfje,String nywfsj,String xxkxm,
                String xxklxfs,String cwkxm,String cwklxfs,String ywdjr,String ywdjrlxfs,String bz,
                                       String sfgb,String sfjxfw,String yjqysj,String xmqksm){
            Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
            Ht ht=new Ht();
            ht.setSfgb(sfgb);
            ht.setSfjxfw(sfjxfw);
            if(!("").equals(yjqysj)){
                ht.setYjqysj(new Date(Long.parseLong(yjqysj)));
            }
            ht.setXmqksm(xmqksm);
            ht.setHtbh(htbh);
            ht.setHtmc(htmc);
            if(!("").equals(qsrq)){
                ht.setQsrq(new Date(Long.parseLong(qsrq)));
            }
            if(!("").equals(htqsrq)){
                ht.setHtqsrq(new Date(Long.parseLong(htqsrq)));
            }
            if(!("").equals(htzzrq)){
                ht.setHtzzrq(new Date(Long.parseLong(htzzrq)));
            }
            if(!("").equals(fzr)){
                ht.setFzrid(new BigDecimal(fzr));
                ht.setFzr(usersMapper.selectByPrimaryKey(ht.getFzrid()).getXm());
            }
            if(!("").equals(ssfzr)){
                ht.setSsfzrid(new BigDecimal(ssfzr));
                ht.setSsfzr(usersMapper.selectByPrimaryKey(ht.getSsfzrid()).getXm());
            }
            ht.setYymc(yymc);
            ht.setYyjb(yyjb);
            ht.setDqsheng(dqsheng);
            ht.setDqshi(dqshi);
            ht.setHtfl(htfl);
            if(!("").equals(htnrhtnr)){
                ht.setHtnrhtnr(new BigDecimal(htnrhtnr));
            }
            if(!("").equals(nywfje)){
                ht.setNywfje(new BigDecimal(nywfje));
            }
            if(!("".equals(nywfsj))){
                ht.setNywfsj(new Date(Long.parseLong(nywfsj)));
            }
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
    @RequestMapping(value = "deleteht.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse delete(String userid,int id){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        return htService.delete(user,id);
    }

}
