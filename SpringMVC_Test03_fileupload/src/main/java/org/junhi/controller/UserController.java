package org.junhi.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author junhi
 * @date 2019/7/4 19:53
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 测试跨服务器文件上传，注意需要手动在文件服务器的目标文件夹下，创建一个uploads文件（名称和这边定义的相同）
     *
     * @return
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传。。。");

        //上传位置
        String path = "http://localhost:8080/uploads/";

        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        //把文件的名称设置为唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //完成文件的上传，跨服务器上传

        //创建客户端的对象
        Client client = Client.create();

        //和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);

        //上传文件
        webResource.put(upload.getBytes());

        return "success";
    }

    /**
     * 测试SpringMVC文件上传
     *
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("SpringMVC文件上传。。。");

        //使用fileupload组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件
            file.mkdirs();
        }
        //说明是上传文件项
        //获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        //把文件的名称设置为唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;
        //完成文件的上传
        upload.transferTo(new File(path, fileName));

        return "success";
    }

    /**
     * 测试传统文件上传
     *
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传。。。");

        //使用fileupload组件完成文件上传
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建该文件
            file.mkdirs();
        }

        //解析request
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历items
        for (FileItem item : items) {
            //进行判断，当前item对象是否是上传文件项
            if (item.isFormField()) {
                //说明是普通表单项
            } else {
                //说明是上传文件项
                //获取上传文件的名称
                String fileName = item.getName();
                //把文件的名称设置为唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                //完成文件的上传
                item.write(new File(path, fileName));
                //删除临时文件,当文件小于10KB会在内存中缓存，大于10KB会生成一个临时文件
                item.delete();
            }

        }

        return "success";
    }
}
