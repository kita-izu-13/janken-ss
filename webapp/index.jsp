<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけんゲーム</title>
<style>
	<%@ include file="WEB-INF/jsp/style.css" %>
</style>
</head>
<body>
	<h1>じゃんけんゲームができるよ！</h1>
	<p>ログインしてね♪</p>
	<form action="Login" method="post">
		ユーザー名：<input type="text" name="name"><br>
		パスワード：<input type="password" name="pass"><br>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>