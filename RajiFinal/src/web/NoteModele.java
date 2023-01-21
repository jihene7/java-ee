package web;

import java.util.ArrayList;
import java.util.List;

import entites.Note;

public class NoteModele {
	private String motCle;
	List<Note> notes = new ArrayList<>();
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Note> getNotes() {
		return notes;
	}
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
