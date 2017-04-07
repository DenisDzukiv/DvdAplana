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

    <script language="JavaScript 1.1" type="text/javascript">
        function getXmlHttp() {
            if (typeof XMLHttpRequest === 'undefined') {
                XMLHttpRequest = function () {
                    try {
                        return new ActiveXObject("Msxml2.XMLHTTP.6.0");
                    }
                    catch (e) {
                    }
                    try {
                        return new ActiveXObject("Msxml2.XMLHTTP.3.0");
                    }
                    catch (e) {
                    }
                    try {
                        return new ActiveXObject("Msxml2.XMLHTTP");
                    }
                    catch (e) {
                    }
                    try {
                        return new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch (e) {
                    }
                    throw new Error("This browser does not support XMLHttpRequest.");
                };
            }
            return new XMLHttpRequest();
        }

        function backDisk(diskId) {
            var
                    l_xmlhttp = getXmlHttp(),
                    l_url = "backDisk?diskId=" + diskId;
            l_xmlhttp.open("GET", l_url, true);
            l_xmlhttp.onreadystatechange = function () {
                try {
                    if (l_xmlhttp.readyState == 4) {
                        if (l_xmlhttp.status == 200) {
                            alert("Disk has been given!");
                            window.location.reload();
                        }
                    }
                } catch (e) {
                    //alert("Произошла непредвиденная ошибка при работе javascript. Пожалуйста, обновите страницу. Ошибка: " + e);
                    alert("Error: " + e);
                }
            };
            l_xmlhttp.send();
        }
    </script>


</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h4 class="text-center"><a href="${contextPath}/diskForm">New Disk</a></h4>
        <h4 class="text-center"><a href="${contextPath}/listFreeDisk">All free disk</a></h4>
        <h4 class="text-center"><a href="${contextPath}/diskTakeFromUser">Taken disk from ${pageContext.request.userPrincipal.name} </a></h4>


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
                    <button type="button" class="btn btn-primary btn-sm" onclick="backDisk(${row.getId()})">Give back disk
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