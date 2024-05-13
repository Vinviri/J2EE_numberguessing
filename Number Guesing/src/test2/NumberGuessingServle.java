package test2;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/NumberGuessingServlet")
public class NumberGuessingServle extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        session.setAttribute("numberToGuess", numberToGuess);
        session.setAttribute("attempts", 10);

        response.sendRedirect("numberGuessing.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int numberToGuess = (Integer) session.getAttribute("numberToGuess");
        int attempts = (Integer) session.getAttribute("attempts");
        int guess = Integer.parseInt(request.getParameter("guess"));

        if (guess < numberToGuess) {
            session.setAttribute("feedback", "Your guess is too low. Try again.");
        } else if (guess > numberToGuess) {
            session.setAttribute("feedback", "Your guess is too high. Try again.");
        } else {
            session.setAttribute("feedback", "Congratulations! You have guessed the number: " + numberToGuess);
            session.removeAttribute("numberToGuess");
            session.removeAttribute("attempts");
            session.removeAttribute("guess");
        }

        if (attempts > 0) {
            attempts--;
            session.setAttribute("attempts", attempts);
            session.setAttribute("guess", guess);
        } else {
            session.setAttribute("feedback", "You have run out of attempts. The number was: " + numberToGuess);
            session.removeAttribute("numberToGuess");
            session.removeAttribute("attempts");
            session.removeAttribute("guess");
        }

        response.sendRedirect("numberGuessing.jsp");
    }
}
