<%-- 
    Document   : accountPage
    Created on : 1 Jul 2023, 23:47:52
    Author     : adityaillur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MyAccount</title>
    <style>
        body {
            background-color: #000000;
            font-family: Arial, sans-serif;
            color: #FFFFFF;
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

        .greeting {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .username {
            font-weight: bold;
        }

        .button-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 40px;
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
        <h1 class="title">Your Account</h1>
        <div class="greeting">
            <div>   Hi ${(sessionScope.user).getUname()} 😁</div>
        </div>
        <div class="button-container">
            <a href="/BookStoreMVC/book/form.htm" class="btn">Add Books</a>
            <a href="/BookStoreMVC/book/all.htm" class="btn">View Books</a>
            <a href="/BookStoreMVC/about.pdf" class="btn">About</a>
            <a href="/BookStoreMVC/logout.htm" class="btn">Log Out</a>
        </div>
    </div>
</body>
</html>

