<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${user.firstName}</title>
</head>
<body>
<h3>Имя - ${user.firstName}</h3>
<h3>Фамилия - ${user.lastName}</h3>
<br>
<form method="post" action="/users/${user.id}/update">
    <label>
        Имя: <input name="firstName" value="${user.firstName}">
    </label>
    <label>
        Фамилия: <input name="lastName" value="${user.lastName}">
    </label>
    <input type="submit" value="Сохранить..">
</form>
</body>
</html>