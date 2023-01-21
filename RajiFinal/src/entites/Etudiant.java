package entites;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity  

public class Etudiant implements Serializable {
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	private Long idEtud;
	
	private String 	nom;
	private String 	prenom;
	private String 	email;
	private String 	contact;
	private String 	gender;
	@OneToMany (mappedBy="etudiant") 
    private List<Note> note;
	
	
	public Etudiant(String nom, String prenom, String email, String contact, String gender, List<Note> note,
			Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.note = note;
		this.dateNaissance = dateNaissance;
	}

	public Etudiant(Long idEtud, String nom, String prenom, String email, String contact, String gender,
			List<Note> note, Date dateNaissance) {
		super();
		this.idEtud = idEtud;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.note = note;
		this.dateNaissance = dateNaissance;
	}

	public List<Note> getNote() {
		return note;
	}

	public void setNote(List<Note> note) {
		this.note = note;
	}

	@Temporal( TemporalType.DATE)
	private Date dateNaissance;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getIdEtud() {
		return idEtud;
	}
	
	public void setIdEtud(Long idEtud) {
		this.idEtud = idEtud;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public String toString() {
		return "Etudiant [idEtud=" + idEtud + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", contact="
				+ contact + ", gender=" + gender + ", dateNaissance=" + dateNaissance + "]";
	}
	

	public Etudiant(String nom, String prenom, String email, String contact, String gender, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.dateNaissance = dateNaissance;
	}

	public Etudiant(Long idEtud, String nom, String prenom, String email, String contact, String gender,
			Date dateNaissance) {
		super();
		this.idEtud = idEtud;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.contact = contact;
		this.gender = gender;
		this.dateNaissance = dateNaissance;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}
