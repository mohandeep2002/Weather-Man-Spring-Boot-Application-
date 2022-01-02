<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt_rt" %>
<jsp:include page="nav.jsp"></jsp:include>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

      <!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>-->
      <h2>${sessionScope.user.city }'s Forecast</h2>
      <div class="table-responsive">
        <table class="table table-sm">
          <thead class="thead-dark">
            <tr>
              <th scope="col">#</th>
              <th scope="col">Time Stamp</th>
              <th scope="col">Temp In Celcius</th>
              <th scope="col">Temp In Fahrenheit</th>
              <!--  -->
              <th scope="col">Weather</th>
              <th scope="col">Icon</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${finfo.entries }" var="e">
          <tr>
          <td></td>
          	
              <td class="font-weight-bold align-middle"><f:parseDate value="${ e.date }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
				<f:formatDate pattern="dd-MMM-yyyy hh:mm a" value="${ parsedDateTime }" /></td>				
				<td>${e.celsiusTemperature }</td>
				<td>${e.fahrenheitTemperature }</td>
				<td>${e.description } </td>
				<td><img src="http://openweathermap.org/img/wn/${e.weatherIcon }@2x.png"> </td>
            </tr>
          </c:forEach>
            
            
          </tbody>
        </table>
      </div>
    </main>
