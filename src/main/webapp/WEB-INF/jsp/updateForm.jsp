<%-- 
    Document   : bookUpdate
    Created on : 2 Jul 2023, 18:39:10
    Author     : adityaillur
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

            .form-group {
                margin-bottom: 20px;
                text-align: left;
            }

            .form-group label {
                display: block;
                font-weight: bold;
            }

            .form-group input[type="text"],
            .form-group input[type="file"] {
                width: 100%;
                padding: 10px;
                font-size: 16px;
            }

            .form-group .error-message {
                color: #FF0000;
            }

            .form-group .submit-button {
                display: block;
                margin: 20px auto;
                padding: 12px 24px;
                font-size: 16px;
                font-weight: bold;
                border-radius: 30px;
                text-decoration: none;
                color: #000000;
                background-color: #FFFFFF;
                border: none;
                transition: background-color 0.3s ease;
            }

            .form-group .submit-button:hover {
                background-color: #DDDDDD;
            }

            .register-link {
                display: block;
                margin-top: 20px;
                color: #FFFFFF;
                text-decoration: none;
                font-weight: bold;
            }

            .button-container {
                display: flex;
                justify-content: center;
            }

            .button-container .submit-button {
                margin: 10px;
            }

            .button-container .submit-button:hover {
                background-color: #DDDDDD;
            }

            .go-back-link {
                color: #FFFFFF;
                text-decoration: underline;
                /*              margin-left: 10px;  Added spacing */
            }

            .button-container-add {
                display: flex;
                flex-wrap: wrap;
                justify-content: center;
                margin-top: 2px;
                margin-top: 2px;
            }

            .button-container-add .btn {
                margin: 10px;
                padding: 12px 24px;
                font-size: 16px;
                /*font-weight: bold;*/
                border-radius: 30px;
                text-decoration: none;
                color: #000000;
                background-color: #FFFFFF;
                border: none;
            }

            .button-container-add .btn:hover {
                background-color: #DDDDDD;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="title">Update the Book</h1>
            <form:form modelAttribute="book" action="../book/update.htm" method="post" enctype="multipart/form-data">
                <form:input path="bkid" hidden="true" defaultValue="${book.bkid}" />
                <div class="form-group">
                    <label for="bkisbn">ISBN:</label>
                    <!--${book.bkisbn}-->
                    <form:input path="bkisbn" defaultValue="${book.bkisbn}"/>
                    <form:errors path="bkisbn" cssClass="error-message"/>
                </div>

                <div class="form-group">
                    <label for="bktitle">Book Title:</label>
                    <form:input path="bktitle" defaultValue="${book.bktitle}"/>
                    <form:errors path="bktitle" cssClass="error-message"/>
                </div>

                <div class="form-group">
                    <label for="bkauth">Author:</label>
                    <form:input path="bkauth" defaultValue="${book.bkauth}"/>
                </div>
                
                <div class="form-group">
                    <label for="image">Book Image:</label>
                    <input type="file" name="image" required="required" class="register-link" />
                    <form:errors path="image" cssClass="error-message"/>
                </div>
                
                <div class="button-container-add">
                    <input type="submit" value="Update" class="btn" />
                </div>
                <a href="/BookStoreMVC/accountPage.htm" class="go-back-link">< My Account</a>
            </form:form>
        </div>
    </body>
</html>
