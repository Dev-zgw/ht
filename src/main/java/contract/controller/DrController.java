package contract.controller;

import contract.utils.ExcelReaderUtil;
import contract.utils.ServerResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/htdr/")
public class DrController {

    /**
     * excel文件导入
     */
    @RequestMapping(value = "import.do",method = RequestMethod.POST)
    @ResponseBody
    private ServerResponse<Integer> Import(HttpServletResponse response, @RequestParam(value = "file") MultipartFile file){
        response.setCharacterEncoding("utf-8");
        FileInputStream inputStream=null;
        List<Map<String, Object>> list=null;
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
            list = ExcelReaderUtil.readExcel(inputStream, files.getName());
            //保存到数据库中
        }catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createBySuccessMessage("文件导入失败");
        }
        return serverResponse;
    }
}
