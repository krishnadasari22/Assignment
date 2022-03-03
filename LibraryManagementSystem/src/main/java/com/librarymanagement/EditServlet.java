package com.librarymanagement;
import java.io.IOException;  
import java.io.PrintWriter;    
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Book e=BookDao.getBookById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='"+e.getAuthor()+"'/>"
        		+ "</td></tr>");  
        out.print("<tr><td>Publisher:</td><td><input type='text' name='publisher' value='"+e.getPublisher()+"'/></td></tr>");  
        out.print("<tr><td>Status:</td><td>");  
        out.print("<select name='status' style='width:150px'>");  
        out.print("<option>Assigned</option>");  
        out.print("<option>Availability</option>");  
        out.print("<option>Recovered</option>");   
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}
