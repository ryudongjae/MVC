<%@ page import="war.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: ryudongjae
  Date: 2021/07/04
  Time: 2:01 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>

    <li>id =${member.id}</li>
    <li>username =${member.username}</li>
    <li>age =${member.age}</li>
</ul>
<a href="/index.html"> 메인 </a>
</body>
</html>