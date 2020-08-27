package contract.controller;

import contract.pojo.Ht;
import contract.service.HtService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DsqController {
    @Autowired
    private HtService htService;

    public void pdyq(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<Ht> htList=htService.queryAll();
        for(int i=0;i<htList.size();i++){
            long htzzsj=0;
            long dqsj=0;
            try {
                 htzzsj=format.parse(format.format(htList.get(i).getHtzzrq())).getTime();
                 dqsj=format.parse(format.format(new Date())).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(htzzsj<dqsj){
              htService.updateyqzt(htList.get(i).getId().intValue(),"4");
              long yqts=(dqsj-htzzsj)/(1000L*3600L*24L);
              String htsyts="已到期";
              htService.updateyqts(htList.get(i).getId().intValue(),Long.toString(yqts),htsyts);
          }else{
              String yqts="未到期";
              long htsyts=(htzzsj-dqsj)/(1000L*3600L*24L);
              htService.updateyqts(htList.get(i).getId().intValue(),yqts,Long.toString(htsyts));
          }
        }
        System.out.println("执行定时器成功 : "+format.format(new Date()));
    }
}
