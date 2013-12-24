package models;

import java.util.ArrayList;
import java.util.List;

public class Discipline implements Comparable<Discipline> {

	public static int NO_PERIOD = -1;
	private int chosenPeriod;
	
	private List<String> dependents; 
	private List<String> requisits;
	
	private String name;
	private boolean selected;
	private int credits;
	
	public Discipline(String name, int credits, String[] listDependents, String[] listRequisits) {
		
		this.name = name;
		selected = false;
		requisits = new ArrayList<String>();
		dependents = new ArrayList<String>();
		this.credits = credits;
		chosenPeriod = NO_PERIOD;
		
		for (String disc : listDependents) {
			
			dependents.add(disc);
		}
		
		for (String disciplina : listRequisits) {
			
			requisits.add(disciplina);
		}
	}

	public String getName() {
		return name;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void selectFalse() {
		selected = false;
	}

	public void selectTrue() {
		selected = true;
	}

	public List<String> getDiscDependents() {
		return dependents;
	}

	public List<String> getDiscRequisits() {
		return requisits;
	}	
	
	public int getCredits() {
		return credits;
	}
	
	public void choosePeriod(int period) {
		chosenPeriod = period;
	}

	public void removePeriod() {
		chosenPeriod = NO_PERIOD;
	}
	
	public int getPeriod() {
		return chosenPeriod;
	}

	@Override
	public int compareTo(Discipline disciplina) {
		
		return name.compareTo(disciplina.getName());
	}

	@Override
	public boolean equals(Object object) {
		
		boolean result = true;

		if (object == null || getClass() != object.getClass()){
			result = false;
		}
		Discipline other = (Discipline) object;

		if (name == null) {
			if (other.name != null) { 
				result = false; }
			
		} else if (!name.equals(other.name))
			result = false;
		
		return result;
	}
}