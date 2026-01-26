<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<% 
	//セッションスコープからユーザー情報を取得
	User loginUser = (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけんゲーム</title>
<style>
	<%@ include file="style.css" %>
</style>
</head>
<body>
	<h1>じゃんけんゲーム・ログイン</h1>
	<% if(loginUser != null){ %>
		<p>ログインに成功しました</p>
		<p>ようこそ<%= loginUser.getName() %>さん</p>
		<a href="Main">じゃんけんゲームへ</a>
	<% }else{ %>
		<p>ログインに失敗しました</p>
		<a href="index.jsp">トップへ</a>
	<% } %>
</body>
</html>