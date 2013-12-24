package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Discipline;
import models.DisciplinesGrid;
import models.Periodo;

public class Sistema {

	private DisciplinesGrid grid;
	private List<Periodo> periods;
	
	public Sistema() {
		try {
			grid = new DisciplinesGrid();

		} catch (IOException e) {
			e.printStackTrace();
		}

		periods = new ArrayList<Periodo>();
		firstPeriodDefault();
	}
	

	private void firstPeriodDefault() {
	
		for (int i = 0 ; i < 8 ; i++) {
			Periodo periodo = new Periodo(i);
			getPeriods().add(periodo);
		}
		
		addDiscipline("ÁLGEBRA VETORIAL E GEOMETRIA ANALÍTICA", 0);
		addDiscipline("CALCULO DIF E INTEGRAL I", 0);
		addDiscipline("INTRODUÇÃO A COMPUTAÇÃO", 0);
		addDiscipline("LABORATÓRIO DE PROGRAMAÇÃO I", 0);
		addDiscipline("LEITURA E PRODUCAO DE TEXTOS", 0);
		addDiscipline("PROGRAMAÇÃO I", 0);
	}
	
	public boolean addDiscipline(String nome, int idxPeriodo) {

		boolean result = false;
		
		Discipline disc = grid.searchDiscipline(nome);
		Periodo period = periods.get(idxPeriodo);
		
		if (grid.getRequisitsAvailable(disc, idxPeriodo) && period.disciplineAvailable(disc)) {
		
			result = period.addDiscipline(disc);
		}
		
		return result;
	}
	
	public List<Periodo> getPeriods() {
		return periods;
	}

	public Periodo getPeriodo(int i) {
		return getPeriods().get(i);
	}

	public DisciplinesGrid getGrid() {
		return grid;
	}

	public List<Discipline> getDisciplinasOfertadas() {
		return grid.getDisciplines();
	}

	public void selectDiscipline(Integer periodo, String nomeDaDisciplina) {
		
		Discipline disciplina = grid.searchDiscipline(nomeDaDisciplina);
		
		if (disciplina.getPeriod() == Discipline.NO_PERIOD) {
			addDiscipline(nomeDaDisciplina, periodo - 1);
		}
	}

	public void removeDiscipline(String nomeDaDisciplina) {
		
		Discipline disc = getGrid().searchDiscipline(nomeDaDisciplina);
		
		if ((disc != null) && disc.getPeriod() != Discipline.NO_PERIOD) {
		
			getPeriodo(disc.getPeriod()).removeDiscipline(disc);
			disc.removePeriod();
			
			for (String disciplinaStr : disc.getDiscDependents()) {
			
				Discipline disciplinaDependente = getGrid().searchDiscipline(disciplinaStr);
				
				if (disciplinaDependente != null) { 
					removeDiscipline(disciplinaDependente.getName());
				}
			}
		}
	}
}
