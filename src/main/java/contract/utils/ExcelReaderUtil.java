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
    public static Map<String,List<Map<String, Object>>> readExcel(InputStream in, String fileName) throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
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
            for (int j = 3; j <=sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                //去掉空行和表头
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                //遍历所有的列

                //合同表
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("htbh", row.getCell(0));
                map.put("htmc", row.getCell(1));
                map.put("yymc", row.getCell(2));
                map.put("dqsheng", row.getCell(3));
                map.put("dqshi", row.getCell(4));
                map.put("htfl", row.getCell(5));
                map.put("yyjb", row.getCell(6));
                map.put("qsrq", row.getCell(7));
                map.put("htqsrq", row.getCell(8));
                map.put("htzzrq", row.getCell(9));
                map.put("htnrhtnr", row.getCell(10));
                map.put("fzr", row.getCell(11));
                map.put("ssfzr", row.getCell(12));
                map.put("nywfje", row.getCell(55));
                map.put("nywfsj", row.getCell(56));
                map.put("xxkxm", row.getCell(57));
                map.put("xxklxfs", row.getCell(58));
                map.put("cwkxm", row.getCell(59));
                map.put("cwklxfs", row.getCell(60));
                map.put("ywdjr", row.getCell(61));
                map.put("ywdjrlxfs", row.getCell(62));
                map.put("sfgb", row.getCell(63));
                map.put("sfjxfw", row.getCell(64));
                map.put("yjqysj", row.getCell(65));
                map.put("xmqksm", row.getCell(66));
                map.put("bz", row.getCell(67));
                map.put("htzt", row.getCell(68));
                list.add(map);

                //合同期数表
                Map<String, Object> maphtqs1 = new HashMap<String, Object>();
                maphtqs1.put("htbh", row.getCell(0));
                maphtqs1.put("je", row.getCell(13));
                maphtqs1.put("sj", row.getCell(14));
                maphtqs1.put("yjsj", row.getCell(15));
                maphtqs1.put("sfskwc", row.getCell(16));
                maphtqs1.put("ssfzr", row.getCell(17));
                maphtqs1.put("bz", row.getCell(18));
                lists.add(maphtqs1);
                Map<String, Object> maphtqs2 = new HashMap<String, Object>();
                maphtqs2.put("htbh", row.getCell(0));
                maphtqs2.put("je", row.getCell(19));
                maphtqs2.put("sj", row.getCell(20));
                maphtqs2.put("yjsj", row.getCell(21));
                maphtqs2.put("sfskwc", row.getCell(22));
                maphtqs2.put("ssfzr", row.getCell(23));
                maphtqs2.put("bz", row.getCell(24));
                lists.add(maphtqs2);
                Map<String, Object> maphtqs3 = new HashMap<String, Object>();
                maphtqs3.put("htbh", row.getCell(0));
                maphtqs3.put("je", row.getCell(25));
                maphtqs3.put("sj", row.getCell(26));
                maphtqs3.put("yjsj", row.getCell(27));
                maphtqs3.put("sfskwc", row.getCell(28));
                maphtqs3.put("ssfzr", row.getCell(29));
                maphtqs3.put("bz", row.getCell(30));
                lists.add(maphtqs3);
                Map<String, Object> maphtqs4 = new HashMap<String, Object>();
                maphtqs4.put("htbh", row.getCell(0));
                maphtqs4.put("je", row.getCell(31));
                maphtqs4.put("sj", row.getCell(32));
                maphtqs4.put("yjsj", row.getCell(33));
                maphtqs4.put("sfskwc", row.getCell(34));
                maphtqs4.put("ssfzr", row.getCell(35));
                maphtqs4.put("bz", row.getCell(36));
                lists.add(maphtqs4);
                Map<String, Object> maphtqs5 = new HashMap<String, Object>();
                maphtqs5.put("htbh", row.getCell(0));
                maphtqs5.put("je", row.getCell(37));
                maphtqs5.put("sj", row.getCell(38));
                maphtqs5.put("yjsj", row.getCell(39));
                maphtqs5.put("sfskwc", row.getCell(40));
                maphtqs5.put("ssfzr", row.getCell(41));
                maphtqs5.put("bz", row.getCell(42));
                lists.add(maphtqs5);
                Map<String, Object> maphtqs6 = new HashMap<String, Object>();
                maphtqs6.put("htbh", row.getCell(0));
                maphtqs6.put("je", row.getCell(43));
                maphtqs6.put("sj", row.getCell(44));
                maphtqs6.put("yjsj", row.getCell(45));
                maphtqs6.put("sfskwc", row.getCell(46));
                maphtqs6.put("ssfzr", row.getCell(47));
                maphtqs6.put("bz", row.getCell(48));
                lists.add(maphtqs6);
                Map<String, Object> maphtqs7 = new HashMap<String, Object>();
                maphtqs7.put("htbh", row.getCell(0));
                maphtqs7.put("je", row.getCell(49));
                maphtqs7.put("sj", row.getCell(50));
                maphtqs7.put("yjsj", row.getCell(51));
                maphtqs7.put("sfskwc", row.getCell(52));
                maphtqs7.put("ssfzr", row.getCell(53));
                maphtqs7.put("bz", row.getCell(54));
                lists.add(maphtqs7);
            }
        }
        Map<String ,List<Map<String,Object>>> sj =new HashMap<>();
        sj.put("ht",list);
        sj.put("htqs",lists);
        return sj;
    }
    //根据文件后缀，自适应上传文件的版本
    public static Workbook getWorkbook(InputStream instr, String filename) throws Exception {
        Workbook wb = null;
        String fileType = filename.substring(filename.lastIndexOf("."));
        if (excel2003L.equals(fileType)) {
            wb = new HSSFWorkbook(instr); //2003
        } else if (excel2007U.equals(fileType)) {
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
