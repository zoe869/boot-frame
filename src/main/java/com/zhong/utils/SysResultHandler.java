package com.zhong.utils;

public class SysResultHandler {
    public static SysResult success(Object object) {
        SysResult sysResult = new SysResult();
        sysResult.setData(object);
        sysResult.setCode(200);
        sysResult.setMessage("请求成功");
        return sysResult;
    }

    public static SysResult success() {
        return success(null);
    }

    public static <T> SysResult buildSysResult(Integer code, String message, T data) {
        SysResult sysResult = new SysResult();
        sysResult.setCode(code);
        sysResult.setMessage(message);
        sysResult.setData(data);
        return sysResult;
    }
}
