package dao;

import java.util.List;

import entites.Note;

public interface INoteDao {
	public Note save(Note p);
	public List<Note> notesParMC(String mc);
	public Note getNote(Long id);
	public Note updateNote(Note p);
	public void deleteNote(Long id);
	public List<Note> list();
}
