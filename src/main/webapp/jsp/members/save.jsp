<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="war.servlet.domain.member.Member" %>
<%@ page import="war.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: ryudongjae
  Date: 2021/07/04
  Time: 12:44 오전
  To change this template use File | Settings | File Templates.
--%>
<%
    //request,response 사용가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id =<%=member.getId() %></li>
    <li>username =<%=member.getUsername() %></li>
    <li>age =<%=member.getAge() %></li>
</ul>
<a href="/index.html"> 메인 </a>
</body>
</html>
