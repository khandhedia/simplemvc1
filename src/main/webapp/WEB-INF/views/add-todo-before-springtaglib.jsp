<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>ToDo!</title>
    <link href="webjars/bootstrap/3.2.0/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Add ToDo</h1>
    <form action="/spring-webmvc/add-todo" method="post">
        <fieldset class="form-group">
            <label>Description: </label>
            <input name="desc" type="text" class="form-control" required="required"/>
        </fieldset>
        <input class="btn btn-success" type="submit" value="Add">
    </form>
    <%--Generally JS is added before body tag is over--%>
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</div>
</body>
</html>