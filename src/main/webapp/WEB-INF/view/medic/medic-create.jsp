<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />

    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <title>Medical Dashboard | Adauga Medic</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="/css/style.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>

<body>

<!-- NAVBAR -->
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-3">
            <a href="/" class="brand-logo left" id="desktop-logo"><span id="top-logo">Medical Dashboard</span></a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li class="active"><a href="/">Medic</a></li>
                <li><a href="/pacient">Pacient</a></li>
                <li><a href="/medicament">Medicament</a></li>
            </ul>
        </div>
    </nav>
</div>

<div class="row center">
    <h3 class="promo caption">Adauga Medic</h3>
    <a href="/">Go back</a>
</div>

<div class="row center" style="margin-top: 50px">
    <div class="col s8 offset-s2 m10 offset-m1">

        <form:form action="ProcessMedicAdd" modelAttribute="addMedic" method="post" style="margin-top: 15px;">

            <div class="row">
                <div class="input-field col m6 offset-m3 s10 offset-s1">
                    <form:input path="numeMedic" id="nume" />
                    <label for="nume">Nume</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col m6 offset-m3 s10 offset-s1">
                    <form:input path="prenumeMedic" id="prenume" />
                    <label for="prenume">Prenume</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col m6 offset-m3 s10 offset-s1">
                    <form:input path="specializare" id="specializare" />
                    <label for="specializare">Specializare</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col m6 offset-m3 s10 offset-s1">
                    <input class="btn btn-large blue darken-3" type="submit" value="Add" />
                </div>
            </div>
        </form:form>

    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>