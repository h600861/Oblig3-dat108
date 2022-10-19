<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/simple.css">
    <title>Login</title>
</head>
<body>

<p style="color:#ff0000">${redirectMessage}</p>
<form action="login" method="post">
    <h4>Gi inn Passord:</h4>
        <input type="text" name="password"/><br>
        <input type="submit" value="Logg inn"/><br>
</form>
</body>
</html>