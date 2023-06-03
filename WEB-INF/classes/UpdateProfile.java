import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class UpdateProfile extends HttpServlet {
  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	
	PrintWriter out = response.getWriter();
HttpSession session = request.getSession(false);
    int type = (int)session.getAttribute("type");
    if(type!=1&&type!=0){
    String name=request.getParameter("name");
    String email=request.getParameter("Email");
    String password=request.getParameter("pwd");
    String qual=request.getParameter("qualification");
   
 try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost/registeration";

    Connection con=DriverManager.getConnection(url, "root", "root");
    String query = "UPDATE reg SET username=?,email=?,password=?,qualification=? WHERE type=?";
    PreparedStatement stmt=con.prepareStatement(query);
    stmt.setString(1,name);
  stmt.setString(2,email);
stmt.setString(3,password);
stmt.setString(4,qual);
stmt.setInt(5,type);
int rs = stmt.executeUpdate();
     

     if(rs==1){	out.println("<h1>Profile updated successfully</h1>");
response.sendRedirect("ViewProfile.jsp"); 		}
	else{	out.println("<h1>Profile could not be updated</h1>"); 		
out.println("<a href=\"http://localhost:8080/online%20job%20portal/login.jsp\">MainPage</a>"); 		}


     out.println("</body></html>");

           stmt.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }
}
else {
	
	 PrintWriter out1 = response.getWriter();
	  out.println("<html>");
	 out.println("<h1>Invalid Page</h1>");
	out.println("</body></html>");
  }

}
}