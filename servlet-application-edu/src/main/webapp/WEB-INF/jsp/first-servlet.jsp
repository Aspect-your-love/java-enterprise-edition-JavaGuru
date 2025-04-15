<%--
  Created by IntelliJ IDEA.
  User: SPEC-IT
  Date: 15.04.2025
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>Все купленные билеты</h1>
    <ul>
        <%--
        <%
            TicketService ticketService = TicketService.getInstance();
            Long flightId = Long.valueOf(request.getParameter("flightId"));
            for(TicketDto ticketDto : ticketService.findAllByFlightId(flightId)){
               // Неявно определённая переменная out - это PrintWriter.
                out.write(String.format("<li>%s</li>", ticketDto.seatNo()));
            }
        %>
        --%>
    </ul>

</body>
</html>
