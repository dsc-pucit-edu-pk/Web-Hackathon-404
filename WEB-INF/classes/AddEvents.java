import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class AddEvents extends HttpServlet {
  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	
	PrintWriter out = response.getWriter();
HttpSession session = request.getSession(false);
   

    String image=request.getParameter("image");
    String title=request.getParameter("title");
String description=request.getParameter("description");
String date=request.getParameter("date");
String time=request.getParameter("time");

    
   


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost/event scheduler";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

     
     String query = "Insert into eventss(image,title,description,date,time)VALUES('"+ image + "','" + title+ "','" + description+ "','" + date+ "','" + time+ "') ";

     int rs = st.executeUpdate( query );

     if(rs==1){	
response.sendRedirect("ViewEvents.java");
 		}
	else{	out.println("<h1>Event could not be added.</h1>");
	}

     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }
}


}
