<%@ page import="ru.innopolis.stc9.servlets.pojo.Timetable" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<div class="content">
        <% Timetable hwInfo = (Timetable) request.getAttribute("hwInfo");%>

    <h2>Домашнее задание от <%=hwInfo.getDate()%>
    </h2>
    <h3>Предмет: <%=request.getAttribute("sname")%>
    </h3>
        <%=("done".equals(request.getParameter("succesMsg"))) ? "<div class='msg success'>Операция выполнена успешно!</div>" : ""%><BR>


    <h4>Формулировка:</h4>
    <p><%=hwInfo.getHomework()%>
    </p>

    <h4>Ответ:</h4>
    <p><%if (request.getAttribute("answer") == null) {%>
        Нет загруженных ответов.
        <%} else {%>
        <%=request.getAttribute("answer")%>
        <%}%>
    </p>
        <%if(request.getAttribute("url") != null){%>
    <span>Ссылка на github: <%=request.getAttribute("url")%></span>
        <%}%>
        <%=("emptyFields".equals(request.getParameter("errorMsg"))) ? "<div class='msg error'>Заполните поля формы!</div>" : ""%>
    <h4>Загрузить/изменить дз:</h4>
    <form action="${pageContext.request.contextPath}/inner/homework" method="post">
        <textarea name="answer" placeholder="Мой Ответ"></textarea>
        <input type="text" name="url" placeholder="Ссылка на гитхаб" value="">
        <input type="hidden" name="sid" value="<%=request.getParameter("sid")%>">
        <input type="hidden" name="lesson" value="<%=request.getParameter("lesson")%>">
        <input type="submit" value="Сохранить">
    </form>
    <div class="clear"></div>
<%@ include file="footer.jsp" %>