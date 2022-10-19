<html>
<head>
    <title>Search Users
    </title>
</head>
<script>
    function searchUsers(email) {
        let request = new XMLHttpRequest();

        request.open('GET', '/search/users?email=' + email, false);

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
