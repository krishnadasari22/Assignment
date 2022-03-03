package com.librarymanagement;
import java.io.*;    
import java.util.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;   
@SuppressWarnings("serial")
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Book</a>");  
        out.println("<h1>Books List</h1>");  
          
        List<Book> list=BookDao.getAllBooks();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Author</th><th>Publidher</th><th>Status</th>"
        		+ "<th>Edit</th><th>Delete</th></tr>");  
        for(Book e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getAuthor()+"</td>"
         		+ "<td>"+e.getPublisher()+"</td><td>"+e.getStatus()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td>"
         				+ "<td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}