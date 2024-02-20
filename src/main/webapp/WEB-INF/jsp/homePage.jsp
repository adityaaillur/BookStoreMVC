<%-- 
    Document   : homePage.jsp
    Created on : 1 Jul 2023, 21:43:56
    Author     : adityaillur
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <style>
            body {
                background-color: #000000;
                font-family: Arial, sans-serif;
            }

            .container {
                max-width: 600px;
                margin: 0 auto;
                padding: 40px;
                text-align: center;
            }

            .title {
                font-size: 48px;
                font-weight: bold;
                background: linear-gradient(to right, #007AFF, #00FF00, #FFFF00, #FF0000, #FF1493, #FF8C00, #8A2BE2);
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                margin-bottom: 40px;
            }

            .button-container {
                display: flex;
                justify-content: center;
            }

            .button-container .btn {
                margin: 10px;
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
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="title">Book System</h1>
            <div class="button-container">
                <a href="/BookStoreMVC/login.htm" class="btn">Login</a>
                <a href="/BookStoreMVC/about.htm" class="btn">About</a>
            </div>
        </div>
    </body>
</html>

