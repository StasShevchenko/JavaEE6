package webapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private final String DB_URL = "jdbc:postgresql://127.0.0.01:5432/javaee6";
    private final String USER = "postgres";
    private final String PASS = "MyNameIsEminem";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset = UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT name FROM users WHERE password = '" + req.getParameter("password")+ "' and name = '"+req.getParameter("login")+"'");
            if (rs.next()) {
                printWriter.println("<!DOCTYPE html>");
                printWriter.println("<html>");
                printWriter.println("<head>");
                printWriter.println("<title>Welcome!</title>");
                printWriter.println("</head>");
                printWriter.println("<body>");
                printWriter.println("<h2>Здравствуйте, " + rs.getString("name") + "</h2>");
                printWriter.println("</body>");
                printWriter.println("</html>");
            } else {
                printWriter.println("<!DOCTYPE html>");
                printWriter.println("<html>");
                printWriter.println("<head>");
                printWriter.println("<title>Welcome!</title>");
                printWriter.println("</head>");
                printWriter.println("<body>");
                printWriter.println("<h2>Ошибка ввода логина или пароля!</h2>");
                printWriter.println("</body>");
                printWriter.println("</html>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
