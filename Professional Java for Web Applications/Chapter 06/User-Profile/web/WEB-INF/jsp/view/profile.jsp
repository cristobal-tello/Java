<%--@elvariable id="user" type="com.wrox.User"--%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Profile</title>
    </head>
    <body>
        User ID: ${user.userId}<br />
        Username: ${user.username} (${user.username.length()} characters)<br />
        Full Name: ${fn:escapeXml(user.lastName) += ', '
            += fn:escapeXml(user.firstName)}
        <br /><br />
        <b>Permissions (${fn:length(user.permissions)})</b><br />
        User: ${user.permissions["user"]}<br />
        Moderator: ${user.permissions["moderator"]}<br />
        Administrator: ${user.permissions["admin"]}<br />
        <hr/>
        <table>
         <c:forEach items="${user.permissions}" var="permision">
            <tr>      
            <td>${permision.key}</td>
            <td>${permision.value}</td>
            </tr>
        </c:forEach>
            <hr/>
            
        </table>

    </body>
</html>
