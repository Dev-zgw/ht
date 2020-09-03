package contract.controller;

import contract.service.HtService;
import contract.service.HtqsService;
import contract.utils.ExcelReaderUtil;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/htdr/")
public class DrController {

    @Autowired
    private HtService htService;

    @Autowired
    private HtqsService htqsService;

    /**
     * excel文件导入
     */
    @RequestMapping(value = "import.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse<Integer> Import(HttpServletResponse response, @RequestParam(value = "file") MultipartFile file){
        response.setCharacterEncoding("utf-8");
        FileInputStream inputStream=null;
        ServerResponse serverResponse =null;
        if (file==null){
            return ServerResponse.createBySuccessMessage("文件导入失败");
        }
        File files= null;
        try {
            files = ExcelReaderUtil.multipartFileToFile(file);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createBySuccessMessage("文件导入失败");
        }
        try {
            //inputStream = new FileInputStream(new File(filepath));
            inputStream = new FileInputStream(files);
            Map<String ,List<Map<String,Object>>> map = ExcelReaderUtil.readExcel(inputStream, files.getName());
            //保存到数据库中
            List<Map<String, Object>> htlist=map.get("ht");
            List<Map<String, Object>> htqslist=map.get("htqs");
            htService.daoru(htlist);
            htqsService.daoru(htqslist);
        }catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createBySuccessMessage("文件导入失败");
        }
        return serverResponse;
    }
}
