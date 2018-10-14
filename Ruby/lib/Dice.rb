#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

#encoding: utf-8

module NapakalakiGame
  class Dice
    
    include Singleton
    
    private_class_method:new

    def initialize
      
    end
    
    def nextNumber()
      rand(6) + 1
    end
    
  end
end
