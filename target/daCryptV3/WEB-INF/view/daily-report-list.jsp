<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Database of stored exchange rates</h2>

<br>
<br>
<form action="welcome-page.jsp">
    <input type="submit">
</form>
<br>
<br>

<table border="1">
    <thead>
    <tr>
        <th>From Currency</th>
        <th>To Currency</th>
        <th>Exchange Rate</th>
        <th>Last Refreshed</th>
        <th>Bid Price</th>
        <th>Ask Price</th>
    </tr>
    </thead>

    <c:forEach var="currencyPare" items="${realTimeExRates}">

        <tbody>
        <tr>
            <td>${currencyPare.fromCurrencyFullName}</td>
            <td>${currencyPare.toCurrencyFullName}</td>
            <td>${currencyPare.exchangeRate}</td>
            <td>${currencyPare.lastRefreshed}</td>
            <td>${currencyPare.bidPrice}</td>
            <td>${currencyPare.askPrice}</td>
        </tr>
        </tbody>

    </c:forEach>

</table>


</body>
</html>