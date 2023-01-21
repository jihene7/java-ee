package web;


import java.util.ArrayList;


import java.util.List;

import entites.Matiere;

public class MatiereModele {
	private String motCle;
	List<Matiere> matieres = new ArrayList<>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
}
