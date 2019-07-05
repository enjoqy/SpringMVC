<%--
  Created by IntelliJ IDEA.
  User: gdlzh
  Date: 2019/7/3
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.0.js"></script>
    <script>
        $(function () {
            //页面加载，绑定单击事件
            $("#btn").click(function () {
                // alert("hello");
                //发送ajax请求
                $.ajax({
                    //编写json格式，设置属性和值
                    url: "user/testAjax",
                    contentType: "application/json;charset=UTF-8",
                    data: '{"username":"haha", "password":"b1b1", "age":23}',
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        // data服务器端相应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);

                    }
                });
            });
        });
    </script>
</head>
<body>
<a href="user/testString">testString</a><br>

<a href="user/testVoid">testVoid</a><br>

<a href="user/testModelAndView">testModelAndView</a><br>

<a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>

<button id="btn">发送ajax请求</button>
</body>
</html>
