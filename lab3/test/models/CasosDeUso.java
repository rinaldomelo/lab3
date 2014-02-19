package models;
import static org.junit.Assert.*;

import java.io.IOException;

import models.Discipline;
import models.Periodo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.Sistema;;

public class CasosDeUso {

	private Sistema meuPlano;

	@Before
	public void setUp() throws IOException {
		meuPlano = new Sistema();
	}

	@Test
	public void periodoInicialDoCurso() {
		Periodo primeiroPeriodo = meuPlano.getPeriodo(0);

		Discipline[] disciplinas = {
				
				meuPlano.getGrid().searchDiscipline("ÁLGEBRA VETORIAL E GEOMETRIA ANALÍTICA"),
				meuPlano.getGrid().searchDiscipline("CALCULO DIF E INTEGRAL I"),
				
				meuPlano.getGrid().searchDiscipline("INTRODUÇÃO A COMPUTAÇÃO"),
				meuPlano.getGrid().searchDiscipline("LABORATÓRIO DE PROGRAMAÇÃO I"),
				
				meuPlano.getGrid().searchDiscipline("LEITURA E PRODUCAO DE TEXTOS"),
				meuPlano.getGrid().searchDiscipline("PROGRAMAÇÃO I"),
				};

		
		assertArrayEquals(disciplinas, primeiroPeriodo.getDisciplines().toArray());
		
		assertEquals(0, meuPlano.getGrid().searchDiscipline("ÁLGEBRA VETORIAL E GEOMETRIA ANALÍTICA").getPeriod());
		assertEquals(0, meuPlano.getGrid().searchDiscipline("CALCULO DIF E INTEGRAL I").getPeriod());
		assertEquals(0, meuPlano.getGrid().searchDiscipline("INTRODUÇÃO A COMPUTAÇÃO").getPeriod());
		assertEquals(0, meuPlano.getGrid().searchDiscipline("LABORATÓRIO DE PROGRAMAÇÃO I").getPeriod());
		assertEquals(0, meuPlano.getGrid().searchDiscipline("LEITURA E PRODUCAO DE TEXTOS").getPeriod());
		assertEquals(0, meuPlano.getGrid().searchDiscipline("PROGRAMAÇÃO I").getPeriod());
		
		assertEquals(24, primeiroPeriodo.getCredits());
	}

	@Test
	public void addNewDisciplines() {
		
		Periodo periodo = meuPlano.getPeriodo(1);
		Discipline[] disciplinasVazio = {};

		assertEquals(0, periodo.getCredits());
		assertArrayEquals(disciplinasVazio, periodo.getDisciplines().toArray());
		assertTrue(periodo.lessCreditsRequired());
		try {
			meuPlano.addDiscipline("CALCULO DIFERENCIAL E INTEGRAL II",2);
			meuPlano.addDiscipline( "FUNDAMENTOS DE FÍSICA CLÁSSICA",2);
			meuPlano.addDiscipline( "LABORATÓRIO DE PROGRAMAÇÃO II",2);
			meuPlano.addDiscipline( "MATEMÁTICA DISCRETA",2);
			meuPlano.addDiscipline( "PROGRAMAÇÃO II",2);
			meuPlano.addDiscipline( "TEORIA DOS GRAFOS",2);
			meuPlano.addDiscipline( "METODOLOGIA CIENTÍFICA",2);
		} catch (Exception e) {
			
			Assert.fail();
		}

		}

}