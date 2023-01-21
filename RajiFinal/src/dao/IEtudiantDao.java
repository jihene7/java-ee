package dao;

import java.util.List;

import entites.Etudiant;

public interface IEtudiantDao {
	public Etudiant save(Etudiant cat);
	public Etudiant getEtudiant(Long id);
	public Etudiant updateEtudiant(Etudiant cat);
	public void deleteEtudiant(Long id);
	public List<Etudiant> getAllEtudiant();

}
