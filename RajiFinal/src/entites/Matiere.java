package entites;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity  

public class Matiere implements Serializable{
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long idMat;
	

	public Matiere(String nomMatiere, double coef, Filiere filiere) {
		super();
		this.nomMatiere = nomMatiere;
		this.coef = coef;
		this.filiere = filiere;
	}
	
	public Matiere(Long idMat, String nomMatiere, double coef, List<Note> note, Filiere filiere, User user) {
		super();
		this.idMat = idMat;
		this.nomMatiere = nomMatiere;
		this.coef = coef;
		this.note = note;
		this.filiere = filiere;
		this.user = user;
	}

	public Matiere(String nomMatiere, double coef, List<Note> note, Filiere filiere, User user) {
		super();
		this.nomMatiere = nomMatiere;
		this.coef = coef;
		this.note = note;
		this.filiere = filiere;
		this.user = user;
	}

	public List<Note> getNote() {
		return note;
	}
	public void setNote(List<Note> note) {
		this.note = note;
	}

	private String nomMatiere;
	private double coef;
	@OneToMany (mappedBy="matiere") 
    private List<Note> note;

	private Filiere filiere;
	private User user;
	public Long getIdMat() {
		return idMat;
	}
	public void setIdMat(Long idMat) {
		this.idMat = idMat;
	}
	
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	public double getCoef() {
		return coef;
	}
	public void setCoef(double coef) {
		this.coef = coef;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Matiere(Long idMat, String nomMatiere, double coef, Filiere filiere, User user) {
		super();
		this.idMat = idMat;
		this.nomMatiere = nomMatiere;
		this.coef = coef;
		this.filiere = filiere;
		this.user = user;
	}
	public Matiere(String nomMatiere, double coef, Filiere filiere, User user) {
		super();
		this.nomMatiere = nomMatiere;
		this.coef = coef;
		this.filiere = filiere;
		this.user = user;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

    
		
}