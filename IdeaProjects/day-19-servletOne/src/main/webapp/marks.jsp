<%@ page import="ru.innopolis.stc9.servlets.pojo.Subject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ include file="sidebar.jsp" %>


<div class="content">
    <h2>Успеваемость</h2>
    <% ArrayList<Subject> subjectsWithMarks = (ArrayList<Subject>) request.getAttribute("subjectsWithMarks"); %>
    <table>
        <thead>
        <tr>
            <th>Предмет</th>
            <th>Количество занятий</th>
            <th>Средний балл</th>
        </tr>
        </thead>
        <tbody>
        <%for (int a = 0; a < subjectsWithMarks.size(); a++) {%>
        <tr>
            <td><%=subjectsWithMarks.get(a).getSname()%></td>
            <td><%=subjectsWithMarks.get(a).getSubj_counter()%></td>
            <td><%=subjectsWithMarks.get(a).getMark_summ()/subjectsWithMarks.get(a).getSubj_counter()%></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
<div class="clear"></div>
<%@ include file="footer.jsp" %>