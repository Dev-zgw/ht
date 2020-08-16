package contract.service;

import contract.pojo.Ht;
import contract.pojo.Report;
import contract.pojo.Users;
import contract.utils.ServerResponse;

import java.util.List;

/**
 * @Description
 * @Author green_crane
 * @Date 2020/8/7 16:34
 */
public interface ReportService {

        ServerResponse<List<Report>> getBasicInfo(Users user, int htCount,int htTotalPrice,int departmentPeopleNum,int totalPeopleNum);
}
