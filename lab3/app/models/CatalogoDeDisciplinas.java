package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * classe que guarda todas as disciplinas do curso
 * 
 */

// CREATOR: a classe será a responsável por criar as
// disciplinas e guarda-las. Tambem respeita o information expert pois eh ela
// que deve conter as informações para essa criação.

public class CatalogoDeDisciplinas {

	private List<Disciplina> disciplinas;
	
	/**
	 * Construtor
	 * @throws IOException
	 */
	
	public CatalogoDeDisciplinas() throws IOException {

		disciplinas = new ArrayList<Disciplina>();
		carregaDisciplinas();
	}

	/**
	 * Carrega as disciplinas de um arquivo
	 * @throws IOException
	 */
	private void carregaDisciplinas() throws IOException {

		String diretorio = new File("resources/disciplinesGrid.txt")
				.getCanonicalPath();
		BufferedReader leitor = new BufferedReader(new FileReader(new File(
				diretorio)));

		while (leitor.ready()) {

			String[] info = leitor.readLine().split(":");
			String nome = info[0];
			String[] dependentes = {};
			String[] requisitos = {};
			String creditos = info[3];

			if (!info[1].equals("---")) {
				dependentes = info[1].split(",");
			}
			if (!info[2].equals("---")) {
				requisitos = info[2].split(",");
			}

			disciplinas.add(new Disciplina(nome, Integer.parseInt(creditos),
					dependentes, requisitos));
		}

		leitor.close();
	}
	
	/**
	 * Retorna as disciplinas selecionadas
	 * @param nome
	 * @return disciplinas selecionadas
	 */
	private List<Disciplina> getDisciplinasSelecionadas(String nome) {

		List<Disciplina> disciplinasSelecionadas = new ArrayList<Disciplina>();

		for (Disciplina disciplina : disciplinas) {

			if (!disciplina.getNome().equals(nome) && disciplina.ehSelecionado()) {
				disciplinasSelecionadas.add(disciplina);
			}
		}

		return disciplinasSelecionadas;
	}

	/**
	 * Retorna as disciplinas dependentes de alguma outra
	 * @param nome
	 * @return as disciplinas dependentes de alguma outra
	 */
	public List<Disciplina> getDependentesDe(String nome) {

		Disciplina disciplina = procurarDisciplina(nome);
		desfazerSelecionarDisciplinas();
		visitaDependentes(disciplina);

		return getDisciplinasSelecionadas(nome);
	}

	/**
	 * Visualiza as disiciplinas dependentes
	 * @param disciplinaAtual
	 */
	private void visitaDependentes(Disciplina disciplinaAtual) {
		disciplinaAtual.selecionadoTrue();

		for (String disciplina : disciplinaAtual.getDiscDependentes()) {

			Disciplina proxima = procurarDisciplina(disciplina);

			if (proxima != null && !proxima.ehSelecionado()) {
				visitaDependentes(proxima);
			}
		}
	}

	/**
	 * Retorna as disiciplinas que sao requisitos de alguma outra
	 * @param nome
	 * @return as disiciplinas que sao requisitos de alguma outra
	 */
	public List<Disciplina> getRequisitosDe(String nome) {

		Disciplina disciplina = procurarDisciplina(nome);
		desfazerSelecionarDisciplinas();
		requisitosSelecionados(disciplina);
		return getDisciplinasSelecionadas(nome);
	}

	/**
	 * Mostra as disciplinas que sao requisitos e foram selecionadas
	 * @param disciplinaAtual
	 */
	private void requisitosSelecionados(Disciplina disciplinaAtual) {

		disciplinaAtual.selecionadoTrue();

		for (String disciplina : disciplinaAtual.getDiscRequisitos()) {

			Disciplina proxima = procurarDisciplina(disciplina);

			if (proxima != null && !proxima.ehSelecionado()) {
				requisitosSelecionados(proxima);
			}
		}
	}

	/**
	 * Procura uma disciplina pelo seu nome
	 * @param nome
	 * @return uma disciplina caso encontre-a
	 */
	public Disciplina procurarDisciplina(String nome) {

		for (Disciplina disciplina : disciplinas) {

			if (disciplina.getNome().equals(nome))
				return disciplina;
		}

		return null;
	}

	/**
	 * Retorna as disciplinas
	 * @return disciplinas
	 */
	public List<Disciplina> getDisciplinas() {

		return disciplinas;
	}

	/**
	 * Retorna os requisitos disponiveis
	 * @param disc
	 * @param periodoID
	 * @return requisitos disponiveis
	 */
	public boolean getRequisitosDisponiveis(Disciplina disc, int periodoID) {

		List<Disciplina> requisitos = getRequisitosDe(disc.getNome());

		for (Disciplina requisito : requisitos) {
			if ((requisito.getPeriodo() == Disciplina.NO_PERIOD)
					|| (requisito.getPeriodo() >= periodoID))
				return false;
		}

		return true;
	}

	/**
	 * Desfaz a selecao de uma disciplina
	 */
	private void desfazerSelecionarDisciplinas() {

		for (Disciplina disc : disciplinas) {

			disc.selecionadoFalse();
		}
	}
}