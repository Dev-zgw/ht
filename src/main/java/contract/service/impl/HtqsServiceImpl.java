package contract.service.impl;

import contract.dao.HtqsMapper;
import contract.dao.ResultMapper;
import contract.pojo.Htqs;
import contract.pojo.Result;
import contract.pojo.Users;
import contract.service.HtqsService;
import contract.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("htqsService")
public class HtqsServiceImpl implements HtqsService {

    @Autowired
    private HtqsMapper htqsMapper;

    @Autowired
    private ResultMapper resultMapper;

    /**
     * 根据合同编码查询合同期数
     * @param users
     * @param htbh
     * @return
     */
    @Override
    public ServerResponse<List<Htqs>> query(Users users, String htbh) {
        List<Htqs> htqsList=htqsMapper.query(htbh);
        return ServerResponse.createBySuccess(htqsList);
    }

    /**
     * 合同期数修改
     * @param users
     * @param htqs
     * @return
     */
    @Override
    public ServerResponse update(Users users, Htqs htqs) {
        htqs.setUpdateTime(new Date());
        htqs.setUpdateBy(users.getXm());
        int i=htqsMapper.updateByPrimaryKeySelective(htqs);
        if(i <= 0){
            Result result=new Result();
            result.setHtbh(htqs.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同期数修改");
            result.setBz("合同期数修改失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createByErrorMessage("修改合同期数失败");
        }
        Result result=new Result();
        result.setHtbh(htqs.getHtbh());
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同期数修改");
        result.setBz("合同期数修改成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("合同期数修改成功");
    }

    /**
     * 合同期数录入
     * @param users
     * @param htqs
     * @return
     */
    @Override
    public ServerResponse xinzeng(Users users, Htqs htqs) {
        htqs.setCreateTime(new Date());
        htqs.setCreateBy(users.getXm());
        htqs.setSfskwc("1");
        int i=htqsMapper.insertSelective(htqs);
        if(i<=0){
            Result result=new Result();
            result.setHtbh(htqs.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同期数录入");
            result.setBz("合同期数录入失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createByErrorMessage("合同期数录入失败");
        }
        Result result=new Result();
        result.setHtbh(htqs.getHtbh());
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同期数录入");
        result.setBz("合同期数录入成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("合同期数录入成功");
    }

    /**
     * 合同期数删除
     * @param users
     * @param id
     * @return
     */
    @Override
    public ServerResponse delete(Users users, int id) {
        Htqs htqs=htqsMapper.selectByPrimaryKey(new BigDecimal(id));
        if("2".equals(htqs.getSfskwc())){
            return ServerResponse.createByErrorMessage("该分期已收款完成，不能删除");
        }else{
            int i=htqsMapper.deleteByPrimaryKey(new BigDecimal(id));
            if(i<=0){
                Result result=new Result();
                result.setHtbh(htqs.getHtbh());
                result.setUserid(users.getId());
                result.setXm(users.getXm());
                result.setCzsj(new Date());
                result.setCznr("合同期数删除");
                result.setBz("合同期数删除失败");
                resultMapper.insertSelective(result);
                return ServerResponse.createByErrorMessage("合同期数删除失败");
            }
            Result result=new Result();
            result.setHtbh(htqs.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同期数删除");
            result.setBz("合同期数删除成功");
            resultMapper.insertSelective(result);
            return ServerResponse.createBySuccessMessage("合同期数删除成功");
        }
    }

    @Override
    public ServerResponse htqsxg(Users users, int id, String htfqzt) {
        Htqs htqs=htqsMapper.selectByPrimaryKey(new BigDecimal(id));
        int i=htqsMapper.updatezt(new BigDecimal(id),htfqzt);
        if(i<=0){
            Result result=new Result();
            result.setHtbh(htqs.getHtbh());
            result.setUserid(users.getId());
            result.setXm(users.getXm());
            result.setCzsj(new Date());
            result.setCznr("合同期数验收失败");
            result.setBz("合同期数验收失败");
            resultMapper.insertSelective(result);
            return ServerResponse.createBySuccessMessage("操作失败");
        }
        Result result=new Result();
        result.setHtbh(htqs.getHtbh());
        result.setUserid(users.getId());
        result.setXm(users.getXm());
        result.setCzsj(new Date());
        result.setCznr("合同期数验收成功");
        result.setBz("合同期数验收成功");
        resultMapper.insertSelective(result);
        return ServerResponse.createBySuccessMessage("操作成功");
    }
}
