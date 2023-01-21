package entites;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity  

public class Note implements Serializable{
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long idNote;
	


	
	private String noteFinal;

	private Etudiant etudiant;
	private Matiere matiere;
	public Long getIdNote() {
		return idNote;
	}
	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}
	public String getNoteFinal() {
		return noteFinal;
	}
	public void setNoteFinal(String noteFinal) {
		this.noteFinal = noteFinal;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	@Override
	public String toString() {
		return "Note [idNote=" + idNote + ", noteFinal=" + noteFinal + ", etudiant=" + etudiant + ", matiere=" + matiere + "]";
	}
	public Note(Long idNote, String noteFinal, Etudiant etudiant, Matiere matiere) {
		super();
		this.idNote = idNote;
		this.noteFinal = noteFinal;
		this.etudiant = etudiant;
		this.matiere = matiere;
	}
	public Note(String noteFinal, Etudiant etudiant, Matiere matiere) {
		super();
		this.noteFinal = noteFinal;
		this.etudiant = etudiant;
		this.matiere = matiere;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

    
		
}