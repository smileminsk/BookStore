<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2 align="center">Book List</h2>
    <table border="1" align="center">
        <c:forEach var="listValue" items="${bList}">
            <tr>
                <td>${listValue.bookName}</td>
                <td>${listValue.bookAuthor}</td>
                <td>
                    <spring:form id="del" action="/del?bid=${listValue.bookId}" method="post">
                        <input type="submit" value="Delete" >
                    </spring:form>

                </td>
                <td>
                        <a href="/dwn?bid=${listValue.bookId}">${listValue.fileName}</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="4" align="center">
                <spring:form action="/addbookform" method="get">
                    <input type="submit" value="Add book" >
                </spring:form>
            </td>
        </tr>
    </table>

</body>
</html>


