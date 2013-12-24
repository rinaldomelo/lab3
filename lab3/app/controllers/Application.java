package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
public class Application extends Controller {

	// Sistema de Planejamento da Graduação
	public static Sistema gradeDePlanejamento = new Sistema();
	
    public static Result index() {
        return ok(index.render(gradeDePlanejamento.getPeriodos()));
    }
    
    public static Result disciplinaSelecionada(Integer periodo, String nomeDaDisciplina) {
    	gradeDePlanejamento.selecionarDisciplina(periodo, nomeDaDisciplina);
    	
    	return redirect("/");
    }
    
    public static Result removerDisciplina(String nomeDaDisciplina) {
    	gradeDePlanejamento.removerDisciplina(nomeDaDisciplina);
    	
    	return redirect("/");
    }

    public static Result recomecar() {
    	gradeDePlanejamento = new Sistema();
    	
    	return redirect("/");
    }
}
