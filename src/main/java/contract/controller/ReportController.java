package contract.controller;
import contract.dao.UsersMapper;
import contract.pojo.*;
import contract.pojo.Reportpage.*;
import contract.service.ReportService;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/7 16:32
 */

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UsersMapper usersMapper;

    @RequestMapping(value = "getchart4.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Chart4>> selectChart1(String userid, String htfl, String qsrq,
                                                     String fzr, String ssfzr, String fzrbm, String ssfzrbm, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectChart4(user,htfl,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,diqushi);
    }

    @RequestMapping(value = "getchart5.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<Chart5>> selectChart5(String userid, String qsrq){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectChart5(user,qsrq);
    }

    @RequestMapping(value = "getchart9.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<getchart9info>> selectChart9(String userid, String htfl, String qsrq,
                                                            String fzr, String ssfzr, String fzrbm, String ssfzrbm, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectChart9(user,htfl,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,diqushi);
    }

    @RequestMapping(value = "getchart6.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<getchart6info>> selectChart6(String userid, String htfl, String qsrq,
                                                            String fzr, String ssfzr, String fzrbm, String ssfzrbm, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectChart6(user,qsrq,htfl,fzr,fzrbm,dqsheng,diqushi);
    }

    @RequestMapping(value = "getchart9_sum.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<getchart9info>> selectChart9_sum(String userid, String htfl, String qsrq,
                                                                String fzr, String ssfzr, String fzrbm, String ssfzrbm, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectChart9_sum(user,htfl,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,diqushi);
    }
    @RequestMapping(value = "getchart9_avg.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<getchart9info>> selectChart9_avg(String userid, String htfl, String qsrq,
                                                                String fzr, String ssfzr, String fzrbm, String ssfzrbm, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectChart9_avg(user,htfl,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,diqushi);
    }
    @RequestMapping(value = "getchart9_count.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<getchart9info>> selectChart9_count(String userid, String htfl, String qsrq,
                                                                  String fzr, String ssfzr, String fzrbm, String ssfzrbm, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectChart9_count(user,htfl,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,diqushi);
    }

    @RequestMapping(value = "getchart9_htfl.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<String>> selectChart9_htfl(String userid, String htfl, String qsrq,
                                                                  String fzr, String ssfzr,String fzrbm, String ssfzrbm, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectChart9_htfl(user,htfl,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,diqushi);
    }

    @RequestMapping(value = "selectPersonalcurrentinfo.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse selectPersonalcurrentinfo(String userid){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectPersonalcurrentinfo(user);
    }

    @RequestMapping(value = "selectCurrentMonthSimpleInfo.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse selectCurrentMonthSimpleInfo(String userid){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectCurrentMonthSimpleInfo(user);
    }

    @RequestMapping(value = "selectFkhtSimpleInfo.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse selectFkhtSimpleInfo(String userid, String htfl, String qsrq,
                                                String fzr,String fzrbm, String ssfzr, String ssfzrbm, String dqsheng, String dqshi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectFkhtSimpleInfo(user,htfl,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,dqshi);
    }

    @RequestMapping(value = "selecthtqs.do",method = RequestMethod.POST)
    @ResponseBody
    private ServiceResponsebg<List<ComplexHtqs>> selecthtqs(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, String userid, String htfl, String htbh, String qsrq,
                                                            String fzr, String ssfzr, String fzrbm, String ssfzrbm, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        return reportService.selecthtqs(user, currentPage,pageSize,htfl,htbh,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,diqushi);
    }

    @RequestMapping(value = "selectDepartmentcurrentinfo.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse selectDepartmentcurrentinfo(String userid){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        if(user==null){
            return ServerResponse.createByErrorMessage("用户未登陆");
        }
        return reportService.selectDepartmentcurrentinfo(user.getXm());
    }

    @RequestMapping(value = "selectCompanycurrentinfo.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse selectCompanycurrentinfo(){
        return reportService.selectCompanycurrentinfo();
    }

    @RequestMapping(value = "selectPersonalatble.do",method = RequestMethod.POST)
    @ResponseBody
    private ServiceResponsebg<List<ComplexHt>> selectPersonalatble(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                                                   @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, String userid, String htfl, String htbh, String qsrq,
                                                                   String fzr, String ssfzr, String fzrbm, String ssfzrbm, String htzt, String dqsheng, String diqushi){
        Users user=usersMapper.selectByPrimaryKey(new BigDecimal(userid));
        return reportService.queryPersonaltable(user, currentPage,pageSize,htfl,qsrq,fzr,fzrbm,ssfzr,ssfzrbm,dqsheng,diqushi);
    }


    //查询所有部门
    @RequestMapping(value = "querybm.do",method =RequestMethod.POST)
    @ResponseBody
    private ServerResponse querybm(){
        return reportService.querybm();
    }


    //查询所有用户
    @RequestMapping(value = "queryfzrbybm.do",method =RequestMethod.POST)
    @ResponseBody
    private ServerResponse queryfzr(String bm){
        if (bm==""|| bm==null){
            return null;
        }
        return reportService.queryfzrbybm(bm);
    }

    //查询所有实施用户
    @RequestMapping(value = "queryssfzrbybm.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse queryssfzr(String bm){
        if (bm==""|| bm==null){
            return null;
        }
        return reportService.queryssfzrbybm(bm);
    }

}
