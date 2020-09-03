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
}
