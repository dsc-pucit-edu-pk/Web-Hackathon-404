import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class DeleteJobs extends HttpServlet {
  
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	
	PrintWriter out = response.getWriter();
HttpSession session = request.getSession(false);
    int type = (int)session.getAttribute("type");
    if(type==1){
    int id=Integer.parseInt(request.getParameter("id"));
    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost/registeration";

    Connection con=DriverManager.getConnection(url, "root", "root");
   String query = "DELETE FROM jobs WHERE id = ?";
   PreparedStatement st = con.prepareStatement(query);
    st.setInt(1, id);
    int rs = st.executeUpdate();


     if(rs==1){	response.sendRedirect("ViewJobs.jsp"); 		}
	else{	out.println("<h1>Job could not be deleted id may be invalid</h1>");
out.println("<a href=\"http://localhost:8080/online%20job%20portal/admin.jsp\">MainPage</a>"); 		}

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