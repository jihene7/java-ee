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

public class User implements Serializable {
	
	@Id 
	@GeneratedValue (strategy=GenerationType.IDENTITY) 
	protected int id;
	
	protected String name;
	protected String email;
	protected String role;
	protected String pwd;
	@OneToMany (mappedBy="user") 
    private List<Matiere> matieres;
	
	public User(String name, String email, String role, String pwd, List<Matiere> matieres) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
		this.pwd = pwd;
		this.matieres = matieres;
	}
	public User(int id, String name, String email, String role, String pwd, List<Matiere> matieres) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.pwd = pwd;
		this.matieres = matieres;
	}
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
	public User(int id, String name, String email, String role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}
	public User(String name, String email, String role) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String role, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.pwd = pwd;
	}
	public User(String name, String email, String role, String pwd) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
		this.pwd = pwd;
	}
	
	
	
	





	
}
