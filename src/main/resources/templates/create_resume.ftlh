<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>New resume</title>
</head>
<body>
<form action="/resume/create" method="post">
    <input name="name" placeholder="Resume Name"><br>
    <input name="about" placeholder="About"><br>
    <input name="workExperience" placeholder="Work experience"><br>
    <input name="education" placeholder="Education"><br>
    <input name="skills" placeholder="Skills"><br>
    <input name="references" placeholder="References"><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <button type="submit">Create resume</button>
</form>
</body>
</html>