<%@include file="common/header.jspf" %>

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
            <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>
            <td>${todo.done}</td>
                <%--For boolean variable bean variable might be isDone, but for JSTL, we only use done ('is' not needed)--%>
            <td>
                <a class="btn btn-warning" type="button" href="/spring-webmvc/update-todo?id=${todo.id}">Update</a>
                <a class="btn btn-danger" type="button" href="/spring-webmvc/delete-todo?id=${todo.id}">Delete</a>
            </td>
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

<%@include file="common/footer.jspf" %>
