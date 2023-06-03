import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class EditJobs extends HttpServlet {
  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	
	PrintWriter out = response.getWriter();
out.println("<html><body>");
HttpSession session = request.getSession(false);
    int type = (int)session.getAttribute("type");
    if(type==1){
    String id=request.getParameter("id");
    String title=request.getParameter("title");
    String location=request.getParameter("location");
String category=request.getParameter("category");
String status=request.getParameter("status");
String company=request.getParameter("company");
String description=request.getParameter("d");
    
   


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost/registeration";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

     
     String query = "UPDATE jobs SET title='"+title+"',location='"+location+"',category='"+category+"',status='"+status+"',company='"+company+"',description='"+description+"' WHERE id="+id+"";
     

      int rs = st.executeUpdate( query );

     if(rs==1){		response.sendRedirect("ViewJobs.jsp");  		}
	else{	out.println("<h1>Job could not be updated id may be invalid</h1>");
               out.println("<a href=\"http://localhost:8080/online%20job%20portal/admin.jsp\">MainPage</a>");
}
     out.println("</body></html>");

           st.close();
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