
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html style="height: 100%;">
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/jquery.gritter.css"))),format.raw/*9.104*/("""">
        
        <!-- begin bootstrap css -->
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*12.54*/routes/*12.60*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*12.99*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*13.54*/routes/*13.60*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*13.103*/("""">
       	<link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*14.54*/routes/*14.60*/.Assets.at("stylesheets/bootstrap-theme.min.css"))),format.raw/*14.109*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*15.54*/routes/*15.60*/.Assets.at("stylesheets/bootstrap-theme.css"))),format.raw/*15.105*/("""">
        <!-- end bootstrap css -->
        
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*18.59*/routes/*18.65*/.Assets.at("images/favicon.png"))),format.raw/*18.97*/("""">
        <script src=""""),_display_(Seq[Any](/*19.23*/routes/*19.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*19.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*20.23*/routes/*20.29*/.Assets.at("javascripts/jquery-ui-1.10.3.custom.min.js"))),format.raw/*20.85*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*21.23*/routes/*21.29*/.Assets.at("javascripts/jquery.gritter.min.js"))),format.raw/*21.76*/("""" type="text/javascript"></script>

        <!-- begin bootstrap js -->
        <script src=""""),_display_(Seq[Any](/*24.23*/routes/*24.29*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*24.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*25.23*/routes/*25.29*/.Assets.at("javascripts/bootstrap.js"))),format.raw/*25.67*/("""" type="text/javascript"></script>
        <!-- begin bootstrap js -->
    </head>
    <body class="body-back" style="height: 100%;">
		"""),_display_(Seq[Any](/*29.4*/content)),format.raw/*29.11*/("""
	</body>
</html>"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Mar 02 20:10:47 GMT-03:00 2014
                    SOURCE: C:/Users/Leticia/git/lab3/lab3/app/views/main.scala.html
                    HASH: 4ea47264c2132ee027b8727b9338eb1eebf3083a
                    MATRIX: 778->1|902->31|1012->106|1038->111|1135->173|1149->179|1204->213|1295->269|1309->275|1375->319|1513->421|1528->427|1589->466|1681->522|1696->528|1762->571|1854->627|1869->633|1941->682|2033->738|2048->744|2116->789|2257->894|2272->900|2326->932|2387->957|2402->963|2469->1008|2562->1065|2577->1071|2655->1127|2748->1184|2763->1190|2832->1237|2962->1331|2977->1337|3041->1379|3134->1436|3149->1442|3209->1480|3381->1617|3410->1624
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|40->12|40->12|40->12|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|46->18|46->18|46->18|47->19|47->19|47->19|48->20|48->20|48->20|49->21|49->21|49->21|52->24|52->24|52->24|53->25|53->25|53->25|57->29|57->29
                    -- GENERATED --
                */
            