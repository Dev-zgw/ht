package contract.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import contract.dao.HtMapper;
import contract.pojo.Ht;
import contract.service.HtService;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("htService")
public class HtServiceImpl implements HtService {

    @Autowired
    private HtMapper htMapper;


    @Override
    public ServerResponse<List<Ht>> init(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Ht> list=htMapper.select();
        PageInfo<Ht> pageInfo = new PageInfo<Ht>(list);
        return ServerResponse.createBySuccess(pageInfo.getTotal(),list);
    }
}
