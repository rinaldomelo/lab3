// @SOURCE:C:/Users/Leticia/git/lab3/lab3/conf/routes
// @HASH:3b9f7b915a80457c79ee0f920c5bd133890d5d51
// @DATE:Sun Mar 02 20:10:40 GMT-03:00 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_disciplinaSelecionada1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("alocarDisciplina/"),DynamicPart("period", """[^/]+""",true),StaticPart("/"),DynamicPart("name", """[^/]+""",true))))
        

// @LINE:8
private[this] lazy val controllers_Application_removerDisciplina2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("desalocarDisciplina/"),DynamicPart("name", """[^/]+""",true))))
        

// @LINE:9
private[this] lazy val controllers_Application_recomecar3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("reiniciar"))))
        

// @LINE:13
private[this] lazy val controllers_Assets_at4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """alocarDisciplina/$period<[^/]+>/$name<[^/]+>""","""controllers.Application.disciplinaSelecionada(period:Integer, name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """desalocarDisciplina/$name<[^/]+>""","""controllers.Application.removerDisciplina(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """reiniciar""","""controllers.Application.recomecar()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_disciplinaSelecionada1(params) => {
   call(params.fromPath[Integer]("period", None), params.fromPath[String]("name", None)) { (period, name) =>
        invokeHandler(controllers.Application.disciplinaSelecionada(period, name), HandlerDef(this, "controllers.Application", "disciplinaSelecionada", Seq(classOf[Integer], classOf[String]),"GET", """""", Routes.prefix + """alocarDisciplina/$period<[^/]+>/$name<[^/]+>"""))
   }
}
        

// @LINE:8
case controllers_Application_removerDisciplina2(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(controllers.Application.removerDisciplina(name), HandlerDef(this, "controllers.Application", "removerDisciplina", Seq(classOf[String]),"GET", """""", Routes.prefix + """desalocarDisciplina/$name<[^/]+>"""))
   }
}
        

// @LINE:9
case controllers_Application_recomecar3(params) => {
   call { 
        invokeHandler(controllers.Application.recomecar(), HandlerDef(this, "controllers.Application", "recomecar", Nil,"GET", """""", Routes.prefix + """reiniciar"""))
   }
}
        

// @LINE:13
case controllers_Assets_at4(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     