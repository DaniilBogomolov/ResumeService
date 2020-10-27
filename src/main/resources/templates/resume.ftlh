<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Resume Name</title>
</head>
<body>
<#if ownerId?has_content>
    <a href="#" onclick="toogleForm('update-form');">Modify</a>
    <a href="#" onclick="toogleForm('delete-form');">Delete</a>
    <form hidden class="form" id="update-form" method="post" action="/resume/update/${resumeInfo.id}">
        <label>Name
            <input name="name" value="${resumeInfo.name}">
        </label><br>
        <label>About
            <input name="about" value="${resumeInfo.about}">
        </label><br>
        <label>Work experience
            <input name="workExperience" value="${resumeInfo.workExperience}">
        </label><br>
        <label>Education
            <input name="education" value="${resumeInfo.education}">
        </label><br>
        <label>Skills
            <input name="skills" value="${resumeInfo.skills}">
        </label><br>
        <label>References
            <input name="references" value="${resumeInfo.references}">
        </label><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit">Update resume</button>
    </form>
    <form hidden class="form" id="delete-form" method="post" action="/resume/delete/${resumeInfo.id}">
        <h2>You want to delete this resume.
            <br> Are you sure?</h2>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit">Yes</button>
    </form>
    <hr>
</#if>
<h1>${resumeInfo.name}</h1>
<h3>${resumeInfo.firstName} ${resumeInfo.lastName}</h3>
<table>
    <tbody>
        <tr>
            <td>About</td>
            <td>${resumeInfo.about}</td>
        </tr>
        <tr>
            <td>Work experience</td>
            <td>${resumeInfo.workExperience}</td>
        </tr>
        <tr>
            <td>Education</td>
            <td>${resumeInfo.education}</td>
        </tr>
        <tr>
            <td>Skills</td>
            <td>${resumeInfo.skills}</td>
        </tr>
        <tr>
            <td>References</td>
            <td>${resumeInfo.references}</td>
        </tr>
    </tbody>
</table>
<script type="text/javascript" src="/js/jQuery.js"></script>
<script type="text/javascript" src="/js/resumeLogic.js"></script>
</body>
</html>