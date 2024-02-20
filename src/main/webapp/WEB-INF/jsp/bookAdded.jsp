<%-- 
    Document   : book-success
    Created on : 26 Jun 2023, 23:37:17
    Author     : adityaillur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BookStore</title>
        <style>
            body {
                background-color: #000000;
                font-family: Arial, sans-serif;
                color: #FFFFFF;
                text-align: center;
            }

            .container {
                max-width: 600px;
                margin: 0 auto;
                padding: 40px;
            }

            .title {
                font-size: 24px;
                font-weight: bold;
                margin-bottom: 20px;
            }

            .book-info {
                margin-bottom: 20px;
                text-align: left;
            }

            .book-info label {
                font-weight: bold;
                display: inline-block;
                width: 100px;
            }

            .book-info span {
                display: inline-block;
                margin-left: 10px;
            }

            .book-info img {
                max-width: 300px;
                max-height: 400px; /* Set the maximum height for the image */
                margin-top: 20px;
                object-fit: contain; /* Maintain aspect ratio */
            }

            .go-back-link {
                display: inline-block;
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #FFFFFF;
                color: #000000;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .go-back-link:hover {
                background-color: #CCCCCC;
            }
            
            .register-link {
                color: #FFFFFF;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="title">Book ${action} Successfully</h1>
            <div class="book-info">
                <label>ISBN:</label>
                <span>${requestScope.book.bkisbn}</span><br/>
                <label>Title:</label>
                <span>${requestScope.book.bktitle}</span><br/>
                <label>Author:</label>
                <span>${requestScope.book.bkauth}</span><br/>
                <label>Book Image:</label>
                <img src="/uploads/${requestScope.book.bkisbn}.png"/>
            </div>
            <a href="/BookStoreMVC/accountPage.htm" class="go-back-link">My Account</a></a>
        </div>
    </body>
</html>
