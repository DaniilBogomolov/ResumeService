<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>
</head>
<body>
<a href="/resume/create">Create new resume</a>
<hr>
<h2>My resume list</h2>
<#list profileInfo.resumeDtoList>
    <ul>
        <#items as resume>
            <li><a href="/resume/get/${resume.id}">${resume.name}</a></li>
        </#items>
    </ul>
</#list>
</body>
</html>