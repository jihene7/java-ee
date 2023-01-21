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

import dao.EtudiantDaoImpl;
import dao.IEtudiantDao;
import entites.Etudiant;



@WebServlet (name="etudServ",urlPatterns= {"/etudiants","/saisieEtudiant",
		"/saveEtudiant","/supprimerEtud","/editerEtud","/updateEtud","/etudiantsEns","/saisieEtudiantEns",
		"/saveEtudiantEns","/supprimerEtudEns","/editerEtudEns","/updateEtudEns"})
public class EtudiantServlet extends HttpServlet {
	
	 IEtudiantDao metier;
	 @Override
	public void init() throws ServletException {
		 
		metier = new EtudiantDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		
		System.out.println("PATH "+path);
		if (path.equals("/etudiants"))
		{
			
			EtudiantModele model= new EtudiantModele();
		
		List<Etudiant> cats = metier.getAllEtudiant();
		model.setEtudiants(cats);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/etudiants.jsp").forward(request,response);
		}
		else if (path.equals("/etudiantsEns"))
		{
			
			EtudiantModele model= new EtudiantModele();
		
		List<Etudiant> cats = metier.getAllEtudiant();
		model.setEtudiants(cats);
		request.setAttribute("model", model);
		request.getRequestDispatcher("/WEB-INF/etudiantsEns.jsp").forward(request,response);
		}
		
		else if (path.equals("/saisieEtudiant")  )
		{
			request.getRequestDispatcher("/WEB-INF/saisieEtudiant.jsp").forward(request,response);
		}
		else if (path.equals("/saisieEtudiantEns")  )
		{
			request.getRequestDispatcher("/WEB-INF/saisieEtudiantEns.jsp").forward(request,response);
		}
		
		else if (path.equals("/saveEtudiant")  && request.getMethod().equals("POST"))
		{
			Date dateEtud= new Date();
		
		    String nom=request.getParameter("nom");
			   String prenom=request.getParameter("prenom");
			   String email=request.getParameter("email");
			   String contact=request.getParameter("contact");
			   String gender=request.getParameter("gender");
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		    try {
		    	dateEtud = simpleDateFormat.parse(request.getParameter("dateEtud"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		    
			Etudiant cat = metier.save(new Etudiant(nom,prenom,email,contact,gender,dateEtud));
			request.setAttribute("etudiant", cat);
			response.sendRedirect("etudiants");
		}
		else if (path.equals("/saveEtudiantEns")  && request.getMethod().equals("POST"))
		{
			Date dateEtud= new Date();
		
		    String nom=request.getParameter("nom");
			   String prenom=request.getParameter("prenom");
			   String email=request.getParameter("email");
			   String contact=request.getParameter("contact");
			   String gender=request.getParameter("gender");
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		    try {
		    	dateEtud = simpleDateFormat.parse(request.getParameter("dateEtud"));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		    
			Etudiant cat = metier.save(new Etudiant(nom,prenom,email,contact,gender,dateEtud));
			request.setAttribute("etudiant", cat);
			response.sendRedirect("etudiantsEns");
		}
		else if (path.equals("/supprimerEtud"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier.deleteEtudiant(id);
		    response.sendRedirect("etudiants");		
		}
		else if (path.equals("/editerEtud")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Etudiant cat = metier.getEtudiant(id);
		    request.setAttribute("etudiant", cat);
			request.getRequestDispatcher("/WEB-INF/editerEtudiant.jsp").forward(request,response);
		}
		else if (path.equals("/supprimerEtudEns"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    metier.deleteEtudiant(id);
		    response.sendRedirect("etudiantsEns");		
		}
		else if (path.equals("/editerEtudEns")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
			Etudiant cat = metier.getEtudiant(id);
		    request.setAttribute("etudiant", cat);
			request.getRequestDispatcher("/WEB-INF/editerEtudiantEns.jsp").forward(request,response);
		}
		else if (path.equals("/updateEtud")  )
		{
			 Date dateEtud= new Date();
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 String prenom=request.getParameter("prenom");
			   String email=request.getParameter("email");
			   String contact=request.getParameter("contact");
			   String gender=request.getParameter("gender");
			 Etudiant cat = new Etudiant();
			 cat.setIdEtud(id);
			 cat.setNom(nom);
			 cat.setPrenom(prenom);
			 cat.setEmail(email);
			 cat.setContact(contact);
			 cat.setGender(gender);
			 String pattern = "yyyy-MM-dd";
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			    try {
					 dateEtud = simpleDateFormat.parse(request.getParameter("dateNaissance"));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			 cat.setDateNaissance(dateEtud);
						 
		     metier.updateEtudiant(cat);
			 response.sendRedirect("etudiants");		
			
		}
		else if (path.equals("/updateEtudEns")  )
		{
			 Date dateEtud= new Date();
			 Long id = Long.parseLong(request.getParameter("id"));
			 String nom=request.getParameter("nom");
			 String prenom=request.getParameter("prenom");
			   String email=request.getParameter("email");
			   String contact=request.getParameter("contact");
			   String gender=request.getParameter("gender");
			 Etudiant cat = new Etudiant();
			 cat.setIdEtud(id);
			 cat.setNom(nom);
			 cat.setPrenom(prenom);
			 cat.setEmail(email);
			 cat.setContact(contact);
			 cat.setGender(gender);
			 String pattern = "yyyy-MM-dd";
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			    try {
					 dateEtud = simpleDateFormat.parse(request.getParameter("dateNaissance"));
				} catch (ParseException e) {
					
					e.printStackTrace();
				}
			 cat.setDateNaissance(dateEtud);
						 
		     metier.updateEtudiant(cat);
			 response.sendRedirect("etudiantsEns");		
			
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

