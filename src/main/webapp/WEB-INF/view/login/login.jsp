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
    <h3>Log in | <span style="color: #c62828">Medical Dashboard</span></h3>
</div>

<form method="post" action="/processLogin">
    <div class="row" id="input-wrapper">
        <div class="row">
            <div class="input-field col offset-s1 s10 offset-m5 m2">
                <input placeholder="Username" id="username" name="username" type="text" required>
            </div>
        </div>

        <div class="row">
            <div class="input-field col offset-s1 s10 offset-m5 m2">
                <input placeholder="Password" id="pwd" name="password" type="password" required>
            </div>
        </div>

        <div class="row center">
            <input id="login-btn" class="btn btn-medium blue darken-3" type="submit" value="Log in">
        </div>
    </div>
</form>

<div class="row center">
    <a href="/showRegister">Don't have account? Register here.</a>
</div>

</body>
</html>