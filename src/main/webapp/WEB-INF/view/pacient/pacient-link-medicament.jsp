<%@ page import="com.razvan.papurica.proiect3.security.SecurityAuthorizer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <li><a href="/medic">Medic</a></li>
                <li class="active"><a href="/pacient">Pacient</a></li>
                <li><a href="/medicament">Medicament</a></li>
                <li><a href="/logout"><i class="material-icons">power_settings_new</i></a></li>
            </ul>
        </div>
    </nav>
</div>

<% if(SecurityAuthorizer.getUser() != null) {
%>
<div class="row center">
    <p class="promo caption">Logged in as: <span style="font-weight: bold; color: #c62828"><%out.println(SecurityAuthorizer.getUser().getUsername());%>[ ROLE: <%out.println(SecurityAuthorizer.getUser().getRole());%>]</span></p>
</div>

<% } %>

<div class="row center">
    <h3 class="promo caption">Asociaza Medicament</h3>
    <a href="/pacient">Go back</a>
</div>

<div class="row center" style="margin-top: 30px">
    <div class="col s8 offset-s2 m10 offset-m1">
        <table class="centered striped highlight responsive-table">
            <thead class="red darken-3">
            <tr style="color: #e0e0e0">
                <th>MedicamentId</th>
                <th>Denumire</th>
                <th>Diagnostic</th>
                <th>Doza</th>
                <th>Data</th>
                <th>Link</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var = "temp" items = "${medicamente}">
                <tr>
                    <td>${temp.id}</td>
                    <td>${temp.denumire}</td>
                    <td>${temp.diagnostic}</td>
                    <td>${temp.doza}</td>
                    <td>${temp.date}</td>
                    <td>
                        <a href="/pacient/ProcessMedicamentLinkPacient?pacientId=${targetPacient.id}&medicamentId=${temp.id}">
                            <button class="btn btn-small blue darken-3">Add</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="row center" style="margin-top: 60px">
    <h3 class="promo caption">Medicamente selectate</h3>
</div>

<div class="row center" style="margin-top: 30px">
    <div class="col s8 offset-s2 m10 offset-m1">
        <table class="centered striped highlight responsive-table">
            <thead class="red darken-3">
            <tr style="color: #e0e0e0">
                <th>MedicamentId</th>
                <th>Denumire</th>
                <th>Diagnostic</th>
                <th>Doza</th>
                <th>Data</th>
                <%
                    if(SecurityAuthorizer.getUser() != null) {
                        if(SecurityAuthorizer.getUser().getRole().equals("ADMIN")) {
                %>

                <th>Remove</th>

                <% }} %>
            </tr>
            </thead>

            <tbody>
            <c:forEach var = "temp" items = "${targetPacient.getMedicamente()}">
                <tr>
                    <td>${temp.id}</td>
                    <td>${temp.denumire}</td>
                    <td>${temp.diagnostic}</td>
                    <td>${temp.doza}</td>
                    <td>${temp.date}</td>
                    <%
                        if(SecurityAuthorizer.getUser() != null) {
                            if(SecurityAuthorizer.getUser().getRole().equals("ADMIN")) {

                    %>

                    <td>
                        <a href="/pacient/UnlinkMedicament?pacientId=${targetPacient.id}&medicamentId=${temp.id}">
                            <button class="btn btn-small red darken-3">Delete</button>
                        </a>
                    </td>

                    <% } }%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


</body>
</html>