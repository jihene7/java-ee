package web;



import java.io.IOException;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.FiliereDaoImpl;
import dao.IFiliereDao;
import dao.IMatiereDao;
import dao.IUserDao;
import dao.MatiereDaoImpl;
import dao.UserDAO;
import dao.UserDaoImpl;
import entites.Filiere;
import entites.Matiere;

import entites.User;




@WebServlet (name="matServ",urlPatterns= {"/matieres","/saisieMatiere",
		"/saveMatiere","/supprimerMat","/editerMat","/updateMat","/matieresEns","/saisieMatiereEns",
		"/saveMatiereEns","/supprimerMatEns","/editerMatEns","/updateMatEns"})
public class MatiereServlet extends HttpServlet {
	
	IMatiereDao metier;
	 IFiliereDao metierFil;
	 IUserDao metierUser;
	 @Override
	public void init() throws ServletException {
		 
		metier = new MatiereDaoImpl();
		metierFil = new FiliereDaoImpl();
		metierUser = new UserDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		
		System.out.println("PATH "+path);
		if (path.equals("/matieres"))
		{
			
			String motCle=request.getParameter("motCle");
			MatiereModele model= new MatiereModele();
			model.setMotCle(motCle);
			List<Matiere> mats = metier.matieresParMC(motCle);
			model.setMatieres(mats);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/matieres.jsp").forward(request,response);
		}
		
		
		else if (path.equals("/saisieMatiere")  )
		{//filiere
			List<Filiere> cats = metierFil.getAllFilieres();
			FiliereModele model= new FiliereModele();
					model.setFilieres(cats);
					request.setAttribute("filModel", model);
					//user
					List<User> users = metierUser.getAllUsers();
					UserModele modelU= new UserModele();
							modelU.setUsers(users);
							request.setAttribute("UserModel", modelU);
				        
			request.getRequestDispatcher("/WEB-INF/saisieMatiere.jsp").forward(request,response);
		}
		
		else if (path.equals("/saveMatiere")  && request.getMethod().equals("POST"))
		{
			 String nomMatiere=request.getParameter("nomMatiere");
			  
				double coef = Double.parseDouble(request.getParameter("coef"));
				//filiere
				Long filiereId=Long.parseLong(request.getParameter("filiere"));
				   Filiere cat = metierFil.getFiliere(filiereId);
				 //filiere
					int userId = Integer.parseInt(request.getParameter("user"));
					
					   User user = metierUser.getUser(userId);
				   
				   //
				   Matiere p = metier.save(new Matiere(nomMatiere,coef,cat,user));
				
				request.setAttribute("matiere", p);
				response.sendRedirect("matieres");
		
		}
	
		else if (path.equals("/supprimerMat"))
		{
			 Long id= Long.parseLong(request.getParameter("id"));
			    metier.deleteMatiere(id);
			    response.sendRedirect("matieres");		
		}
		else if (path.equals("/editerMat")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Matiere p = metier.getMatiere(id);
		    request.setAttribute("matiere", p);
		   //filiere 
		    List<Filiere> cats = metierFil.getAllFilieres();
		    FiliereModele model= new FiliereModele();
		    		model.setFilieres(cats);
		    		request.setAttribute("filModel", model);
		    		//user
		    		//user
					List<User> users = metierUser.getAllUsers();
					UserModele modelU= new UserModele();
							modelU.setUsers(users);
							request.setAttribute("UserModel", modelU);
		    		//
			request.getRequestDispatcher("/WEB-INF/editerMatiere.jsp").forward(request,response);
		}
		else if (path.equals("/updateMat")  )
		{
			Long id = Long.parseLong(request.getParameter("id"));
			 String nomMatiere=request.getParameter("nomMatiere");
			 double coef = Double.parseDouble(request.getParameter("coef"));
			 
                  Long filiereId=Long.parseLong(request.getParameter("filiere"));
                  int userId = Integer.parseInt(request.getParameter("user"));
				  
			 Matiere p = new Matiere();
			 p.setIdMat(id);
			 p.setNomMatiere(nomMatiere);
			 p.setCoef(coef);
			 User existingUser = metierUser.getUser(userId);
                   Filiere cat = metierFil.getFiliere(filiereId);
                 p.setFiliere(cat);
                 p.setUser(existingUser);
			 metier.updateMatiere(p);
			 request.setAttribute("matiere", p);
			
			 response.sendRedirect("matieres");		
			
		}
		
		
		
		
		//
		else if (path.equals("/matieresEns"))
		{
			
			String motCle=request.getParameter("motCle");
			MatiereModele model= new MatiereModele();
			model.setMotCle(motCle);
			List<Matiere> mats = metier.matieresParMC(motCle);
			model.setMatieres(mats);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/matieresEns.jsp").forward(request,response);
		}
		
		
		else if (path.equals("/saisieMatiereEns")  )
		{//filiere
			List<Filiere> cats = metierFil.getAllFilieres();
			FiliereModele model= new FiliereModele();
					model.setFilieres(cats);
					request.setAttribute("filModel", model);
					//user
					List<User> users = metierUser.getAllUsers();
					UserModele modelU= new UserModele();
							modelU.setUsers(users);
							request.setAttribute("UserModel", modelU);
				        
			request.getRequestDispatcher("/WEB-INF/saisieMatiereEns.jsp").forward(request,response);
		}
		
		else if (path.equals("/saveMatiereEns")  && request.getMethod().equals("POST"))
		{
			 String nomMatiere=request.getParameter("nomMatiere");
			  
				double coef = Double.parseDouble(request.getParameter("coef"));
				//filiere
				Long filiereId=Long.parseLong(request.getParameter("filiere"));
				   Filiere cat = metierFil.getFiliere(filiereId);
				 //filiere
					int userId = Integer.parseInt(request.getParameter("user"));
					
					   User user = metierUser.getUser(userId);
				   
				   //
				   Matiere p = metier.save(new Matiere(nomMatiere,coef,cat,user));
				
				request.setAttribute("matiere", p);
				response.sendRedirect("matieresEns");
		
		}
	
		else if (path.equals("/supprimerMatEns"))
		{
			 Long id= Long.parseLong(request.getParameter("id"));
			    metier.deleteMatiere(id);
			    response.sendRedirect("matieresEns");		
		}
		else if (path.equals("/editerMatEns")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Matiere p = metier.getMatiere(id);
		    request.setAttribute("matiere", p);
		   //filiere 
		    List<Filiere> cats = metierFil.getAllFilieres();
		    FiliereModele model= new FiliereModele();
		    		model.setFilieres(cats);
		    		request.setAttribute("filModel", model);
		    		//user
		    		//user
					List<User> users = metierUser.getAllUsers();
					UserModele modelU= new UserModele();
							modelU.setUsers(users);
							request.setAttribute("UserModel", modelU);
		    		//
			request.getRequestDispatcher("/WEB-INF/editerMatiereEns.jsp").forward(request,response);
		}
		else if (path.equals("/updateMatEns")  )
		{
			Long id = Long.parseLong(request.getParameter("id"));
			 String nomMatiere=request.getParameter("nomMatiere");
			 double coef = Double.parseDouble(request.getParameter("coef"));
			 
                  Long filiereId=Long.parseLong(request.getParameter("filiere"));
                  int userId = Integer.parseInt(request.getParameter("user"));
				  
			 Matiere p = new Matiere();
			 p.setIdMat(id);
			 p.setNomMatiere(nomMatiere);
			 p.setCoef(coef);
			 User existingUser = metierUser.getUser(userId);
                   Filiere cat = metierFil.getFiliere(filiereId);
                 p.setFiliere(cat);
                 p.setUser(existingUser);
			 metier.updateMatiere(p);
			 request.setAttribute("matiere", p);
			
			 response.sendRedirect("matieresEns");		
			
		}
			
	}
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}}
