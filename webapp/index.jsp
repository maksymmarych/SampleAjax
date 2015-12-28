

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Athentification</title>
</head>
<body>


<form>

    <h1>Please input login</h1>
    <input id="login" type="text" name="login" value="login"/>

    <h1>Please input password</h1>
    <input id="password" type="text" name="password" value="*****"/></br>
    <input type="button" value="accept" onclick="sendAjax()">

</form>

<div align="center" class="frame border shadow">JavaScript</div>
<div align="center" class="frame border shadow">

    <script language="JavaScript">

        var ajax = new XMLHttpRequest();

        ajax.onreadystatechange = function () {

            if (ajax.readyState == 4 && ajax.status == 200) {
                var str = ajax.responseText;
                document.getElementById("massage").innerHTML = str;
            }
        }

        function sendAjax() {
            var str = '/logpasajax?login=' + document.getElementById('login').value +
                    '&password=' + document.getElementById('password').value;
            ajax.open("get", str, true);
            ajax.send();
        }


    </script>

</div>

<div id="massage">status</div>

</body>
</html>
