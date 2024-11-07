<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="spring.mvc1.domain.member.Member" %>
<%@ page import="spring.mvc1.domain.member.MemberRepository" %>

<%
    // request, response는 그냥 사용가능,
    // HttpServlet request response는 jsp도 결국 servlet으로 바뀜. 자동변환
    // jsp에서 문법상 지원이 됨
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id = <%= member.getId() %></li>
    <li>username = <%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href = "index.html">메인으로</a>
</body>
</html>