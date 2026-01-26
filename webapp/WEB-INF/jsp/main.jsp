<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<%
	//セッションスコープに保存されたユーザー情報を取得
	User loginUser = (User)session.getAttribute("loginUser");
	//アプリケーションスコープに保存されたリストを取得
	List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけんゲーム</title>
<style>
	<%@ include file="style.css" %>
</style>
	<script src="<%= request.getContextPath() %>/logoutCheck.js" defer></script>
	<script src="<%= request.getContextPath() %>/mouseover.js" defer></script>
</head>
<body>
	<h1>じゃんけんゲームをはじめるよ！</h1>
	<p>
		<%= loginUser.getName() %>さん、ログイン中
		
		<a href="Logout" onclick="return logoutCheck();">ログアウト</a>
		
	</p>
	<p><a href="Main">更新</a></p>
	<h2>好きな手を選んでね♪いざ勝負！</h2>
	<form action="Main" method="post">
	<div class="form">
		<div class="hand">
			<input type="submit" name="radiobutton" value="グー" id="action1">
			<input type="submit" name="radiobutton" value="チョキ" id="action2">
			<input type="submit" name="radiobutton" value="パー" id="action3">
		</div>
	</div>
	</form>
	
	<% for (Mutter mutter : mutterList) { %>
		<p><%= mutter.getUserName() %>：<%= mutter.getHand() %></p>
	<% } %>
	
</body>
</html>