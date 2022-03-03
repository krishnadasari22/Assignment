package com.librarymanagement;
import java.util.*;  
import java.sql.*;   
public class BookDao {   
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","abcd");  
        }catch(Exception e){
        	System.out.println(e);
        }  
        return con;  
    }  
    public static int save(Book e){  
        int status=0;  
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into bookstore.library(name,author,publisher,status) values (?,?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getAuthor());  
            ps.setString(3,e.getPublisher());  
            ps.setString(4,e.getStatus());              
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();
        }          
        return status;  
    }  
    public static int update(Book e){  
        int status=0;  
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update bookstore.library set name=?,author=?,publisher=?,status=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getAuthor());  
            ps.setString(3,e.getPublisher());  
            ps.setString(4,e.getStatus());  
            ps.setInt(5,e.getId());               
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();
        }            
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from bookstore.library where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Book getBookById(int id){  
        Book e=new Book();  
          
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from bookstore.library where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setAuthor(rs.getString(3));  
                e.setPublisher(rs.getString(4));  
                e.setStatus(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Book> getAllBooks(){  
        List<Book> list=new ArrayList<Book>();  
          
        try{  
            Connection con=BookDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from bookstore.library");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Book e=new Book();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setAuthor(rs.getString(3));  
                e.setPublisher(rs.getString(4));  
                e.setStatus(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}
