package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.CatalogoDeDisciplinas;
import models.Disciplina;
import models.Periodo;

/**
 * classe que realiza as funções do sistema, controla o sistema
 * 
 */

// CONTROLER: SPD eh a classe responsavel por controlar o sistema
public class Sistema {

	private CatalogoDeDisciplinas grade;
	private List<Periodo> periodos;

	/**
	 * Construtor
	 */
	public Sistema() {
		try {
			grade = new CatalogoDeDisciplinas();

		} catch (IOException e) {
			e.printStackTrace();
		}

		periodos = new ArrayList<Periodo>();
		primeiroPeriodoPadrao();
	}

	/**
	 * Disciplinas do primeiro periodo que sao padrao
	 */
	private void primeiroPeriodoPadrao() {

		for (int i = 0; i < 8; i++) {
			Periodo periodo = new Periodo(i);
			getPeriodos().add(periodo);
		}

		adicionarDisciplina("ÁLGEBRA VETORIAL E GEOMETRIA ANALÍTICA", 0);
		adicionarDisciplina("CALCULO DIF E INTEGRAL I", 0);
		adicionarDisciplina("INTRODUÇÃO A COMPUTAÇÃO", 0);
		adicionarDisciplina("LABORATÓRIO DE PROGRAMAÇÃO I", 0);
		adicionarDisciplina("LEITURA E PRODUCAO DE TEXTOS", 0);
		adicionarDisciplina("PROGRAMAÇÃO I", 0);
	}

	/**
	 * Adiciona disciplina ao periodo
	 * @param nome
	 * @param idicePeriodo
	 * @return retorna se foi possivel adicionar
	 */
	public boolean adicionarDisciplina(String nome, int idicePeriodo) {

		boolean resultado = false;

		Disciplina disc = grade.procurarDisciplina(nome);
		Periodo periodo = periodos.get(idicePeriodo);

		if (grade.getRequisitosDisponiveis(disc, idicePeriodo)
				&& periodo.disciplinaDisponivel(disc)) {

			resultado = periodo.adicionarDisciplina(disc);
		}

		return resultado;
	}

	/**
	 * Retorna todos os periodos
	 * @return todos os periodos
	 */
	public List<Periodo> getPeriodos() {
		return periodos;
	}

	/**
	 * Retorna o periodo
	 * @param i
	 * @return periodo
	 */
	public Periodo getPeriodo(int i) {
		return getPeriodos().get(i);
	}

	/**
	 * Retorna a grade de disciplinas
	 * @return grade de disciplinas
	 */
	public CatalogoDeDisciplinas getGrade() {
		return grade;
	}

	/**
	 * Retorna todas as disciplinas ofertadas
	 * @return todas as disciplinas ofertadas
	 */
	public List<Disciplina> getDisciplinasOfertadas() {
		return grade.getDisciplinas();
	}

	/**
	 * Seleciona uma disciplina
	 * @param periodo
	 * @param nomeDaDisciplina
	 */
	public void selecionarDisciplina(Integer periodo, String nomeDaDisciplina) {

		Disciplina disciplina = grade.procurarDisciplina(nomeDaDisciplina);

		if (disciplina.getPeriodo() == Disciplina.NO_PERIOD) {
			adicionarDisciplina(nomeDaDisciplina, periodo - 1);
		}
	}

	/**
	 * Remove uma disciplina
	 * @param nomeDaDisciplina
	 */
	public void removerDisciplina(String nomeDaDisciplina) {

		Disciplina disc = getGrade().procurarDisciplina(nomeDaDisciplina);

		if ((disc != null) && disc.getPeriodo() != Disciplina.NO_PERIOD) {

			getPeriodo(disc.getPeriodo()).removerDisciplina(disc);
			disc.removerPeriodo();

			for (String disciplinaStr : disc.getDiscDependentes()) {

				Disciplina disciplinaDependente = getGrade().procurarDisciplina(
						disciplinaStr);

				if (disciplinaDependente != null) {
					removerDisciplina(disciplinaDependente.getNome());
				}
			}
		}
	}
}
