<%--
  Created by IntelliJ IDEA.
  User: kaveeshad
  Date: 3/28/2019
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home page</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
<body>
<form action = "arguments">
<table>
    <tr>
    <div>
      <td>  <label>IP:</label></td>
       <td><input type="text" name="ip"></td>
    </div>
    </tr>
<br><tr>
    <div>
        <td><label>Port:</label></td>
       <td> <input type="number" name="port"></td>
    </div>
</tr>
<br>
    <tr>
    <div>
       <td> <label>Number of End points:</label></td>
        <td><input type="number" name="noOfEndPoints"></td>
    </div>
    </tr>
<br>
    <tr>
    <div>
      <td>  <label><input type="checkbox" name="GWClient">GW Client</label></td>

    </div>
    </tr>
</table>
<br>
    <button type="submit">Submit</button>



</form>
</body>
</html>