<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="cn.temptation.domain.Apple"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body><!-- placeholder -->
<form action="user/login" method="post">
<label>账号：</label>
<input type="text" id="txtUsername" name="username" value="" /><br/>
<label>密码：</label>
<input type="password" id="txtPassword" name="password" value="" /><br/>
<input type="submit" value="提交" />
<input type="reset" value="重置" />
</form>
           <br>
            <br>
             <br>
              <br>
          <!--     &nbsp    &nbsp    &nbsp    &nbsp    &nbsp    &nbsp 
              &nbsp    &nbsp    &nbsp    &nbsp    &nbsp    &nbsp   &nbsp    &nbsp -->
           <%
                  out.println("--------------------------------Hello World！  V1.0版本-------------------------------");
 //             out.println(new Apple());
              
              Apple ap=new Apple();
              out.println("");
              out.print("JAVA类信息================");
              out.println("");
              out.print("<br>名称："+ap.getName());
//              out.print("<br>名称："+ap.setName("苹果"));
     //         out.print("<br>班级："+xb.getBanj());
     //         out.print("<br>性别："+xb.getXingb());
    //          out.print("<br>学号："+xb.getXueh());
              
                           
              
           %>
            <br>
             <br>
               <br> <br> <br> <br>
<form action="main.jsp" method="GET">
站点名: <input type="text" name="name">
<br />
网址: <input type="text" name="url" />
<input type="submit" value="提交" />
</form>
</body>
</html>