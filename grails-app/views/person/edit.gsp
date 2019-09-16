<%--
  Created by IntelliJ IDEA.
  User: kenny
  Date: 22-Jul-19
  Time: 1:12 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>
        Edit
    </title>
</head>

<body>
FirstName: <br>
<input type="text" value="${person.firstName}"><br>
<br>
LastName: <br>
<input type="text" value="${person.lastName}"><br>
<br>

<g:form controller="person" action="update" id="${person.id}">
    <g:if test="${editing == 'phone'}" >
        <g:each in="${person.phoneNumber}" var="phoneNum" status="i"><br>
            <br>
            <g:field property="phoneNumber" type="text" name="phoneNumber" value="${phoneNum.phoneNumber}"  />

        </g:each>
    </g:if>
    <g:elseif test="${editing == 'addresses'}">
        <g:each in="${person.address}" var="adrss" status="i"><br>
            <br>
            <g:field property="address" type="text" name="address" value="${adrss.address}"  />

        </g:each>
    </g:elseif>
    <g:else test="${editing =='emails'}">
        <g:each in="${person.email}" var="emails" status="i"><br>
            <br>
            <g:field property="email" type="text" name="email" value="${emails.email}"  />

        </g:each>
    </g:else>
    <br>
    <input type="hidden" name="submitting" value="${editing}"/>
    <g:actionSubmit value="Update" controller="person" action="update" id="${person.id}"/>
</g:form>



%{--<g:each in="${ (0..<results.size()) }" var="i">--}%
%{--    <input type="text" value="${results.address[i]}"><br>--}%
%{--</g:each>--}%

%{--<g:actionSubmit value="Update" controller="person" action="update" />--}%
%{--Phone Number(s):<br>--}%
%{--<g:each in="${ (0..<results.size()) }" var="i">--}%
%{--    <input type="text" value="${results.phoneNumber[i]}"><br>--}%
%{--    <br>--}%
%{--</g:each>--}%

%{--E-mail(s):<br>--}%
%{--<g:each in="${ (0..<results.size()) }" var="i">--}%
%{--    <input type="text" value="${results.email[i]}"><br>--}%
%{--    <br>--}%
%{--</g:each>--}%

</body>
</html>