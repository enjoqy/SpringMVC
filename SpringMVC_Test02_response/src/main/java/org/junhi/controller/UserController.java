package org.junhi.controller;

import org.junhi.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author junhi
 * @date 2019/7/3 17:28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回值是string
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法被执行了。。。");
        //模拟从数据库中查出user对象
        User user = User.builder().username("小妹").password("123").age(22).build();
        //model对象，里面封装了session.getAttribute(),效果类似
        model.addAttribute("user", user);
        return "success";
    }


    /**
     * 返回值是void
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法被执行了。。。");
        //编写请求转发的程序
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //重定向
//        response.sendRedirect(request.getContextPath()+ "/index.jsp");

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接进行相应
        response.getWriter().print("你好");
    }

    /**
     * 返回modelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法被执行了。。。");
        //模拟从数据库中查出user对象
        User user = User.builder().username("小峰").password("456").age(21).build();

        //把user对象存储到mv对象中，也会把user对象存到request对象
        mv.addObject(user);

        //跳转到哪个页面
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法被执行了。。。");

        //请求转发
//        return "forward:/WEB-INF/pages/success.jsp";

        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 测试ajax异步请求
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法被执行了。。。");
        //客户端发的是ajax请求，传的是字符串，后端吧json字符串封装到user对象中
        System.out.println(user);

        //做响应，模拟查询数据库
        user.setAge(18);
        user.setPassword("baba");

        return user;
    }




}
