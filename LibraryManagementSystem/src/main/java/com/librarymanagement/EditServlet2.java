package com.librarymanagement;
import java.io.*;    
import javax.servlet.*;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.*;    
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("name");  
        String author=request.getParameter("author");  
        String publisher=request.getParameter("publisher");  
        String status=request.getParameter("status");  
          
        Book e=new Book();  
        e.setId(id);  
        e.setName(name);  
        e.setAuthor(author);  
        e.setPublisher(publisher);  
        e.setStatus(status);  
          
        int status1=BookDao.update(e);  
        if(status1>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}
