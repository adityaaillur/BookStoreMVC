<%-- 
    Document   : loginform
    Created on : 26 Jun 2023, 20:52:43
    Author     : adityaillur
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <style>
            body {
                background-color: #000000;
                font-family: Arial, sans-serif;
                color: #FFFFFF;
                text-align: center;
            }

            .container {
                max-width: 400px;
                margin: 0 auto;
                padding: 40px;
            }

            .title {
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 20px;
            }

            .form-group {
                margin-bottom: 20px;
                text-align: left;
            }

            .form-group label {
                display: block;
                margin-bottom: 8px;
            }

            .form-group input {
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border-radius: 5px;
                border: none;
            }

            .button-container {
                text-align: center;
                margin-top: 20px;
            }

            .button-container .btn {
                padding: 12px 24px;
                font-size: 16px;
                font-weight: bold;
                border-radius: 30px;
                text-decoration: none;
                color: #000000;
                background-color: #FFFFFF;
                border: none;
            }

            .button-container .btn:hover {
                background-color: #DDDDDD;
            }

            .register-link {
                color: #FFFFFF;
                text-decoration: none;
                margin-right: 10px; /* Added spacing */
            }

            .go-back-link {
                color: #FFFFFF;
                text-decoration: none;
                margin-left: 10px; /* Added spacing */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="title">Login Form</h1>
            <form action="login.htm" method="post">
                <div class="form-group">
                    <label for="username">User Name:</label>
                    <input type="text" id="username" name="user" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="pass" required>
                </div>
                <div class="button-container">
                    <input type="submit" value="LOGIN" class="btn">
                </div>
            </form>
            <hr>
            <a href="login/create.htm" class="register-link">New User? Register here</a>
            <a href="javascript:history.back()" class="go-back-link">Go Back</a>
        </div>
    </body>

</html>

