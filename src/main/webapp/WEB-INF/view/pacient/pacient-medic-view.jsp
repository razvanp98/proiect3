<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />

    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <title>Medical Dashboard</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans&display=swap" rel="stylesheet">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>

<!-- NAVBAR -->
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-3">
            <a href="/" class="brand-logo left" id="desktop-logo"><span id="top-logo">Medical Dashboard</span></a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="/">Medic</a></li>
                <li class="active"><a href="/pacient">Pacient</a></li>
                <li><a href="/medicament">Medicament</a></li>
            </ul>
        </div>
    </nav>
</div>

<div class="row center">
    <h4 class="promo caption">Vezi Medici</h4>
    <a href="/pacient">Go back</a>
</div>

<div class="row center">
    <div class="row center">
        <a id="add-btn" href="/pacient/PacientLinkMedic?pacientId=${targetPacient.id}" class="btn-large btn-floating waves-effect waves-light btn blue darken-3" style="margin-top: 2vh;"><i class="material-icons">add</i></a>
    </div>
</div>

<div class="row center" style="margin-top: 50px">
    <div class="col s8 offset-s2 m10 offset-m1">
        <table class="centered striped highlight responsive-table">
            <thead class="red darken-3">
            <tr style="color: #e0e0e0">
                <th>MedicID</th>
                <th>Nume</th>
                <th>Prenume</th>
                <th>Specializare</th>
                <th>Add</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var = "temp" items = "${mediciFromPacient}">
                <tr>
                    <td>${temp.id}</td>
                    <td>${temp.numeMedic}</td>
                    <td>${temp.prenumeMedic}</td>
                    <td>${temp.specializare}</td>
                    <td><a href="/pacient/UnlinkMedic?medicId=${temp.id}&pacientId=${targetPacient.id}"><button class="btn btn-small red darken-3">Remove</button></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</div>


</body>
</html>