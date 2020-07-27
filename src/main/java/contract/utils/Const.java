package contract.utils;

public class Const {

    public static final String CURRENT_USER="currentuser";

    public interface Role{
        //四种权限
        long ROLE_ADMIN=0;//管理员
        long ROLE_ZJL=1;//总经理（可查看所有合同）
        long ROLE_BMJL=2;//部门经理（可查看该部门的所有合同）
        long ROLE_CUSTOMER=3;//普通用户(销售人员只能查看自己的合同)
    }

    public interface HtState{
        //合同三种状态
        long TO_BE_CONFIRMED=0;//待确认
        long HAVE_IN_HAND=1;//进行中
        long COMPLETED=2;//已完成
    }

}
