import scala.collection.immutable._

trait Shoulda {
  var contexts = new Stack[Context]()
  class Context(val msg:String) {
    var parent:Context = _
    def pushContext(ctx:Context) {
      if(!contexts.isEmpty) { this.parent = contexts.top }
      contexts = contexts push this      
    }
    
    def popContext = contexts pop
    
    def /(block: => Unit) = {
        pushContext(this)
        block
        popContext
    }

    def info:String = {
      if(parent == null) msg
      else parent.info + " " + msg
    }
    
  }
  
  object context {
    def / (ctx:String) = new Context(ctx)
  }
  
  class Should(val ctx:Context, val msg:String) {
    def /(block: => Unit) = {
      println("test: " + ctx.info + " " + msg)
      block
    }
  }

  object should {
    def / (msg:String) = new Should(contexts.top, msg)
  }

}

