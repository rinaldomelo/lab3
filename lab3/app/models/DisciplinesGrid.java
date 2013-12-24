package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinesGrid {

	private List<Discipline> disciplines;
	
	public DisciplinesGrid() throws IOException {
		
		disciplines = new ArrayList<Discipline>();
		loadDisciplines();
	}
	
	private void loadDisciplines() throws IOException {
		
		String diretory = new File("resources/disciplinesGrid.txt").getCanonicalPath();
		BufferedReader reader = new BufferedReader(new FileReader(new File(diretory)));
		
		while (reader.ready()) {
			
			String[] info = reader.readLine().split(":");
			String name = info[0];
			String[] dependents = {};
			String[] requisits = {};
			String credits = info[3];
						
			if (!info[1].equals("---")) {dependents = info[1].split(",");}			
			if (!info[2].equals("---")) {requisits = info[2].split(",");}
			
			disciplines.add(new Discipline(name, Integer.parseInt(credits), dependents, requisits));
		}
			
		reader.close();
	}
	
	
	private List<Discipline> getSelectedDisciplines(String nome) {
		
		List<Discipline> selectedDisciplines = new ArrayList<Discipline>();
		
		for (Discipline disciplina : disciplines) {
			
			if (!disciplina.getName().equals(nome) && disciplina.isSelected()) {
				selectedDisciplines.add(disciplina);
			}
		}
		
		return selectedDisciplines;
	}
	
	public List<Discipline> getDependentesDe(String name) {
	
		Discipline discipline = searchDiscipline(name);
		undoSelectDisciplines();
		visitaDependentes(discipline);	
		
		return getSelectedDisciplines(name);
	}
	
	private void visitaDependentes(Discipline currentDiscipline) {
		currentDiscipline.selectTrue();
		
		for (String disciplina : currentDiscipline.getDiscDependents()) {
		
			Discipline proxima = searchDiscipline(disciplina); 

			if (proxima != null && !proxima.isSelected()) {
				visitaDependentes(proxima);
			}
		}
	}
	
	public List<Discipline> getRequisitosDe(String nome) {
		
		Discipline discipline = searchDiscipline(nome);
		undoSelectDisciplines();
		selecteRequisits(discipline);
		return getSelectedDisciplines(nome);
	}
	
	private void selecteRequisits(Discipline currentDisc) {
		
		currentDisc.selectTrue();
		
		for (String disciplina : currentDisc.getDiscRequisits()) {
		
			Discipline proxima = searchDiscipline(disciplina); 
			
			if (proxima != null && !proxima.isSelected()) {
				selecteRequisits(proxima);
			}
		}
	}
	
	public Discipline searchDiscipline(String nome) {
		
		for (Discipline disciplina : disciplines) {
		
			if (disciplina.getName().equals(nome)) 
				return disciplina;
		}
		
		return null;
	}
	
	public List<Discipline> getDisciplines() {
		
		return disciplines;
	}

	public boolean getRequisitsAvailable(Discipline disc, int periodID) {
	
		List<Discipline> requisits = getRequisitosDe(disc.getName());
		
		for (Discipline requisito : requisits) {
			if ((requisito.getPeriod() == Discipline.NO_PERIOD) || (requisito.getPeriod() >= periodID))
				return false;
		}
		
		return true;
	}

	private void undoSelectDisciplines() {
		
		for (Discipline disc : disciplines) {
			
			disc.selectFalse();
		}
	}
}