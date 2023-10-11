<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>itwill.jsp</h1>

	전달 정보 ID (JSP표현식) : <%=request.getParameter("id") %><hr> 
	전달 정보 ID (EL표현식) : ${param.id}<hr> 
	전달 정보 ID (EL표현식2) : ${id} 얘를 쓸거에요<hr> 
	전달 정보 PW (EL표현식2) : ${pass} <hr> 
<!-- 	왜 가능하냐? @ModelAttribute 때문에 가능해요 SampleController2번에 필기 함  -->
	전달 정보 ID (EL표현식2) : ${requestScope.id}<hr> 

	<!-- 라이브러리는 자동으로 설치되어 있다. Maven에... -->
	
	<!-- param = request.getParameter(name) -->
	<!-- paramValues = request.getParameterValues(name) -->
	
	
	SampleController2<br>
	전달정보 IDS : ${paramValues.ids }<hr>
	<!-- [Ljava.lang.String;@57a8a259 => [L = 배열  -->
	전달정보 IDS0 : ${paramValues.ids[0] }<hr>
	전달정보 IDS1 : ${paramValues.ids[1] }<hr>
	
	<h3>SampleController3 객체 정보 출력</h3>
	${vo }<hr> <!-- 얘는 view로 출력이 안됩니다. -->
	${memberVO }<hr> <!-- 얘는 왜 되지요??????? -->
<%-- 	${requestScope }<!-- ????????? --> --%>
	
	${DBVO }<hr>
	
	
	
</body>
</html>