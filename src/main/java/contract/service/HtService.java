package contract.service;

import contract.pojo.Ht;
import contract.utils.ServerResponse;

import java.util.List;

public interface HtService {

    ServerResponse<List<Ht>> init(int pageNum, int pageSize);
}
