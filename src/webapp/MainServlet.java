package webapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset = UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<head>");
        printWriter.println("<html>");
        printWriter.println("<title>Sign in</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>Вход</h1>");
        printWriter.println("<form action=\"auth\" method = \"Post\">" +
                "Логин: <input name = \"login\"> <br><br>" +
                "Пароль <input type = \"password\" name = \"password\"><br><br>" +
                "<input type=\"submit\" value =\"Войти\" />");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
}

