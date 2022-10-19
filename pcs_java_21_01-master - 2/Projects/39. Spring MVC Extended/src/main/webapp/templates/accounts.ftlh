<html>
<head>
    <title>Accounts</title>
</head>
<script>
    function addAccount(firstName, lastName) {
        let body = {
            "firstName": firstName,
            "lastName": lastName
        }

        let request = new XMLHttpRequest();

        request.open('POST', '/users/json', false);
        request.setRequestHeader('Content-Type', 'application/json');
        request.send(JSON.stringify(body));

        if (request.status !== 200) {
            alert("Ошибка!")
        } else {
            let html =
                '<tr>' +
                '<th>ID</th>' +
                '<th>First Name</th>' +
                '<th>Last Name</th>' +
                '</tr>';

            let json = JSON.parse(request.response);

            for (let i = 0; i < json.length; i++) {
                html += '<tr>'
                html += '<td>' + json[i]['id'] + '</td>'
                html += '<td>' + json[i]['firstName'] + '</td>'
                html += '<td>' + json[i]['lastName'] + '</td>'
                html += '</tr>'
            }

            document.getElementById('accounts_table').innerHTML = html;
        }

    }
</script>
<body>
<table id="accounts_table">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <#list accounts as account>
        <tr>
            <td>${account.id}</td>
            <td>${account.firstName}</td>
            <td>${account.lastName}</td>
        </tr>
    </#list>
</table>
<div>
    <input id="firstName" placeholder="Enter First Name">
    <input id="lastName" placeholder="Enter Last Name">
    <button onclick="addAccount(
        document.getElementById('firstName').value,
        document.getElementById('lastName').value)">
        Add
    </button>
</div>
</body>
</html>
