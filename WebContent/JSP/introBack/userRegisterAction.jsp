<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "user.UserDAO" %>
<%@ page import = "user.UserDTO" %>
<%@ page import = "util.SHA256" %>
<%@ page import = "java.io.PrintWriter" %>



<% 
	request.setCharacterEncoding("UTF-8"); 
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String agency = request.getParameter("agency");
	String tel = request.getParameter("tel");
	String birthdate = request.getParameter("birthdate");
	String gender = request.getParameter("gender");
	String zipcode = request.getParameter("zipcode");
	String address = request.getParameter("address");
	
%>
	

<%
	UserDAO userDAO = new UserDAO();	
	String msg = null;
	String location = null;
	
	int result = userDAO.join(id, pwd, name, email,agency, tel, birthdate, gender, zipcode, address, SHA256.getSHA256(email), false, 0);

	if(result == -1){
		msg = "회원가입에 실패 하였습니다";
		location = "/jspProject/JSP/introPage.jsp";
	}
	else{
		session.setAttribute("id", id);
		msg = "회원가입이 되었습니다 반갑습니다.";
		location = "/jspProject/JSP/introBack/emailSendAction.jsp";
	}

%>

<script>
	alert("<%=msg%>");
	location.href = "<%=location%>";
</script>