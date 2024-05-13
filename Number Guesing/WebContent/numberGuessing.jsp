<%@ page import="java.util.Random" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Number Guessing Game</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Number Guessing Game</h1>
    <p class="intro">I have randomly chosen a number between 1 and 100. Try to guess the number in 10 attempts or fewer.</p>
    <form action="NumberGuessingServlet" method="post">
        <label for="guess">Enter your guess:</label>
        <input type="text" id="guess" name="guess" value="${guess}" />
        <input type="submit" value="Submit Guess" />
    </form>
    <p class="feedback"><span style="color: red;">${feedback}</span></p>
    <p class="attemps">Attempts remaining: ${attempts}</p>
    <p class="end"><a href="NumberGuessingServlet">Start a new game</a></p>
</body>
</html>