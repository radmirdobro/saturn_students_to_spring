<%@ page import="ru.innopolis.stc9.servlets.pojo.Timetable" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>
<div class="content">
    <h2>Расписание группы <%=request.getAttribute("gname")%></h2>
    <% ArrayList<Timetable> subjects = (ArrayList<Timetable>) request.getAttribute("subjects"); %>
    <table>
        <thead>
        <tr>
            <th>Предмет</th>
            <th>Дата</th>
            <th>Время</th>
            <th>ДЗ</th>
            <th>ДЗ</th>
        </tr>
        </thead>
        <tbody>
        <%for (int a = 0; a < subjects.size(); a++) {%>
        <tr>
            <td><%=subjects.get(a).getSname()%></td>
            <td><%=subjects.get(a).getDate()%></td>
            <td><%=subjects.get(a).getTime()%></td>
            <td><%=subjects.get(a).getHomework()%></td>
            <td><a href="/inner/homework?lesson=<%=subjects.get(a).getId()%>&sid=<%=subjects.get(a).getSubject_id()%>">
                перейти к дз >>></a></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<div class="clear"></div>
<%@ include file="footer.jsp" %>