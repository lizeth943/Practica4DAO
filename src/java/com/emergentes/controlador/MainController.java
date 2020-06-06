package com.emergentes.controlador;
import com.emergentes.modelo.Blog;
import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException 
 {
        
     String op;
     op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
     ArrayList<Blog> lista = new ArrayList<Blog>();
        
     ConexionBD canal = new ConexionBD();
     Connection conn = canal.conectar();
        
      PreparedStatement ps;
      ResultSet rs;
      
      if(op.equals("list")){
          try{
                String sql = "select * from blog ";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while(rs.next())
                {
                    Blog bl = new Blog();
                    bl.setId(rs.getInt("id"));
                    bl.setFecha(rs.getString("fecha"));
                    bl.setTitulo(rs.getString("titulo"));
                    bl.setContenido(rs.getString("contenido"));
                    lista.add(bl);     
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }catch (SQLException ex){
                System.out.println("Error en sql:" + ex.getMessage ());
            }finally {
               canal.desconectar(); 
            }
          
      }
      if(op.equals("editar"))
      {
          
            try {
                int id = Integer.parseInt(request.getParameter(("id")));
                
                String sql = "select * from blog where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                
                rs = ps.executeQuery();
               
                Blog b = new Blog();
                
                while(rs.next())
                {
                   
                    b.setId(rs.getInt("id"));
                    b.setFecha(rs.getString("fecha"));
                    b.setTitulo(rs.getString("titulo"));
                    b.setContenido(rs.getString("contenido"));
                        
                }
             request.setAttribute("Blog", b);
             request.getRequestDispatcher("editar.jsp").forward(request, response);
                
            } catch (SQLException ex) {
               System.out.println("Error en sql:" + ex.getMessage ());
            }
         
      }
      
       if(op.equals("nuevo"))
     {
           
        Blog l = new Blog();
        request.setAttribute("blog", l);
        request.getRequestDispatcher("nuevo.jsp").forward(request, response);    
      }
       
      
       if(op.equals("eliminar"))
       {
           
          try{
          int id = Integer.parseInt(request.getParameter("id"));
          String sql = "delete from blog where id = ?";
          ps = conn.prepareStatement(sql);
          ps.setInt(1, id);
          ps.executeUpdate();
          
          }catch (SQLException ex){
              System.out.println("Error en sql:" + ex.getMessage ());
          }finally {
                canal.desconectar();
            }
          response.sendRedirect("MainController");
          
      }
       
      }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
      int id = Integer.parseInt(request.getParameter("id"));
      String fecha = request.getParameter("fecha");
      String titulo = request.getParameter("titulo");
      String contenido = request.getParameter("contenido");
      
      Blog l = new Blog();
      l.setId(id);
      l.setFecha(fecha);
      l.setTitulo(titulo);
      l.setContenido(contenido); 
      
      ConexionBD canal = new ConexionBD();
      Connection conn = canal.conectar();
      PreparedStatement ps;
      ResultSet rs;
      
      if(id == 0){
          
          try {
              String sql = "insert into blog (fecha,titulo,contenido) values(?,?,?)";
              ps = conn.prepareStatement(sql);
              ps.setString(1, l.getFecha());
              ps.setString(2, l.getTitulo());
              ps.setString(3, l.getContenido());
              ps.executeUpdate();
              
          } catch (SQLException ex) {
              System.out.println("Error en sql:" + ex.getMessage ());
          }finally {
                canal.desconectar();
               } 
          response.sendRedirect("MainController");
          }
      
      else{
    
          try {
              String sql = "update blog set fecha=?,titulo=?,contenido=?,where id=?";
              ps = conn.prepareStatement(sql);
              ps.setString(1, l.getFecha());
              ps.setString(2, l.getTitulo());
              ps.setString(3, l.getContenido());
              ps.setInt(4,l.getId());
              ps.executeUpdate();
              
          } catch (SQLException ex) {
              System.out.println("Error al actualizar" + ex.getMessage ());
             
          }
              response.sendRedirect("MainController");
        }
    
    }
    
 } 

