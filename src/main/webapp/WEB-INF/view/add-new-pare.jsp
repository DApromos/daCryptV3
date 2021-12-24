<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>

<html>

<body>

<h2>Monthly Data</h2>
<br>


<table border="1">
    <thead>
    <tr>
        <th>From Currency (code)</th>
        <th>From Currency (name)</th>
        <th>To Currency (code)</th>
        <th>To Currency (name)</th>
        <th>Last refreshed</th>
        <th>Time Zone</th>
        <th>Check date</th>
        <th>Highest price of the month</th>
        <th>Highest price of the month (USD)</th>
        <th>Lowest price of the month</th>
        <th>Lowest price of the month (USD)</th>
        <th>Volume</th>
        <th>Market capitalization (USD)</th>
    </tr>
    </thead>

    <c:forEach var="monthlyItem" items="${monthlyReport}">

        <tbody>
        <tr>
            <td>${monthlyItem.currencyCode}</td>
            <td>${monthlyItem.currencyName}</td>
            <td>${monthlyItem.marketCode}</td>
            <td>${monthlyItem.marketName}</td>
            <td>${monthlyItem.lastRefreshed}</td>
            <td>${monthlyItem.timeZone}</td>
            <td>${monthlyItem.checkDate}</td>
            <td>${monthlyItem.highestPriceInput}</td>
            <td>${monthlyItem.highestPriceUSD}</td>
            <td>${monthlyItem.lowestPriceInput}</td>
            <td>${monthlyItem.lowestPriceUSD}</td>
            <td>${monthlyItem.volume}</td>
            <td>${monthlyItem.marketCapUSD}</td>
        </tr>
        </tbody>
    </c:forEach>

</table>

</body>
</html>
