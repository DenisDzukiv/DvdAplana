<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Denis">

    <title>Create disk</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">




</head>

<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h4 class="text-center"><a href="${contextPath}/welcome">Disk from the user</a></h4>
    <h4 class="text-center"><a href="${contextPath}/listFreeDisk">All free disk</a></h4>
    <h4 class="text-center"><a href="${contextPath}/diskTakeFromUser">Taken disk from ${pageContext.request.userPrincipal.name} </a></h4>

    <form:form method="POST" modelAttribute="diskForm" class="form-signin">

        <h2 class="form-signin-heading">Create disk</h2>
        <spring:bind path="dvdName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="dvdName" class="form-control" placeholder="DvdName"
                            autofocus="true"></form:input>
                <form:errors path="dvdName"></form:errors>
            </div>
        </spring:bind>
        <%--<div class="form-group  ${status.error ? 'has-error' : ''}">
        <form:select path="user1" class="form-control">
            &lt;%&ndash;<form:option value="" label="--- Select ---" />&ndash;%&gt;
            <form:option value=""/>
            <form:options items="${userList}" />
        </form:select>
        </div>--%>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
    </c:if>
</div>
<!-- /container -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>