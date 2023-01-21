package web;

import java.io.*;
import java.sql.SQLException;
 
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.UserDAO;
import entites.User;
 
@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UserLoginServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
       
         
        UserDAO userDao = new UserDAO();
         
        try {
            User user = userDao.checkLogin(email, pwd,"admin");
            User user2 = userDao.checkLogin(email, pwd,"enseignant");
            String destPage = "login.jsp";
             
           
             if(user != null) {
            	HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
				destPage = "/WEB-INF/homeAdmin.jsp";
			

				
            }
             else if(user2 != null) {
             	HttpSession session = request.getSession();
 				session.setAttribute("user", user2);
 				
 				destPage = "/WEB-INF/homeEns.jsp";
 			

 				
             }
         
            
            else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }
             
            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);
             
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}