<%--
  Created by IntelliJ IDEA.
  User: kenny
  Date: 15-Jul-19
  Time: 1:07 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<table style="width:100%">
    <caption>PhoneBook List</caption>
    <thead>
        <tr>
            <th style="text-align: center">First Name</th>
            <th style="text-align: center">Last Name</th>
            <th></th>
        </tr>
    </thead>

    <tbody>
        <g:each in="${contacts}" var="person">

            <tr>
                <td style="text-align: center">${person.firstName}</td>
                <td style="text-align: center">${person.lastName}</td>
                <td>

                    <g:link controller="person" action="show" id="${person.id}">View</g:link>
                    <g:form controller="person" action="delete" params="[person: person.id]">
                        <button type="'submit">
                            Delete
                        </button>
                    </g:form>
                </td>
            </tr>

        </g:each>
</tbody>


</table>
</body>
</html>
