#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

require_relative 'BadConsequence.rb'

module NapakalakiGame
  class NumericBadConsequence < BadConsequence
    
    attr_reader :nVisibleTreasures
    attr_reader :nHiddenTreasures
    
    public_class_method:new
    
    def initialize(t, l, nVisible, nHidden)
      super(t, l)
      @nVisibleTreasures = nVisible
      @nHiddenTreasures = nHidden
    end

    
    def isEmpty
      @nVisibleTreasures == 0 && @nHiddenTreasures == 0
    end
    
    def substractVisibleTreasure(t)
      if @nVisibleTreasures > 0
        @nVisibleTreasures -= 1
      end
    end
    
    def substractHiddenTreasure(t)
      if @nHiddenTreasures > 0
        @nHiddenTreasures -= 1
      end
    end
    
    def adjustToFitTreasureLists(v, h)
      bd = nil
      minV = v.size > @nVisibleTreasures? @nVisibleTreasures : v.size
      minH = h.size > @nHiddenTreasures? @nHiddenTreasures : h.size
      bd = NumericBadConsequence.new(@text, @levels, minV, minH)
    end
  
  end
end