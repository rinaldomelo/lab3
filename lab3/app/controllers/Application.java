package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

	public static Sistema gradePlanning = new Sistema();
	
    public static Result index() {
        return ok(index.render(gradePlanning.getPeriods()));
    }
    
    public static Result selectDiscipline(Integer periodo, String nomeDaDisciplina) {
    	gradePlanning.selectDiscipline(periodo, nomeDaDisciplina);
    	
    	return redirect("/");
    }
    
    public static Result removeDiscipline(String nomeDaDisciplina) {
    	gradePlanning.removeDiscipline(nomeDaDisciplina);
    	
    	return redirect("/");
    }

    public static Result restart() {
    	gradePlanning = new Sistema();
    	
    	return redirect("/");
    }
}
