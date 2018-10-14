#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

require_relative 'BadConsequence.rb'
require_relative 'TreasureKind.rb'


module NapakalakiGame
  class SpecificBadConsequence < BadConsequence
    
    attr_reader :specificVisibleTreasures
    attr_reader :specificHiddenTreasures
    
    public_class_method:new
    
    def initialize(t, l, sVisible, sHidden)
      super(t, l)
      @specificVisibleTreasures = sVisible
      @specificHiddenTreasures = sHidden
    end
  
    def isEmpty
      @specificVisibleTreasures.empty? && @specificHiddenTreasures.empty?
    end
    
    def substractVisibleTreasure(t)
      if @specificVisibleTreasures.size > 0
        @specificVisibleTreasures.delete_at(@specificVisibleTreasures.index(t.type))
      end
    end
    
    def substractHiddenTreasure(t)
      if @specificHiddenTreasures.size > 0
        @specificHiddenTreasures.delete_at(@specificHiddenTreasures.index(t.type))
      end
    end
    
    def adjustToFitTreasureLists(v, h)
      bd = nil
      interV = intersection(@specificVisibleTreasures, v) 
      interH = intersection(@specificHiddenTreasures, h)
      bd = SpecificBadConsequence.new(@text,@levels,interV,interH)
    end
    
    private
    def intersection(arrayTK, arrayTreasure)  # necesita ambos vectores para crear un método general
      salida = Array.new
      
      if !arrayTK.empty? && !arrayTreasure.empty?
        aux = arrayTK.clone   # Copia vector TK de BadConsequence
        for elemento in arrayTreasure
          unless (i = aux.index(elemento.type)) == nil
            salida << aux.delete_at(i)
          end 
        end
      end
      
      salida
    end
    
  end
end