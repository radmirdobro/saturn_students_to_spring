<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>НАУКА | Успеваемость студентов онлайн</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link href="${pageContext.request.contextPath}/imgs/favicon.ico" rel="shortcut icon" type="image/x-icon">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="bg"></div>
<div class="wrap">
    <div class="container">
        <header>
            <div class="wrapper">

                <a href="/" class="logo"></a>
                <div class="sys_name">Успеваемость студентов</div>
                <%if ((String) request.getSession().getAttribute("login") != null) {%>
                <div class="user">
                    <span>user: <%=(String) request.getSession().getAttribute("login")%>
                    </span>
                    <a href="/login?action=logout" class="btn">Выйти</a>
                </div>
                <%}%>
            </div>
        </header>

        <div class="clear"></div>

        <section>
            <div class="wrapper">
		