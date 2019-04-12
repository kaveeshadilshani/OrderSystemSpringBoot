<%--
  Created by IntelliJ IDEA.
  User: kaveeshad
  Date: 4/1/2019
  Time: 6:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

The order was set<br>
No of Orders - ${noOfOrders}<br>
Order Quantity - ${orderQty}<br>
<form action="/startOrder">


    <button type="submit">Submit</button>

</form>
</body>
</html>
