<%@ page import="com.kitri.springbasicboot.project.rsp_game.Count" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% HttpSession session1 = request.getSession();
    Count count = (Count) session1.getAttribute("count");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/rsp_game/style.css" />
    <title>Rock & Scissors & Paper</title>
</head>
<body>
<div id="form">
    <img src="/rsp_game/rock.png">
    <img src="/rsp_game/scissors.png">
    <img src="/rsp_game/paper.png">
</div>
<hr/>
<hr/>
<ul>
    <li>Win count : <%=count.getCount1()%></li>
    <li>Lose count : <%=count.getCount2()%></li>
    <li>Draw count : <%=count.getCount3()%></li>
</ul>
<hr/>
<hr/>
<div id="result">
    <div id="you">
        <img src="/rsp_game/scissors.png">
        You
    </div>
    <div id="computer">
        <img src="/rsp_game/rock.png">
        Computer
    </div>
</div>

<script src="/rsp_game/script.js"></script>
</body>
</html>