<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Not found</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <br><br><br>
    <div class="row justify-content-center align-self-center">
        <div class="col-md-4">
            <c:if test="${message != null}">
                <div class="alert alert-danger" role="alert">
                    ${message}
                </div>
            </c:if>
            <a href="/"><button class="btn btn-primary">Home page</button></a>
        </div>
    </div>
</div>

</body>
</html>
