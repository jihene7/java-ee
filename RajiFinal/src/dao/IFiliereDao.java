package dao;

import java.util.List;

import entites.Filiere;

public interface IFiliereDao {
	public Filiere save(Filiere cat);
	public Filiere getFiliere(Long id);
	public Filiere updateFiliere(Filiere cat);
	public void deleteFiliere(Long id);
	public List<Filiere> getAllFilieres();

}
