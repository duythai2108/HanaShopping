<%-- 
    Document   : login
    Created on : Nov 3, 2020, 2:50:37 PM
    Author     : duythai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="LoginTheme/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="LoginTheme/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="LoginTheme/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="LoginTheme/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="LoginTheme/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="LoginTheme/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="LoginTheme/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="LoginTheme/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="LoginTheme/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="LoginTheme/css/util.css">
        <link rel="stylesheet" type="text/css" href="LoginTheme/css/main.css">
        <!--===============================================================================================-->
     <script src='https://www.google.com/recaptcha/api.js?hl=en'></script>
      
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100" style="background-image: url('LoginTheme/images/bg-01.jpg');">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
                    <form class="login100-form validate-form" action="MainController" method="POST">

                        <span class="login100-form-title p-b-49">
                            Login
                        </span>
                        <h4 style="color: red">${sessionScope.RECAPCHA}</h4>
                          <h4 style="color: red">${sessionScope.LOGIN_FAIL}</h4>
                        <div class="wrap-input100 validate-input m-b-23" data-validate = "Username is required">
                            <span class="label-input100">Username</span>
                            <input class="input100" type="text" name="txtUserID" placeholder="Type your username">
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <span class="label-input100">Password</span>
                            <input class="input100" type="password" name="txtPassword" placeholder="Type your password">
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>
                        <br>
                       
                        <div class="g-recaptcha block clearfix" data-sitekey="6Le-NN8ZAAAAAH_1TokJevB8PEkpkgdeEAfiEh6Y" data-callback="recaptchaCallback">
                            
                        </div>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                <button class="login100-form-btn" type="submit" name="btnAction" value="Login">
                                    Login
                                </button>
                                
                                
                                
                            </div>
                        </div>
                        
                                <br/>

                        <div class="txt1 text-center p-t-54 p-b-20">
                            <span>
                                Or Sign Up Using
                            </span>
                        </div>
                                

                        <div class="flex-c-m">
<!--                            <a href="#" class="login100-social-item bg1">
                                <i class="fa fa-facebook"></i>
                            </a>

                            <a href="#" class="login100-social-item bg2">
                                <i class="fa fa-twitter"></i>
                            </a>-->

                            <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/J3.L.P0013-HanaShoping/LoginGoogleController&response_type=code
                               &client_id=680023096467-ppvelq3ckc06gkcb0di6n6qp0f8n5jrm.apps.googleusercontent.com&approval_prompt=force" class="login100-social-item bg3">
                                <i class="fa fa-google"></i>

                            </a>
                        </div>

                        <div class="flex-col-c p-t-155">
                            <span class="txt1 p-b-17">
                                Or Sign Up Using
                            </span>

                          
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="LoginTheme/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="LoginTheme/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="LoginTheme/vendor/bootstrap/js/popper.js"></script>
        <script src="LoginTheme/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="LoginTheme/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="LoginTheme/vendor/daterangepicker/moment.min.js"></script>
        <script src="LoginTheme/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="LoginTheme/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="LoginTheme/js/main.js"></script>

    </body>
</html>
