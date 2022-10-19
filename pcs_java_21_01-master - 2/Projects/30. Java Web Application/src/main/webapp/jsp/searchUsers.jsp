<%--
  Created by IntelliJ IDEA.
  User: Marsel
  Date: 20.10.2021
  Time: 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Users
    </title>
</head>
<script>
    function searchUsers(email) {
        let request = new XMLHttpRequest();

        request.open('GET', '/accounts/json?email=' + email, false);

        request.send();

        if (request.status !== 200) {
            alert("Ошибка!")
        } else {
            let html =
                '<tr>' +
                    '<th>Name</th>' +
                    '<th>Email</th>' +
                '</tr>';

            let json = JSON.parse(request.response);

            for (let i = 0; i < json.length; i++) {
                html += '<tr>'
                html +=     '<td>' + json[i]['firstName'] + '</td>'
                html +=     '<td>' + json[i]['email'] + '</td>'
                html += '</tr>'
            }

            document.getElementById('accounts_table').innerHTML = html;
        }
    }
</script>
<body>
<label for="email">Search by email:</label>
<input id="email" type="text" placeholder="Enter email..."
       onkeyup="searchUsers(document.getElementById('email').value)">
<table id="accounts_table">

</table>
</body>
</html>
