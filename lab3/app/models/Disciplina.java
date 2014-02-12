package models;

import java.util.ArrayList;
import java.util.List;

/**
 * classe que representa uma disciplina
 */

//Information Expert: Cada disciplina é quem deve conhecer seus pre-requisitos.
public class Disciplina implements Comparable<Disciplina> {

	public static int NO_PERIOD = -1;
	private int periodoEscolhido;
	
	private List<String> dependentes; 
	private List<String> requisitos;
	
	private String nome;
	private boolean selecionado;
	private int creditos;
	
	/**
	 * Construtor
	 * @param nome
	 * @param creditos
	 * @param listaDependentes
	 * @param listaRequisitos
	 */
	public Disciplina(String nome, int creditos, String[] listaDependentes, String[] listaRequisitos) {
		
		this.nome = nome;
		selecionado = false;
		requisitos = new ArrayList<String>();
		dependentes = new ArrayList<String>();
		this.creditos = creditos;
		periodoEscolhido = NO_PERIOD;
		
		for (String disc : listaDependentes) {
			
			dependentes.add(disc);
		}
		
		for (String disciplina : listaRequisitos) {
			
			requisitos.add(disciplina);
		}
	}

	/**
	 * Retorna o nome da disciplina
	 * @return nome da disciplina
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna se uma disciplina foi selecionada
	 * @return disiciplina eh ou nao selecionada
	 */
	public boolean ehSelecionado() {
		return selecionado;
	}
	
	/**
	 * Disciplina nao foi selecionada
	 */
	public void selecionadoFalse() {
		selecionado = false;
	}

	/**
	 * Disciplina foi selecionada
	 */
	public void selecionadoTrue() {
		selecionado = true;
	}

	/**
	 * Retorna disciplinas dependentes
	 * @return disciplinas dependentes
	 */
	public List<String> getDiscDependentes() {
		return dependentes;
	}

	/**
	 * Retorna disciplinas que sao requisitos
	 * @return disciplinas que sao requisitos
	 */
	public List<String> getDiscRequisitos() {
		return requisitos;
	}	
	
	/**
	 * Retorna os creditos da disciplina
	 * @return os creditos da disciplina
	 */
	public int getCreditos() {
		return creditos;
	}
	
	/**
	 * Escolhe o periodo
	 * @param periodo
	 */
	public void escolherPeriodo(int periodo) {
		periodoEscolhido = periodo;
	}

	/**
	 * Remove o periodo
	 */
	public void removerPeriodo() {
		periodoEscolhido = NO_PERIOD;
	}
	
	/**
	 * Retorna o periodo da disciplina
	 * @return o periodo da disciplina
	 */
	public int getPeriodo() {
		return periodoEscolhido;
	}

	/**
	 * Compara duas disciplinas pelo nome
	 */
	@Override
	public int compareTo(Disciplina disciplina) {
		
		return nome.compareTo(disciplina.getNome());
	}
	
	@Override
	public boolean equals(Object object) {
		
		boolean result = true;

		if (object == null || getClass() != object.getClass()){
			result = false;
		}
		Disciplina other = (Disciplina) object;

		if (nome == null) {
			if (other.nome != null) { 
				result = false; }
			
		} else if (!nome.equals(other.nome))
			result = false;
		
		return result;
	}
}