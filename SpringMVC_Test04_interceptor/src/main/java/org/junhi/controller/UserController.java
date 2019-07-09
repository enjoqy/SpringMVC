package org.junhi.controller;

import org.junhi.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author junhi
 * @date 2019/7/9 12:24
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("testException方法执行了");
        try {
            //模拟异常
            int a = 1/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询所有的用户出现了错误。。。");
        }
        return "success";
    }
}
