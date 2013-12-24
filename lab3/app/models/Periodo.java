package models;

import java.util.ArrayList;
import java.util.List;


public class Periodo {
	
	public static final int MIN_CREDITS = 14;
	
	private int periodID;
	
	List<Discipline> disciplines;

	public Periodo(int periodID) {
	
		this.periodID = periodID;
		disciplines = new ArrayList<Discipline>();
	}
	
	public List<Discipline> getDisciplines() {
		
		return disciplines;
	}
	
	public boolean addDiscipline(Discipline disc) {
		
		disc.choosePeriod(periodID);
		
		return disciplines.add(disc);
	}

	public boolean removeDiscipline(Discipline disc) {
			
		disc.removePeriod();
		return disciplines.remove(disc);
	}
	
	public boolean disciplineAvailable(Discipline disc) {
	
		return (disc.getPeriod() == Discipline.NO_PERIOD) && (getCredits() + disc.getCredits()) <= 28; 
	}
	
	public int getCredits() {
		
		int credits = 0;
		
		for (Discipline disciplina : disciplines) {
			credits += disciplina.getCredits();
		}
		
		return credits;
	}
	
	public boolean lessCreditsRequired() {

		return getCredits() < MIN_CREDITS;
	}
}
