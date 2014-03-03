// @SOURCE:C:/Users/Leticia/git/lab3/lab3/conf/routes
// @HASH:3b9f7b915a80457c79ee0f920c5bd133890d5d51
// @DATE:Sun Mar 02 20:10:40 GMT-03:00 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:13
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def recomecar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reiniciar")
}
                                                

// @LINE:8
def removerDisciplina(name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "desalocarDisciplina/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:7
def disciplinaSelecionada(period:Integer, name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "alocarDisciplina/" + implicitly[PathBindable[Integer]].unbind("period", period) + "/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                                                
    
}
                          
}
                  


// @LINE:13
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def recomecar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.recomecar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reiniciar"})
      }
   """
)
                        

// @LINE:8
def removerDisciplina : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.removerDisciplina",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "desalocarDisciplina/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def disciplinaSelecionada : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.disciplinaSelecionada",
   """
      function(period,name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "alocarDisciplina/" + (""" + implicitly[PathBindable[Integer]].javascriptUnbind + """)("period", period) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        
    
}
              
}
        


// @LINE:13
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:13
class ReverseAssets {
    

// @LINE:13
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:9
def recomecar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.recomecar(), HandlerDef(this, "controllers.Application", "recomecar", Seq(), "GET", """""", _prefix + """reiniciar""")
)
                      

// @LINE:8
def removerDisciplina(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.removerDisciplina(name), HandlerDef(this, "controllers.Application", "removerDisciplina", Seq(classOf[String]), "GET", """""", _prefix + """desalocarDisciplina/$name<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:7
def disciplinaSelecionada(period:Integer, name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.disciplinaSelecionada(period, name), HandlerDef(this, "controllers.Application", "disciplinaSelecionada", Seq(classOf[Integer], classOf[String]), "GET", """""", _prefix + """alocarDisciplina/$period<[^/]+>/$name<[^/]+>""")
)
                      
    
}
                          
}
        
    