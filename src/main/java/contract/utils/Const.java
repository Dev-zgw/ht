package contract.utils;

public class Const {

    public static final String CURRENT_USER="currentuser";

    public interface Role{
        //四种权限
        long ROLE_ADMIN=0;//管理员
        long ROLE_ZJL=1;//总经理（可查看所有合同）
        long ROLE_BMJL=2;//部门经理（可查看该部门的所有合同）
        long ROLE_CUSTOMER=3;//普通用户(销售人员只能查看自己的合同)
        long ROLE_SSYH=4;//实施用户(查看自己负责实施的合同信息)
        long ROLE_CWQX=5;//财务权限(查询所有合同)
    }

    public interface HtState{
        //合同四种状态
        long TO_BE_CONFIRMED=0;//待确认
        long HAVE_IN_HAND=1;//进行中
        long COMPLETED=2;//已完成
        long REJECTED=3;//已驳回
    }

    public interface HtfqState{
        long HAVE_IN_HAND=1;//未收款
        long COMPLETED=2;//已收款
    }

}
