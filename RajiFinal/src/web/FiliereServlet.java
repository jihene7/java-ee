package web;


import java.io.IOException;





import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import entites.Etudiant;
import entites.Filiere;




@WebServlet (name="filServ",urlPatterns= {"/filieres","/saisieFiliere",
		"/saveFiliere","/supprimerFil","/editerFil","/updateFil","/filieresEns","/saisieFiliereEns",
		"/saveFiliereEns","/supprimerFilEns","/editerFilEns","/updateFilEns"})
public class FiliereServlet extends HttpServlet {
	
	 IFiliereDao metier;
	 @Override
	public void init() throws ServletException {
		 
		metier = new FiliereDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		
		System.out.println("PATH "+path);
		if (path.equals("/filieres"))
		{
			
			FiliereModele model= new FiliereModele();
		
		List<Filiere> cats = metier.getAllFilieres();
		model.setFilieres(cats);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/filieres.jsp").forward(request,response);
		}
		else if (path.equals("/filieresEns"))
		{
			
			FiliereModele model= new FiliereModele();
		
		List<Filiere> cats = metier.getAllFilieres();
		model.setFilieres(cats);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/filieresEns.jsp").forward(request,response);
		}
		
		else if (path.equals("/saisieFiliere")  )
		{
			request.getRequestDispatcher("/WEB-INF/saisieFiliere.jsp").forward(request,response);
		}
		
		else if (path.equals("/saveFiliere")  && request.getMethod().equals("POST"))
		{
		
		    String nom=request.getParameter("nom");
		    

		  
		    
		    Filiere cat = metier.save(new Filiere(nom));
			request.setAttribute("filiere", cat);
			response.sendRedirect("filieres");
		}
		
		
		
		else if (path.equals("/saisieFiliereEns")  )
		{
			request.getRequestDispatcher("/WEB-INF/saisieFiliereEns.jsp").forward(request,response);
		}
		
		else if (path.equals("/saveFiliereEns")  && request.getMethod().equals("POST"))
		{
		
		    String nom=request.getParameter("nom");
		    

		  
		    
		    Filiere cat = metier.save(new Filiere(nom));
			request.setAttribute("filiere", cat);
			response.sendRedirect("filieresEns");
		}
		
		
		
		
		else if (path.equals("/supprimerFil"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier.deleteFiliere(id);
		    response.sendRedirect("filieres");		
		}
		else if (path.equals("/editerFil")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Filiere cat = metier.getFiliere(id);
		    request.setAttribute("filiere", cat);
			request.getRequestDispatcher("/WEB-INF/editerFiliere.jsp").forward(request,response);
		}
		else if (path.equals("/supprimerFilEns"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier.deleteFiliere(id);
		    response.sendRedirect("filieresEns");		
		}
		else if (path.equals("/editerFilEns")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Filiere cat = metier.getFiliere(id);
		    request.setAttribute("filiere", cat);
			request.getRequestDispatcher("/WEB-INF/editerFiliereEns.jsp").forward(request,response);
		}
		else if (path.equals("/updateFil")  )
		{
			
			
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			
			 Filiere cat = new Filiere();
			 cat.setIdFil(id);
			 cat.setNom(nom);
			
						 
		     metier.updateFiliere(cat);
			 response.sendRedirect("filieres");		
			
		}
	
		else if (path.equals("/updateFilEns")  )
		{
			
			
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			
			 Filiere cat = new Filiere();
			 cat.setIdFil(id);
			 cat.setNom(nom);
			
						 
		     metier.updateFiliere(cat);
			 response.sendRedirect("filieresEns");		
			
		}		
			
		
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}}
