package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que define um periodo
 *
 */

//CREATOR: a classe Periodo guarda objetos do tipo Disciplina
public class Periodo {
	
	public static final int MIN_CREDITOS = 14;
	
	private int periodoID;
	
	List<Disciplina> disciplinas;

	/**
	 * Construtor
	 * @param periodoID
	 */
	public Periodo(int periodoID) {
	
		this.periodoID = periodoID;
		disciplinas = new ArrayList<Disciplina>();
	}
	
	/**
	 * Retorna as disciplinas do periodo
	 * @return disciplinas do periodo
	 */
	public List<Disciplina> getDisciplinas() {
		
		return disciplinas;
	}
	
	/**
	 * Adiciona uma disciplina ao periodo e retorna se foi possivel
	 * @param disc
	 * @return se foi possivel adicionar
	 */
	public boolean adicionarDisciplina(Disciplina disc) {
		
		disc.escolherPeriodo(periodoID);
		
		return disciplinas.add(disc);
	}

	/**
	 * Remove uma disciplina ao periodo e retorna se foi possivel
	 * @param disc
	 * @return se foi possivel remover
	 */
	public boolean removerDisciplina(Disciplina disc) {
			
		disc.removerPeriodo();
		return disciplinas.remove(disc);
	}
	
	/**
	 * Retorna se uma disciplina esta disponivel
	 * @param disc
	 * @return se uma disciplina esta disponivel
	 */
	public boolean disciplinaDisponivel(Disciplina disc) {
	
		return (disc.getPeriodo() == Disciplina.NO_PERIOD) && (getCreditos() + disc.getCreditos()) <= 28; 
	}
	
	/**
	 * Retorna a quantidade de creditos total do periodo
	 * @return quantidade de creditos total do periodo
	 */
	public int getCreditos() {
		
		int creditos = 0;
		
		for (Disciplina disciplina : disciplinas) {
			creditos += disciplina.getCreditos();
		}
		
		return creditos;
	}
	
	/**
	 * Retorna a menor quantidade de creditos do periodo
	 * @return menor quantidade de creditos do periodo
	 */
	public boolean menorCreditosRequeridos() {

		return getCreditos() < MIN_CREDITOS;
	}
}