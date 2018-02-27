<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<title>Users</title>
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
            <td>${guest.country}</td>
            <td>${guest.city}</td>
            <td><a href="users/delete?lname=${guest.lname}"><img src="minus.png"/></a></td>
        </tr>
    </c:forEach>
</table>

    <form action = "/users" method="post">
        <p><b>Country:</b><br>
            <input type="text" name="country" size="40">
        </p>
    <button name="filter" type="submit">SUBMIT</button>
    </form>
        <br>
<table class="guests-table">
<c:forEach items="${requestScope.filteredbycountry}" var="guest">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>E-mail</th>
        <th>Date of Birth</th>
        <th>Telephone</th>
        <th>Country</th>
        <th>City</th>
    </tr>
    <tr>
        <td>${guest.fname}</td>
        <td>${guest.lname}</td>
        <td>${guest.email}</td>
        <td>${guest.dob}</td>
        <td>+${guest.tel}</td>
        <td>${guest.country}</td>
        <td>${guest.city}</td>
    </tr>
</c:forEach>
</table>
<br>
<br>
<a href="/">Main Page</a>
</body>
</html>
