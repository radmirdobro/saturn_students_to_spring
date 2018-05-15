<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<div class="small_block">
    <h2><%=request.getAttribute("message") %></h2>


    <center>

        <%=("authErr".equals(request.getParameter("errorMsg"))) ? "Неверное имя пользователя/пароль" : ""%><BR>
        <%=("noAuth".equals(request.getParameter("errorMsg"))) ? "Авторизуйтесь, пожалуйста!" : ""%><BR>
    </center>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" value="user" name="userName">
        <input type="password" value="password" name="userPassword">
        <input type="submit" value="Войти">
    </form>
</div>
<div class="clear"></div>
<%@ include file="footer.jsp" %>
