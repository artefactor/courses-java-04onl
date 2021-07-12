<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add new product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container-fluid">
    <c:if test="${message != null}">
        <div class="row row justify-content-center align-self-center">
            <div class="col-md-6">
                <div class="alert alert-danger" role="alert">
                        ${message}
                </div>
            </div>
        </div>
    </c:if>
    <div class="row row justify-content-center align-self-center">
        <div class="col-md-6">
            <form:form method="POST" action="${pageContext.request.contextPath}/products/add" modelAttribute="product">
                <table class="table">
                    <tr>
                        <td><form:label path="title">Title</form:label></td>
                        <td><form:input path="title"/></td>
                        <td><form:errors path="title" cssStyle="color: #ff0000;"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="description">Description</form:label></td>
                        <td><form:input path="description"/></td>
                        <td><form:errors path="description" cssStyle="color: #ff0000;"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="price">Price</form:label></td>
                        <td><form:input path="price"/></td>
                        <td><form:errors path="price" cssStyle="color: #ff0000;"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" class="btn btn-success" value="Save"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>

    <div class="row row justify-content-center align-self-center">
        <a href="..">Back to products</a>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
