<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>WeatherMan</title>
     <!-- Required meta tags -->
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
 
     <!-- Bootstrap CSS -->
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/carousel/">

    

    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      body {
        
        background: url('images/home-cover-page.jpg') no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        /*color:#fff;
        background-color:#333;
        font-family: 'Open Sans', Arial, Helvetica, Sans-Serif;*/
        font-family: 'Roboto Mono', monospace;
    }
    .white_text{
        color: white;
    }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
  </head>
  <body>
      <center>
        <h1 class="display-4 white_text">Weather Man.</h1>
        <h1 class="display-5 white_text">Sign Up</h1>
      </center>
    
    <div class="container white_text">
        <form:form method="post" action="/submitregister" modelAttribute="user">
          <div class="form-group">
            <label for="exampleInputEmail1">Username</label>
            <!--<input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter Name">-->
            <form:input path="username" class="form-control" aria-describedby="emailHelp" placeholder="Enter Username" name="username"></form:input>
            <small>&nbsp;</small>
          </div>
            <div class="form-group">
              <label for="exampleInputEmail1">Email address</label>
              <form:input path="emailid" class="form-control" aria-describedby="emailHelp" placeholder="Enter Email ID" name="email"></form:input>
              <!--<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">-->
              <small>&nbsp;</small>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Country</label>
                <form:input path="country" class="form-control" aria-describedby="emailHelp" placeholder="Enter Country" name="country"></form:input>
                <!--<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">-->
                <small>&nbsp;</small>
              </div>
              <div class="form-group">
                <label for="exampleInputEmail1">City</label>
                <form:input path="city" class="form-control" aria-describedby="emailHelp" placeholder="Enter City" name="city"></form:input>
                <!--<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">-->
                <small>&nbsp;</small>
              </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Password</label>
              <!--<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">-->
              <form:input path="password" type="password" class="form-control" aria-describedby="emailHelp" placeholder="Enter Password" name="password"></form:input>
              <small>&nbsp;</small>
            </div>
            <div class="form_group">
              
            </div>
            <div class="form-group form-check">
              
            </div>
            <center><button type="submit" class="btn btn-primary">Submit</button></center>
            
        </form:form>
    </div>
    <center><a class="white_text" href="/signin"><p class="">Have An Account! Dive In</p></a></center>
	
    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Optional JavaScript; choose one of the two! -->
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

      
  </body>
</html>
