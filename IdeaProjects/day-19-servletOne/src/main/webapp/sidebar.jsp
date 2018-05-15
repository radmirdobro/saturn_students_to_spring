<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="sidebar">
    <a class="dashboard" href="/inner/dashboard">Расписание </a>
    <a class="personal" href="/inner/personal">Личная информация</a>

     <%if((Integer)request.getSession().getAttribute("role")==3){%>
    <%//расписание(просмотр, добавить ответ на дз)%>
    <a class="marks" href="/inner/marks">Успеваемость</a>
    <%} if((Integer)request.getSession().getAttribute("role")==2){%>
    <%//расписание (просмотр, добавить материалы, добавить дз, поставить оценку)   %>
    <a href="/inner/statistic">Статистика по студентам</a>
    <%} if((Integer)request.getSession().getAttribute("role")==4){%>
    <a href="/inner/timetable">Редактировать расписание </a>
<%}%>
</div>