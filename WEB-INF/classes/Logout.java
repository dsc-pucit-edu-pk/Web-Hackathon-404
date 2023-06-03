import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Logout extends HttpServlet {
  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
HttpSession session = request.getSession();
    session.invalidate();
    response.sendRedirect("login.html");
  }

}