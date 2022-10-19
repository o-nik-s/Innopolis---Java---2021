<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        File Upload
    </title>
</head>
<body>
<form action="/filesUpload" method="post" enctype="multipart/form-data">
    <label for="description">Description</label>
    <input type="text" id="description" name="description" placeholder="Enter description...">
    <br>
    <input type="file" name="file">
    <input type="submit" value="File Upload">
</form>
</body>
</html>
