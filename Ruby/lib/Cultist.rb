#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

module NapakalakiGame
  class Cultist
    
    attr_reader :gainedLevels
    
    def initialize (name, gainedLevels)
      @name = name
      @gainedLevels = gainedLevels      
    end
    
  end
end
