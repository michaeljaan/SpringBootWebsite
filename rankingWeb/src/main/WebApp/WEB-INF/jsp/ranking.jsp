 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ATP Ranking</title>
</head>
<body>
<h1>ATP Top 10 Ranking</h1>
	<div align="center">
			<h1>Top 10</h1>
			<jstl:if test="${ranking != null }">
			<table>
			<tr><th>Rank</th><th>Name</th><th>Country</th></tr>
			<jstl:forEach items="${ranking}" var="rank">
			    <tr><td>${rank.ranking}</td><td>${rank.name}</td><td>${rank.country }</td></tr>
			</jstl:forEach>
			</table>
			</jstl:if>
			<jstl:if test="${ranking == null}">
			<h2>ranking yet to be updated</h2>
			</jstl:if>


	</div>
</body>
</html>