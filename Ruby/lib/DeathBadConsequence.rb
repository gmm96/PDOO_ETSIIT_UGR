#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

require_relative 'NumericBadConsequence.rb'

module NapakalakiGame
  class DeathBadConsequence < NumericBadConsequence
    
    public_class_method:new
    
    def initialize(t, l)
      super(t, Player.class_variable_get(:@@MAXLEVEL), BadConsequence.class_variable_get(:@@MAXTREASURES), BadConsequence.class_variable_get(:@@MAXTREASURES))
    end
  
  end
end

