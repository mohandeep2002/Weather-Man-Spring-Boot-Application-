<jsp:include page="nav.jsp"></jsp:include>

<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Welcome ${sessionScope.user.username }</h1>
      </div>

      <!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>-->
      <div class="my-4 w-100">
      	<center>
      		<div class="card" style="width: 18rem;">
  <div class="card-header">
    Current Info
  </div>
  <ul class="list-group list-group-flush">
  	<li class="list-group-item">City: ${sessionScope.user.city }</li>
    <li class="list-group-item">Information: ${info.description }</li>
    <li class="list-group-item">Temperature : ${info.celsiusTemperature } Celsius</li>
    <li class="list-group-item">Temperature : ${info.fahrenheitTemperature } Farenheit</li>
    <li class="list-group-item"><img src="http://openweathermap.org/img/wn/${info.icon }@2x.png">
    ${info.description }</li>
  </ul>
</div>
      	</center>
      </div>