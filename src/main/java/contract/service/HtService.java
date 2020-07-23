package contract.service;

import contract.pojo.Ht;
import contract.pojo.Users;
import contract.utils.ServerResponse;

import java.util.List;

public interface HtService {

    ServerResponse<List<Ht>> query(Users user, int pageNum, int pageSize, String htfl, String startTime,
                                   String endTime, String fzr, String htzt);
}
