package contract.controller;

import contract.service.HtService;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ht/")
public class HtController {

    @Autowired
    private HtService htService;


    @RequestMapping(value = "init.do", method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse getinit(HttpSession session,  int pageNum, int pageSize){
        return htService.init(pageNum,pageSize);
    }
}
