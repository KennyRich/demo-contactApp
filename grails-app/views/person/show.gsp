<%--
  Created by IntelliJ IDEA.
  User: kenny
  Date: 22-Jul-19
  Time: 11:09 AM
--%>

<%@ page import="demo.Address" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Contact details</title>
</head>

<body>
FirstName:
    <p>${person.firstName}</p>
LastName:
    <p>${person.lastName}</p>
    <g:link controller="person" action="edit" id="${person.id}" params="[person:person.id]">Edit</g:link>
<br>
<br>
Phone Number(s):
    <ul>
        <g:each in="${person.phoneNumber}" var="phone">
            <li>
                ${phone.phoneNumber}
                <g:form controller="phoneNumber" action="delete" params="[person: person.id, phoneNumber: phone.phoneNumber]">
                    <button type="'submit">
                        Delete
                    </button>
                </g:form>
            </li>
        </g:each>
        <g:link controller="person" action="edit" id="${person.id}" params="[editing: 'phone', phoneNumber: person.phoneNumber.id, person:person.id]">Edit</g:link>
    </ul>
<br>
Email(s):
    <ul>
        <g:each in="${person.email}" var="emails">
            <li>
                ${emails.email}
                <g:form controller="email" action="delete" params="[person: person.id, email: emails.email]">
                    <button type="'submit">
                        Delete
                    </button>
                </g:form>
            </li>
        </g:each>
        <g:link controller="person" action="edit" id="${person.id}" params="[editing: 'emails', email: person.email.id, person:person.id]">Edit</g:link>
</ul>
<br>
Address(es):
    <ul>
        <g:each in ="${person.address}" var="addresses">
            <li>
                ${addresses.address}
                <g:form controller="address" action="delete" params="[person: person.id, address: addresses.address]">
                    <button type="'submit">
                        Delete
                    </button>
                </g:form>
            </li>
        </g:each>
        <g:link controller="person" action="edit" id="${person.id}" params="[editing: 'addresses', address: person.address.id, person:person.id]">Edit</g:link>
    </ul>
</body>
</html>