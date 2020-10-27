<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login | Medical Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Expires" content="0" />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans&display=swap" rel="stylesheet">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>

<div id="log-title" class="row center" style="margin-top: 30vh">
    <h3>Register | <span style="color: #c62828">Medical Dashboard</span></h3>
</div>

<form:form modelAttribute="newUser" method="post" action="/processRegister">
    <div class="row" id="input-wrapper">
        <div class="row">
            <div class="input-field col offset-s1 s10 offset-m5 m2">
                <form:input placeholder="Username" path="username" required="required"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col offset-s1 s10 offset-m5 m2">
                <form:input placeholder="Password" type="password" path="password" required="required"/>
            </div>
        </div>

        <div class="row">
            <div class="input-field col offset-s1 s10 offset-m5 m2">
                <form:input placeholder="Role" type="text" path="role" required="required"/>
            </div>
        </div>

        <div class="row center">
            <input id="login-btn" class="btn btn-medium blue darken-3" type="submit" value="Register">
        </div>
    </div>
</form:form>

<div class="row center">
    <a href="/login">< Back to Login</a>
</div>

</body>
</html>