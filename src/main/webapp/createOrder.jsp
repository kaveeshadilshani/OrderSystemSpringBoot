<%--
  Created by IntelliJ IDEA.
  User: kaveeshad
  Date: 4/1/2019
  Time: 6:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="createOrder">

    <div>
        <label><input type="checkbox" name="createOrders">Create Orders</label>
    </div>

    <div>
        <label><input type="checkbox" name="amendOrders">Amend Orders</label>
    </div>
    <div>
        <label><input type="checkbox" name="cancelOrders">Cancel Orders</label>
    </div>
    <div>
        <label><input type="checkbox" name="resendOrders">Resend Orders</label>
    </div>
    <div>
        <label><input type="checkbox" name="createForDefined">Create Orders for defined exchanges</label>
    </div>


    <button type="submit">Submit</button>

</form>

</body>
</html>
