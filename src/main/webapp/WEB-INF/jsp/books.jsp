<%-- 
    Document   : books
    Created on : 30 Jun 2023, 09:42:01
    Author     : adityaillur
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.info6250.pojo.Book"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
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

            table {
                width: 100%;
                margin-bottom: 20px;
                border-collapse: collapse;
            }

            table th, table td {
                padding: 10px;
                border: 1px solid #FFFFFF;
            }

            table th {
                background-color: #FFFFFF;
                color: #000000;
            }

            .btn-delete, .btn-update {
                padding: 8px 16px;
                margin-right: 10px; /* Adjusted margin-right */
                background-color: #FF0000;
                color: #FFFFFF;
                text-decoration: none;
                border-radius: 4px;
            }

            .btn-update {
                background-color: #0066FF;
                margin-left: 250px;
            }
            
            .btn-delete {
                margin-right:250px;
            }

            .button-container {
                margin-top: 20px;
            }

            .button-container button {
                margin-right: 10px;
            }

            .go-back-link {
                color: #FFFFFF;
                text-decoration: underline;
                margin-left: 10px; /* Added spacing */
            }
        </style>
    </head>
    <body>
        <div class="container">
            
            <form action="/BookStoreMVC/book/updateanddelete.htm" method="post">
                <h1 class="title">Books present in the database:</h1>
                <table>
                    <tr>
                        <th>Select</th>
                        <th>Title</th>
                        <th>ISBN</th>
                    </tr>
                    <c:forEach var="book" items="${bookList}">
                        <tr>
                            <!--<td><input type="radio" name="bkid" value="${book.bkid}" hidden="true"/></td>-->
                            <td><input type="radio" name="selectedBook" value="${book.bkid}" /></td>
                            <td>${book.bktitle}</td>
                            <td>${book.bkisbn}</td>
                        </tr>
                    </c:forEach>
                </table><br/>
                <div class="button-container">
                    <button type="submit" name="delete" class="btn-delete">Delete</button>
                    <button type="submit" name="update" value="true" class="btn-update">Update</button>
                </div>
            </form>
            
<!--            <form action="/BookStoreMVC/book/update.htm" method="post">
                <button type="submit" class="btn-update">Update</button>
            </form>-->
            
            <br/><a href="/BookStoreMVC/accountPage.htm" class="go-back-link">< My Account</a>
        </div>
    </body>

</html>
