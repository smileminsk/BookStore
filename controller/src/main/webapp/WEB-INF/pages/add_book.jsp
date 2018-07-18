<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new book</title>
</head>
<body>
<h2 align="center">Add Book</h2>
<spring:form modelAttribute="bookFromServer" method="post" action="/add"
              enctype="multipart/form-data">
    <table border="0" align="center">
        <tr>
            <td>Book title</td>
            <td><spring:input id="title" path="bookName"/></td>
        </tr>
        <tr>
            <td>Book author</td>
            <td><spring:input id="author" path="bookAuthor"/></td>
        </tr>
        <tr>
            <td>File</td>
            <td><input type="file" name="file"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <spring:button>Save</spring:button>
            </td>
        </tr>
    </table>
</spring:form>
</body>
</html>