# Layui 踩坑合集





-- 开发环境 

    --vagrant 虚拟机管理（192.168.56.2）
        --安装centos
        --docker
        --安装并运行mysql 镜像
        ----root/root
        --安装redis







-- 1 表单的button 标签类型默认是submit，请求执行完会自动刷新页面

    --解决方法：
        1，将类型改为button
        2，执行完后请求，加上return false

--2 执行页面跳转

    -- 使用 top.location.href
        eg：top.location.href='pages/index';