import newpackage.ConnectionPro;
import newpackage.User;
import newpackage.UserDatabase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User userModel = new User(name, email, password);

        UserDatabase regUser = new UserDatabase(ConnectionPro.getConnection());
        if (regUser.saveUser(userModel)) {
            response.sendRedirect("index.jsp");
        } else {
            String errorMessage = "User Available";
            HttpSession regSession = request.getSession();
            regSession.setAttribute("RegError", errorMessage);
            response.sendRedirect("register.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
