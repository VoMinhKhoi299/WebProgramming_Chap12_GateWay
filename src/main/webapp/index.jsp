<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<link rel="stylesheet" href="styles/main.css" type="text/css">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <title>The SQL Gateway</title>
</head>
<body>
<div class="container">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <form class="card" action="${pageContext.request.contextPath}/execute" method="post" accept-charset="UTF-8">
        <h1>The SQL Gateway</h1>
        <h2>Enter an SQL statement</h2>

        <div class="form-group">
            <label for="statement">SQL Statement</label>
            <textarea id="statement" name="statement" placeholder="VD: SELECT * FROM dbo.YourTable WHERE id = 1;"  required><c:out value="${statement}" /></textarea>
        </div>

        <div class="actions">
            <button type="submit" class="btn">Execute</button>
        </div>
    </form>
    <p><b>SQL result:</b></p>
    ${result}


</div>
</body>
</html>
