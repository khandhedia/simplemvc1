<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ToDo!</title>
    <%--Generally CSS is added in Head--%>
    <%--We are using Mini version of bootstrap CSS which is present in bootstrap webjar in resources section--%>
    <%--As we need to use CSS/JS from resources section of webjar, we need to inform spring to look there--%>
    <%--Below is the tag to be added in spring.xml--%>
    <%--<mvc:resources mapping="/webjars/**" location="/webjars/"/>--%>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>

<div class="container"> <%--div is used to put entire section as one segment--%>
    <%--container tag puts entire segment with proper border, alignement, etc. --%>
    Welcome ${name}! Your ToDos are here:<br/>
    <table class="table table-striped">
        <caption><h1>ToDo List</h1></caption>

        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th>Action</th>
        </tr>
        <tr/>
        </thead>

        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                    <%--For boolean variable bean variable might be isDone, but for JSTL, we only use done ('is' not needed)--%>
                <td><a class="btn btn-danger" type="button" href="/spring-webmvc/delete-todo?id=${todo.id}">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <tr/>
    <tr/>

    <%--${todos} </br>--%>
    <div>
        <a class="btn btn-success" type="button" href="/spring-webmvc/add-todo">Add</a>
    </div>

    <%--Generally JS is added before body tag is over--%>
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</div>
</body>
</html>