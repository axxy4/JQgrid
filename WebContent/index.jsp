<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>
</head>
<body>
	<h1>Add Student</h1>
	<form action="AddStudent" method="post">
		<table>
			<tr>
				<td>FirstName:</td>
				<td><input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><input type="text" name="lastname" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Mobile:</td>
				<td><input type="text" name="mobile" /></td>
			</tr>
			<tr>
				<td>State:</td>
				<td><input type="text" name="state" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Student" /></td>
			</tr>
		</table>
	</form>

	<br />
	<a href="ViewStudent?page=1">view Student</a>
		
	

</body>
</html>