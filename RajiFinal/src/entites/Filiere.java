package entites;


import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity  
public class Filiere implements Serializable {
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long idFil;
	private String 	nom;
	@OneToMany (mappedBy="filiere") 
    private List<Matiere> matieres;
	
	public Filiere(String nom, List<Matiere> matieres) {
		super();
		this.nom = nom;
		this.matieres = matieres;
	}
	public Filiere(Long idFil, String nom, List<Matiere> matieres) {
		super();
		this.idFil = idFil;
		this.nom = nom;
		this.matieres = matieres;
	}
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	public Long getIdFil() {
		return idFil;
	}
	public void setIdFil(Long idFil) {
		this.idFil = idFil;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Filiere [idFil=" + idFil + ", nom=" + nom + "]";
	}
	public Filiere(Long idFil, String nom) {
		super();
		this.idFil = idFil;
		this.nom = nom;
	}
	public Filiere(String nom) {
		super();
		this.nom = nom;
	}
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}