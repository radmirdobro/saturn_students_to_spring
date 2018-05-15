
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
			<td><%=request.getAttribute("studentAge") %></td>
		</tr>
		<ter>
			<td>Адрес</td>
			<td><%=request.getAttribute("studentAdres") %></td>
		</ter>
		<tr>
			<td>Телефон</td>
			<td><%=request.getAttribute("studentPhone") %></td>
		</tr>
		<tr>
			<td>E-mail</td>
			<td><%=request.getAttribute("studentEmail") %></td>
		</tr>
		<tr>
			<td>Группа</td>
			<td><%=request.getAttribute("studentGroup") %></td>
		</tr>
		<tr>
			<td>Курс</td>
			<td><%=request.getAttribute("studentCourse") %></td>
		</tr>
		<tr>
			<td>Логин</td>
			<td><%=(String)request.getSession().getAttribute("login")%></td>
		</tr>
		<tr>
			<td>Сменить пароль</td>
			<td></td>
		</tr>

	</table>
</div>
<div class="clear"></div>
<%@ include file="footer.jsp" %>