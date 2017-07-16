<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet", href="style.css">
    <meta http-equiv="Content-Type" content="text/html; utf-8">
    <title>Register</title>
</head>
<body>
<form action="register.jsp" method="POST">
    <table border="0">
        <tbody>
        <tr>
            <td>First Name : </td>
            <td><input type="text" name="fname" value="" size="50" required pattern="^[a-zA-Z]+$" /></td>
        </tr>
        <tr>
            <td>Last Name : </td>
            <td><input type="text" name="lname" value="" size="50" required pattern="^[a-zA-Z]+$" /></td>
        </tr>
        <tr>
            <td>E-mail Address : </td>
            <td><input type="text" name="email" value="" size="50" required pattern="\S+@[a-z]+.[a-z]+" /></td>
        </tr>
        <tr>
            <td>Date of birth : </td>
            <td><input type="text" name="dob" value="DD.MM.YYYY" size="15" required pattern="[0-9]+.[0-9]+.[0-9]+" /></td>
        </tr>
        <tr>
            <td>Telephone : </td>
            <td>+<input type="text" name="tel" value="" size="50" required pattern="[0-9]{12}" /></td>
        </tr>
        <tr>
            <td>Country : </td>
            <td><input type="text" name="country" value="" size="50" required pattern="^[a-zA-Z]+$" /></td>
        </tr>
        <tr>
            <td>City/town : </td>
            <td><input type="text" name="city" value="" size="50" required pattern="^[a-zA-Z]+$" /></td>
        </tr>
        </tbody>
    </table>
    <input type="reset" value="Clear" name="clear" />
    <input type="submit" value="Submit" name="submit" />
</form>
</body>
</html>