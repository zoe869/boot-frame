package com.zhong.utils;

import java.util.List;

public class ResultUtil {

    public static Result success(){
        Result result = new Result();
        result.setCode(ConUtils.SUCCESS);
        result.setMsg("操作成功！");
        return result;
    }

    public static Result success(List list){
        Result result = new Result();
        result.setCode(ConUtils.SUCCESS);
        result.setMsg("操作成功！");
        result.setData(list);
        return result;
    }

    public static Result success(Object o){
        Result result = new Result();
        result.setCode(ConUtils.SUCCESS);
        result.setMsg("操作成功！");
        result.setData(o);
        return result;
    }

    public static Result success(String msg, Object object){
        Result result = new Result();
        result.setCode(ConUtils.SUCCESS);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result error(Exception e){
        Result result = new Result();
        result.setCode(ConUtils.ERROR);
        result.setMsg("操作失败，发生异常");
        //如果启用自定义日志，则在控制台打印错误信息
        Utils.log(e.getMessage());
        return result;
    }

    public static Result unSuccess(){
        Result result = new Result();
        result.setCode(ConUtils.UNSUCCESS);
        result.setMsg("操作失败！");
        return result;
    }

    public static Result unSuccess(String msg){
        Result result = new Result();
        result.setCode(ConUtils.UNSUCCESS);
        result.setMsg(msg);
        return result;
    }
}