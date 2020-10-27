<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>
</head>
<body>
<h2>Please, sign in</h2>
<form action="/signIn" method="post">
    <input name="email" type="email" placeholder="Email"><br>
    <input name="password" type="password" placeholder="Password"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button type="submit">Sign In</button>
</form>
</body>
</html>