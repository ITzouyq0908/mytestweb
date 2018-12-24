<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<body>
<h2>Hello World!</h2>
 userName:${user.userName}
<script>
    function selectUser() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("test").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("POST", "user/showUser", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("userId=1");
    }
</script>
<body>
<p id="test">Hello World!</p>
<button type="button" onclick="selectUser()">onclick test</button>
</body>
</html>
