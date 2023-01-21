package web;


import java.util.ArrayList;

import java.util.List;
import entites.Etudiant;


public class EtudiantModele {
	List<Etudiant> etudiants = new ArrayList<>();
	
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
}

