<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>


<div class="content">
    <h2>Личная информация</h2>
    <table>
        <tr>
            <td>ФИО</td>
            <td><%=request.getAttribute("studentName") %>
            </td>
        </tr>
        <tr>
            <td>Возраст</td>
            <td><%=request.getAttribute("studentAge") %>
            </td>
        </tr>
        <ter>
            <td>Адрес</td>
            <td><%=request.getAttribute("studentAdres") %>
            </td>
        </ter>
        <tr>
            <td>Телефон</td>
            <td><%=request.getAttribute("studentPhone") %>
            </td>
        </tr>
        <tr>
            <td>E-mail</td>
            <td><%=request.getAttribute("studentEmail") %>
            </td>
        </tr>
        <tr>
            <td>Группа</td>
            <td><%=request.getAttribute("studentGroup") %>
            </td>
        </tr>
        <tr>
            <td>Курс</td>
            <td><%=request.getAttribute("studentCourse") %>
            </td>
        </tr>
        <tr>
            <td>Логин</td>
            <td><%=(String) request.getSession().getAttribute("login")%>
            </td>
        </tr>
    </table>
    <%=("done".equals(request.getParameter("succesMsg"))) ? "<div class='msg success'>Операция выполнена успешно!</div>" : ""%>
    <form action="${pageContext.request.contextPath}/inner/personal" method="post">
        <p>Сменить пароль</p>
        <input type="password" value="" name="oldPassword" placeholder="Старый пароль">
        <input type="password" value="" name="newPassword" placeholder="Новый пароль">
        <input type="submit" value="Изменить">
    </form>
</div>
<div class="clear"></div>
<%@ include file="footer.jsp" %>