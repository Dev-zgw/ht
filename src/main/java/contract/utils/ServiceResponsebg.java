package contract.utils;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by geely
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServiceResponsebg<T> implements Serializable {

    private int code;
    private String msg;
    private T data;
    private long count;
    private long role;

    private ServiceResponsebg(int code){
        this.code = code;
    }

    private ServiceResponsebg(int code, T data){
        this.code = code;
        this.data = data;
    }

    private ServiceResponsebg(long role,int code, T data){
        this.role = role;
        this.code = code;
        this.data = data;

    }

    private ServiceResponsebg(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    private ServiceResponsebg(int code, long count, T data){
        this.code = code;
        this.data = data;
        this.count = count;
    }
    private ServiceResponsebg(int code,long role, long count, T data){
        this.role = role;
        this.code = code;
        this.data = data;
        this.count = count;
    }

    private ServiceResponsebg(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }

    public int getCode(){
        return code;
    }
    public long getCount(){
        return count;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }
    public long getRole(){return role;}

    public static <T> ServiceResponsebg<T> createBySuccess(){
        return new ServiceResponsebg<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServiceResponsebg<T> createBySuccessMessage(String msg){
        return new ServiceResponsebg<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServiceResponsebg<T> createBySuccess(T data){
        return new ServiceResponsebg<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> ServiceResponsebg<T> createBySuccess(long count, T data){
        return new ServiceResponsebg<T>(ResponseCode.SUCCESS.getCode(),count,data);
    }
    public static <T> ServiceResponsebg<T> createBySuccess(long role,long count, T data){
        return new ServiceResponsebg<T>(ResponseCode.SUCCESS.getCode(),role,count,data);
    }

    public static <T> ServiceResponsebg<T> createBySuccess(String msg, T data){
        return new ServiceResponsebg<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static <T> ServiceResponsebg<T> createByError(){
        return new ServiceResponsebg<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }


    public static <T> ServiceResponsebg<T> createByErrorMessage(String errorMessage){
        return new ServiceResponsebg<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServiceResponsebg<T> createByErrorCodeMessage(int errorCode, String errorMessage){
        return new ServiceResponsebg<T>(errorCode,errorMessage);
    }













}
