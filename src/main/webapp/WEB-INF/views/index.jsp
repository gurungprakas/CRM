<%-- 
    Document   : index
    Created on : Jul 8, 2017, 10:38:55 PM
    Author     : Prakas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h1> Add Complain</h1>
            <form method="post">
                <div class="form-group">
                    <label>Customer</label>
                    <select name="cusotmer_id" class="form-control">
                        <option value="">Select Customer</option>
                        <c:forEach var="c"  items="${requestScope.customers}">
                            <option value="${c.id}">${c.firstName} ${c.lastName}</option>
                        </c:forEach>    
                    </select>
                </div>
                    <div class="form-group">
                        <label>Subject</label>
                        <input type="text" name="subject" required="required" class="form-control"> 
                    </div>
                    <div class="form-group">
                        <label>Description</label>
                        <textarea type="text" name="description" required="required" class="form-control" style="height:200px">
                        </textarea>
                     
                    </div>
                 <div class="form-group">
                    <label>Department</label>
                    <select name="department_id" class="form-control">
                        <option value="">Select Department</option>
                        <c:forEach var="d"  items="${requestScope.departments}">
                            <option value="${d.id}">${d.name}</option>
                        </c:forEach>    
                    </select>
                </div>

                <button type="Submit" class="btn btn-success">Register Complain</button>
                </div>
            </form>
        </div>
    </body>
</html>
