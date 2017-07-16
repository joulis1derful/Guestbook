<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link rel="stylesheet" href="style.css">
<body>

<table class="guests-table">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
        <th>Date of Birth</th>
        <th>Telephone</th>
        <th>Country</th>
        <th>City</th>
        <th> </th>
    </tr>

    <c:forEach items="${requestScope.users}" var="guest">
        <tr>
            <td>${guest.fname}</td>
            <td>${guest.lname}</td>
            <td>${guest.email}</td>
            <td>${guest.dob}</td>
            <td>+${guest.tel}</td>
            <td><a href="country?co=${guest.country}">${guest.country}</a></td>
            <td>${guest.city}</td>
            <td><a href="delete?lname=${guest.lname}"><img src="minus.png"></a></td>
        </tr>
    </c:forEach>
</table>

    <form action = "/users" >
        <p><b>Страна:</b><br>
            <input type="text" name="country" size="40">
        </p>
    <button type="submit">SUBMIT</button>
    <form>

        <br>
        <br>

   <%--<%--%>
        <%--List<User> userList = DAO.getWithCountry(request.getParameter("country"));--%>
        <%--for(int i = 0; i<userList.size(); i++){--%>
            <%--out.print("\t  "+userList.get(i).getFname());--%>
             <%--out.print("\t  "+userList.get(i).getLname());--%>
              <%--out.print("\t  "+userList.get(i).getEmail());--%>
               <%--out.print("\t  "+userList.get(i).getDob());--%>
                <%--out.print("\t  "+userList.get(i).getTel());--%>
                 <%--out.print("\t  "+userList.get(i).getCountry());--%>
                  <%--out.print("\t  "+userList.get(i).getCity());--%>
        <%--}--%>

       <%--%>--%>
        <br>
<br>
<br>
<a href="/">Main Page</a>
</body>
</html>
