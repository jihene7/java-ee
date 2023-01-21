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

import dao.EtudiantDaoImpl;
import dao.FiliereDaoImpl;
import dao.IEtudiantDao;
import dao.IFiliereDao;
import dao.IMatiereDao;
import dao.INoteDao;
import dao.IUserDao;
import dao.MatiereDaoImpl;
import dao.NoteDaoImpl;
import dao.UserDAO;
import dao.UserDaoImpl;
import entites.Etudiant;
import entites.Filiere;
import entites.Matiere;
import entites.Note;

import entites.User;




@WebServlet (name="noteServ",urlPatterns= {"/notes","/saisieNote",
		"/saveNote","/supprimerNot","/editerNot","/updateNot","/notesEns","/saisieNoteEns",
		"/saveNoteEns","/supprimerNotEns","/editerNotEns","/updateNotEns"})
public class NoteServlet extends HttpServlet {
	
	INoteDao metier;
	 IEtudiantDao metierEtud;
	 IMatiereDao metierMat;
	 @Override
	public void init() throws ServletException {
		 
		metierMat = new MatiereDaoImpl();
		metierEtud = new EtudiantDaoImpl();
		metier = new NoteDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		
		System.out.println("PATH "+path);
		if (path.equals("/notes"))
		{
			
			String motCle=request.getParameter("motCle");
			NoteModele model= new NoteModele();
			model.setMotCle(motCle);
			List<Note> mats = metier.notesParMC(motCle);
			model.setNotes(mats);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/notes.jsp").forward(request,response);
		}
		
		else if (path.equals("/notesEns"))
		{
			
			String motCle=request.getParameter("motCle");
			NoteModele model= new NoteModele();
			model.setMotCle(motCle);
			List<Note> mats = metier.notesParMC(motCle);
			model.setNotes(mats);
			request.setAttribute("model", model);
			request.getRequestDispatcher("/WEB-INF/notesEns.jsp").forward(request,response);
		}
		else if (path.equals("/saisieNote")  )
		{//ETUDIANT
			List<Etudiant> cats = metierEtud.getAllEtudiant();
			EtudiantModele model= new EtudiantModele();
					model.setEtudiants(cats);
					request.setAttribute("EtudModel", model);
					//MATIERE
					List<Matiere> mats = metierMat.list();
					MatiereModele modelM= new MatiereModele();
							modelM.setMatieres(mats);
							request.setAttribute("MatModel", modelM);
				        
			request.getRequestDispatcher("/WEB-INF/saisieNote.jsp").forward(request,response);
		}
		else if (path.equals("/saisieNoteEns")  )
		{//ETUDIANT
			List<Etudiant> cats = metierEtud.getAllEtudiant();
			EtudiantModele model= new EtudiantModele();
					model.setEtudiants(cats);
					request.setAttribute("EtudModel", model);
					//MATIERE
					List<Matiere> mats = metierMat.list();
					MatiereModele modelM= new MatiereModele();
							modelM.setMatieres(mats);
							request.setAttribute("MatModel", modelM);
				        
			request.getRequestDispatcher("/WEB-INF/saisieNoteEns.jsp").forward(request,response);
		}
		
		else if (path.equals("/saveNote")  && request.getMethod().equals("POST"))
		{
			
			 String noteFinal=request.getParameter("noteFinal");
			
				//matiere
				Long matiereId=Long.parseLong(request.getParameter("matiere"));
				   Matiere mat = metierMat.getMatiere(matiereId);
				 //etudiant
				   Long etudiantId=Long.parseLong(request.getParameter("etudiant"));
					
					   Etudiant etudiant = metierEtud.getEtudiant(etudiantId);
				   
				   //
				   Note p = metier.save(new Note(noteFinal,etudiant,mat));
				
				request.setAttribute("note", p);
				response.sendRedirect("notes");
		
		}
		else if (path.equals("/saveNoteEns")  && request.getMethod().equals("POST"))
		{
			
			 String noteFinal=request.getParameter("noteFinal");
			
				//matiere
				Long matiereId=Long.parseLong(request.getParameter("matiere"));
				   Matiere mat = metierMat.getMatiere(matiereId);
				 //etudiant
				   Long etudiantId=Long.parseLong(request.getParameter("etudiant"));
					
					   Etudiant etudiant = metierEtud.getEtudiant(etudiantId);
				   
				   //
				   Note p = metier.save(new Note(noteFinal,etudiant,mat));
				
				request.setAttribute("note", p);
				response.sendRedirect("notesEns");
		
		}
	
		else if (path.equals("/supprimerNot"))
		{
			 Long id= Long.parseLong(request.getParameter("id"));
			    metier.deleteNote(id);
			    response.sendRedirect("notes");		
		}
		else if (path.equals("/supprimerNotEns"))
		{
			 Long id= Long.parseLong(request.getParameter("id"));
			    metier.deleteNote(id);
			    response.sendRedirect("notesEns");		
		}
		else if (path.equals("/editerNot")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Note p = metier.getNote(id);
		    request.setAttribute("note", p);
		  //ETUDIANT
			List<Etudiant> cats = metierEtud.getAllEtudiant();
			EtudiantModele model= new EtudiantModele();
					model.setEtudiants(cats);
					request.setAttribute("EtudModel", model);
					//MATIERE
					List<Matiere> mats = metierMat.list();
					MatiereModele modelM= new MatiereModele();
							modelM.setMatieres(mats);
							request.setAttribute("MatModel", modelM);
		    		//
			request.getRequestDispatcher("/WEB-INF/editerNote.jsp").forward(request,response);
		}
		else if (path.equals("/editerNotEns")  )
		{
			Long id= Long.parseLong(request.getParameter("id"));
		    Note p = metier.getNote(id);
		    request.setAttribute("note", p);
		  //ETUDIANT
			List<Etudiant> cats = metierEtud.getAllEtudiant();
			EtudiantModele model= new EtudiantModele();
					model.setEtudiants(cats);
					request.setAttribute("EtudModel", model);
					//MATIERE
					List<Matiere> mats = metierMat.list();
					MatiereModele modelM= new MatiereModele();
							modelM.setMatieres(mats);
							request.setAttribute("MatModel", modelM);
		    		//
			request.getRequestDispatcher("/WEB-INF/editerNoteEns.jsp").forward(request,response);
		}
		else if (path.equals("/updateNot")  )
		{
			Long id = Long.parseLong(request.getParameter("id"));
			 String noteFinal=request.getParameter("noteFinal");

			//matiere
				Long matiereId=Long.parseLong(request.getParameter("matiere"));
				  
				   Long etudiantId=Long.parseLong(request.getParameter("etudiant"));
					
				
				  
			 Note p = new Note();
			 p.setIdNote(id);
		
			 p.setNoteFinal(noteFinal);
			 Matiere mat = metierMat.getMatiere(matiereId);
			   Etudiant etudiant = metierEtud.getEtudiant(etudiantId);
			
                 p.setMatiere(mat);
                 p.setEtudiant(etudiant);
			 metier.updateNote(p);
			 request.setAttribute("note", p);
			
			 response.sendRedirect("notes");		
			
		}
		else if (path.equals("/updateNotEns")  )
		{
			Long id = Long.parseLong(request.getParameter("id"));
			 String noteFinal=request.getParameter("noteFinal");

			//matiere
				Long matiereId=Long.parseLong(request.getParameter("matiere"));
				  
				   Long etudiantId=Long.parseLong(request.getParameter("etudiant"));
					
				
				  
			 Note p = new Note();
			 p.setIdNote(id);
		
			 p.setNoteFinal(noteFinal);
			 Matiere mat = metierMat.getMatiere(matiereId);
			   Etudiant etudiant = metierEtud.getEtudiant(etudiantId);
			
                 p.setMatiere(mat);
                 p.setEtudiant(etudiant);
			 metier.updateNote(p);
			 request.setAttribute("note", p);
			
			 response.sendRedirect("notesEns");		
			
		}
			
	}
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}}
