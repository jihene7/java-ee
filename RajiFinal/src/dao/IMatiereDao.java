package dao;

import java.util.List;


import entites.Matiere;

public interface IMatiereDao {
public Matiere save(Matiere p);
public List<Matiere> matieresParMC(String mc);
public Matiere getMatiere(Long id);
public Matiere updateMatiere(Matiere p);
public void deleteMatiere(Long id);
public List<Matiere> list();
}