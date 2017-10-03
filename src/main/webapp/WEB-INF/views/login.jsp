<%@include file="common/header.jspf"%>
<h1><div><font color="red">${error}</font></div></h1>
<form action="login.jsp" method="post">
	<fieldset class="form-group">
		<label path="name">Name: </label>
		<input path="name" type="text" name="name" class="form-control"/>
	</fieldset>
	<fieldset class="form-group">
		<label path="password">Password: </label>
		<input path="password" type="password" name="password" class="form-control"/>
	</fieldset>
	<input type="submit" value="Login" class="btn btn-success"/>
</form>
<%@include file="common/footer.jspf"%>