
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Periodo],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(periodos: List[Periodo]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._ 


Seq[Any](format.raw/*1.27*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Planejamento de Curso")/*5.31*/ {_display_(Seq[Any](format.raw/*5.33*/("""
<script>
    $(function() """),format.raw/*7.18*/("""{"""),format.raw/*7.19*/("""
        $(".disciplina").draggable("""),format.raw/*8.36*/("""{"""),format.raw/*8.37*/("""
            revert: "invalid"
        """),format.raw/*10.9*/("""}"""),format.raw/*10.10*/(""");

        $( ".coluna" ).droppable("""),format.raw/*12.34*/("""{"""),format.raw/*12.35*/("""
            drop: function( event, ui ) """),format.raw/*13.41*/("""{"""),format.raw/*13.42*/("""
                var disciplina = ui.draggable[0].id;
            	var periodo = event.target.id.replace('periodo_', '');
            	
                location.href = '/alocarDisciplina/' + periodo + '/' + disciplina;
            """),format.raw/*18.13*/("""}"""),format.raw/*18.14*/("""
        """),format.raw/*19.9*/("""}"""),format.raw/*19.10*/(""");

        $( "#disciplinas" ).droppable("""),format.raw/*21.39*/("""{"""),format.raw/*21.40*/("""
            drop: function( event, ui ) """),format.raw/*22.41*/("""{"""),format.raw/*22.42*/("""
                var disciplina = ui.draggable[0].id;
            	
                location.href = '/desalocarDisciplina/' + disciplina;
            """),format.raw/*26.13*/("""}"""),format.raw/*26.14*/("""
        """),format.raw/*27.9*/("""}"""),format.raw/*27.10*/(""");
    """),format.raw/*28.5*/("""}"""),format.raw/*28.6*/(""");
</script>

<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav"
    role="banner">
    <div class="navbar-inverse">
        <div class="container">
            <div class="navbar-header" >
                <a href="/" class="navbar-brand">Home</a>
            </div>
            <nav class="collapse navbar-collapse bs-navbar-collapse"
                role="navigation">
                  <ul class="nav navbar-nav">
                    <li><a href="">Ajuda</a></li>
                    <li><a href="">Dicas</a></li>
                    <li><a href="">Overview</a></li>
                    <li><a href="">Colabore</a></li>
                </ul>  
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/reiniciar">Reiniciar</a></li>
                </ul>
            </nav>
        </div>
    </div> 
</header> 

<div class="wrapper" style="height: 100%;">
    <br/>    
    <div id="colunas">
        <div class="titulo">
            <nome-principal>PLANO DE CURSO</nome-principal>
        </div>
        """),_display_(Seq[Any](/*60.10*/for((periodo, i) <- periodos.zipWithIndex) yield /*60.52*/ {_display_(Seq[Any](format.raw/*60.54*/("""
            <div id="periodo_"""),_display_(Seq[Any](/*61.31*/(i + 1))),format.raw/*61.38*/("""" class="coluna">
            <nome-periodo>Período """),_display_(Seq[Any](/*62.36*/(1 + periodos.indexOf(periodo)))),format.raw/*62.67*/("""</nome-periodo>
            """),_display_(Seq[Any](/*63.14*/for(disciplina <- periodo.getDisciplinas()) yield /*63.57*/{_display_(Seq[Any](format.raw/*63.58*/("""
                <div class="disciplina" id=""""),_display_(Seq[Any](/*64.46*/disciplina/*64.56*/.getNome())),format.raw/*64.66*/("""">
                    <nome>"""),_display_(Seq[Any](/*65.28*/disciplina/*65.38*/.getNome())),format.raw/*65.48*/("""</nome><br/>
                    <descricao>"""),_display_(Seq[Any](/*66.33*/disciplina/*66.43*/.getCreditos())),format.raw/*66.57*/(""" créditos</descricao>
                </div>
            """)))})),format.raw/*68.14*/("""
            <h3> """),_display_(Seq[Any](/*69.19*/periodo/*69.26*/.getCreditos())),format.raw/*69.40*/(""" créditos </h3> <br>
            """),_display_(Seq[Any](/*70.14*/if(periodo.menorCreditosRequeridos())/*70.51*/ {_display_(Seq[Any](format.raw/*70.53*/("""
                Abaixo dos créditos mínimos.
            """)))})),format.raw/*72.14*/("""
            </div>
            
        """)))})),format.raw/*75.10*/("""

    </div>
    <br/>    
    <div id="disciplinas">
        <div class="titulo">
            <nome-principal>DISCIPLINAS OFERTADAS</nome-principal>
        </div>
        """),_display_(Seq[Any](/*83.10*/for(disciplina <- Application.gradeDePlanejamento.getDisciplinasOfertadas()) yield /*83.86*/ {_display_(Seq[Any](format.raw/*83.88*/("""
            """),_display_(Seq[Any](/*84.14*/if(disciplina.getPeriodo() == -1)/*84.47*/ {_display_(Seq[Any](format.raw/*84.49*/("""
                <div class="disciplina float-left" id=""""),_display_(Seq[Any](/*85.57*/disciplina/*85.67*/.getNome())),format.raw/*85.77*/("""">
                    <nome>"""),_display_(Seq[Any](/*86.28*/disciplina/*86.38*/.getNome())),format.raw/*86.48*/("""</nome><br/>
                    <descricao>"""),_display_(Seq[Any](/*87.33*/disciplina/*87.43*/.getCreditos())),format.raw/*87.57*/(""" créditos</descricao>
                </div>
            """)))})),format.raw/*89.14*/("""
        """)))})),format.raw/*90.10*/("""
    </div>
</div>
""")))})))}
    }
    
    def render(periodos:List[Periodo]): play.api.templates.HtmlFormat.Appendable = apply(periodos)
    
    def f:((List[Periodo]) => play.api.templates.HtmlFormat.Appendable) = (periodos) => apply(periodos)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 02 20:10:47 GMT-03:00 2014
                    SOURCE: C:/Users/Leticia/git/lab3/lab3/app/views/index.scala.html
                    HASH: b3ca9b38ed2ac6fabbc6290feb259c26b8a8653e
                    MATRIX: 781->1|917->26|945->46|981->48|1018->77|1057->79|1111->106|1139->107|1202->143|1230->144|1296->183|1325->184|1390->221|1419->222|1488->263|1517->264|1776->495|1805->496|1841->505|1870->506|1940->548|1969->549|2038->590|2067->591|2245->741|2274->742|2310->751|2339->752|2373->759|2401->760|3495->1818|3553->1860|3593->1862|3660->1893|3689->1900|3778->1953|3831->1984|3896->2013|3955->2056|3994->2057|4076->2103|4095->2113|4127->2123|4193->2153|4212->2163|4244->2173|4325->2218|4344->2228|4380->2242|4470->2300|4525->2319|4541->2326|4577->2340|4647->2374|4693->2411|4733->2413|4824->2472|4898->2514|5108->2688|5200->2764|5240->2766|5290->2780|5332->2813|5372->2815|5465->2872|5484->2882|5516->2892|5582->2922|5601->2932|5633->2942|5714->2987|5733->2997|5769->3011|5859->3069|5901->3079
                    LINES: 26->1|30->1|32->4|33->5|33->5|33->5|35->7|35->7|36->8|36->8|38->10|38->10|40->12|40->12|41->13|41->13|46->18|46->18|47->19|47->19|49->21|49->21|50->22|50->22|54->26|54->26|55->27|55->27|56->28|56->28|88->60|88->60|88->60|89->61|89->61|90->62|90->62|91->63|91->63|91->63|92->64|92->64|92->64|93->65|93->65|93->65|94->66|94->66|94->66|96->68|97->69|97->69|97->69|98->70|98->70|98->70|100->72|103->75|111->83|111->83|111->83|112->84|112->84|112->84|113->85|113->85|113->85|114->86|114->86|114->86|115->87|115->87|115->87|117->89|118->90
                    -- GENERATED --
                */
            