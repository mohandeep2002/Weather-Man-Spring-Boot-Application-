<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:include page="nav.jsp"></jsp:include>
<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
 <center>
 <div class="container mt-4">
	<div class="row">
		<div class="col-sm-6 mx-auto">
			<div class="card shadow">
				<form class="card-body">
					<div class="form-group form-row">
					<label class="col-sm-4 col-form-label">Country Name </label>
					<div class="col-sm-8">
					<input type="text" value="${param.country }" class="form-control"
					name="country" required placeholder="Country Name">
					</div>
					</div>
					
					<div class="form-group form-row">
					<label class="col-sm-4 col-form-label">City Name </label>
					<div class="col-sm-8">
					<input type="text" value="${param.city }" class="form-control"
					name="city" required placeholder="City Name">
					</div>
					</div>
					<br>
					<button class="btn btn-primary float-right">Show Me</button>
				</form>
			</div>
			
			<c:if test="${found }">
			<div class="card shadow mt-4">
				<div class="card-body text-center">
				<img src="http://openweathermap.org/img/wn/${info.icon }@2x.png">
				${info.description }<br>
				Temprature in Fahrenheit : ${info.fahrenheitTemperature } &#8457;<br>
				Temprature in Celsius: ${info.celsiusTemperature } &#8451;<br>
				</div>
			</div>
			</c:if>
		</div>
	</div>
	
	
	</div>
 </center>
 
		
</main>