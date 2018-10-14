#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#


module NapakalakiGame
  class BadConsequence

    attr_reader :text
    attr_reader :levels
    
    # No hace falta poner attr_reader para @@MAXTREASURES porque el funcionamiento  
    # de las variables de clase en ruby es diferente a las variables de instancia.
    # Para consultar su valor: BadConsequence.class_variable_get(:@@MAXTREASURES)
    @@MAXTREASURES = 10
    
    private_class_method:new

    def initialize(t, l)
        @text = t
        @levels = l
    end
    
    def isEmpty()
      raise NotImplementedError.new
    end
    
    def substractVisibleTreasure(t)
      raise NotImplementedError.new
    end
    
    def substractHiddenTreasure(t)
      raise NotImplementedError.new
    end
    
    def adjustToFitTreasureLists(v, h)
      raise NotImplementedError.new
    end
    
    def to_s
      @text
    end
    
  end
end
