<%@ page import="com.razvan.papurica.proiect3.security.SecurityAuthorizer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />

    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="Expires" content="0" />

    <title>Medical Dashboard | Medici</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans&display=swap" rel="stylesheet">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body>

<%
    if(!SecurityAuthorizer.isUserAuthenticated()) {
        response.sendRedirect("/login");
    }
%>

<!-- NAVBAR -->
<div class="navbar-fixed">
    <nav>
        <div class="nav-wrapper blue darken-3">
            <a href="/medic" class="brand-logo left" id="desktop-logo"><span id="top-logo">Medical Dashboard</span></a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li class="active"><a href="/medic">Medic</a></li>
                <li><a href="/pacient">Pacient</a></li>
                <li><a href="/medicament">Medicament</a></li>
                <li><a href="/logout"><i class="material-icons">power_settings_new</i></a></li>
            </ul>
        </div>
    </nav>
</div>

<% if(SecurityAuthorizer.getUser() != null) {
%>
<div class="row center">
    <p class="promo caption">User: <span style="font-weight: bold"><%out.println(SecurityAuthorizer.getUser().getUsername());%></span>
        | Role: <span style="font-weight: bold"><%out.println(SecurityAuthorizer.getUser().getRole());%></span></p>
</div>

<% } %>

<div class="row center">
    <h3 class="promo caption">Vezi Medici</h3>
</div>

<div class="row center">
    <div class="row center">
        <a id="add-btn" href="/ShowMedicAdd" class="btn-large btn-floating waves-effect waves-light btn blue darken-3" style="margin-top: 2vh;"><i class="material-icons">add</i></a>
    </div>
</div>

<div class="row center" style="margin-top: 30px">
    <div class="col s8 offset-s2 m10 offset-m1">
        <table class="centered striped highlight responsive-table">
            <thead class="red darken-3">
            <tr style="color: #e0e0e0">
                <th>MedicID</th>
                <th>Nume</th>
                <th>Prenume</th>
                <th>Specializare</th>
                <th>Pacienti</th>
                <th>Update</th>

                <%
                    if(SecurityAuthorizer.getUser() != null) {
                        if(SecurityAuthorizer.getUser().getRole().equals("ADMIN")) {
                %>

                <th>Delete</th>

                <% }} %>
            </tr>
            </thead>

            <tbody>
                <c:forEach var = "temp" items = "${medici}">
                    <tr>
                        <td>${temp.id}</td>
                        <td>${temp.numeMedic}</td>
                        <td>${temp.prenumeMedic}</td>
                        <td>${temp.specializare}</td>
                        <td><a href="/ViewPacientiFromMedic?medicId=${temp.id}">View Pacienti</a></td>
                        <td><a href="/ShowMedicUpdate?medicId=${temp.id}"><button class="btn btn-small blue darken-3">Update</button></a></td>

                        <%
                            if(SecurityAuthorizer.getUser() != null) {
                                if(SecurityAuthorizer.getUser().getRole().equals("ADMIN")) {

                        %>

                        <td><a href="/DeleteMedic?medicId=${temp.id}"><button class="btn btn-small red darken-3">Delete</button></a></td>

                        <% } }%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>