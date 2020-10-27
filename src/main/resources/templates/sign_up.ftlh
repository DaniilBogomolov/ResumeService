<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>
</head>
<body>
<form method="post" action="/signUp">
    <input name="firstName" placeholder="First name"><br>
    <input name="lastName" placeholder="Last name"><br>
    <input name="email" placeholder="Email" type="email"><br>
    <input name="password" placeholder="Password" type="password"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button type="submit">Sign Up</button>
</form>
</body>
</html>