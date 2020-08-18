package contract.service.impl;

import contract.dao.HtflMapper;
import contract.dao.ResultMapper;
import contract.pojo.Htfl;
import contract.pojo.Result;
import contract.pojo.Users;
import contract.service.HtflService;

import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("htflService")
public class HtflServiceImpl implements HtflService {

    @Autowired
    private HtflMapper htflMapper;

    @Autowired
    private ResultMapper resultMapper;

    @Override
    public ServerResponse<List<Htfl>> query() {
        List<Htfl> htfls=htflMapper.select();
        return ServerResponse.createBySuccess(htfls);
    }

    @Override
    public ServerResponse delete(Users users,int id) {
        int i=htflMapper.deleteByPrimaryKey(new BigDecimal(id));
        if (i <= 0) {
            Result result=new Result();
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同分类删除");
            result.setBz("合同分类删除失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createByErrorMessage("删除合同分类失败");
        }
        Result result=new Result();
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同分类删除");
        result.setBz("合同分类删除成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("删除合同分类成功");
    }

    @Override
    public ServerResponse insert(Users users, Htfl htfl) {
        htfl.setCreateTime(new Date());
        htfl.setCreateBy(users.getXm());
        int i=htflMapper.insertSelective(htfl);
        if (i <= 0) {
            Result result=new Result();
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("新增合同分类");
            result.setBz("新增合同分类失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createByErrorMessage("新增合同分类失败");
        }
        Result result=new Result();
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("新增合同分类");
        result.setBz("新增合同分类成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("新增增合同分类成功");
    }
}
