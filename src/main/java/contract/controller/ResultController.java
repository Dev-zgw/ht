package contract.controller;

import contract.service.ResultService;
import contract.utils.ServerResponse;
import contract.utils.ServiceResponsebg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/result/")
public class ResultController {

    @Autowired
    private ResultService resultService;

    /**
     * 分页查看日志信息
     *
     * @param currentPage
     * @param pageSize
     * @param htbh
     * @param startTime
     * @param endTime
     * @param xm
     * @return
     */
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody
    private ServiceResponsebg query(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                    @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                                    String htbh, String startTime, String endTime, String xm) throws ParseException {
        String nstartTime = null;
        String nendTime = null;
        if (startTime != null && endTime != null){
            startTime = startTime.replace("Z", " UTC");
            endTime = endTime.replace("Z", " UTC");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
            Date date_startTime = format.parse(startTime);
            Date date_endTime = format.parse(endTime);

            SimpleDateFormat formatToString = new SimpleDateFormat("yyyy-MM-dd");
            nstartTime = formatToString.format(date_startTime);
            nendTime = formatToString.format(date_endTime);
        }
        return resultService.query(currentPage, pageSize, htbh, nstartTime, nendTime, xm);
    }

    /**
     * 清空日志
     *
     * @return
     */
    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    public ServerResponse deleteAll() {
        return resultService.deleteAll();
    }

}
