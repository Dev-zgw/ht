package contract.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReaderUtil {
    private final static String excel2003L = ".xls";    //2003- 版本的excel
    private final static String excel2007U = ".xlsx";   //2007+ 版本的excel
    //excel导入
    public static List<Map<String, Object>> readExcel(InputStream in, String fileName) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        //创建excel表格
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            //遍历当前sheet所有行
            for (int j = 2; j < sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                //去掉空行和表头
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                //遍历所有的列
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("jjlx", row.getCell(1));
                list.add(map);
            }
        }

        return list;
    }
    //根据文件后缀，自适应上传文件的版本
    public static Workbook getWorkbook(InputStream instr, String filename) throws Exception {
        Workbook wb = null;
        String fileType = filename.substring(filename.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(instr); //2003
        } else if (excel2007U.equals(instr)) {
            wb = new XSSFWorkbook(instr); //2007
        } else {
            throw new ClassCastException("文件格式错误");
        }
        return wb;
    }
    //将前台传入的文件转换成file
    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
