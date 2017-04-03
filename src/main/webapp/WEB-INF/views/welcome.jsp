<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h4 class="text-center"><a href="${contextPath}/diskForm">New Disk</a></h4>


                    <h3><a onclick="">All free disk</a></h3>
                <h3><a onclick="">List of taken disks by the user</a></h3>
                    <h3><a onclick="">List of taken disks from the user</a></h3>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a> </h2>

        <table class="table table-bordered" >
            <thead class="thead-inverse">
                <tr>
                  <th>#</th>
                  <th>List of disks from ${pageContext.request.userPrincipal.name} </th>
                  <th></th>
                </tr>
            </thead>
            <tdody>
            <c:forEach var="row" items="${dvdListUserLocation}" varStatus="loop">

            <tr>
                <td>${loop.index+1}</td>
                <td>${row.getDvdName()}</td>
                <td>
                    <button type="button" class="btn btn-primary btn-sm" onclick="back_disk(${row.getId()})">Give back disk
                    </button>
                </td>
            </tr>
            </c:forEach>
             </tdody>
        </table>


    </c:if>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>