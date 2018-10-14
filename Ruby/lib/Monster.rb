#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#


require_relative 'Prize.rb'
require_relative 'BadConsequence.rb'

module NapakalakiGame
  class Monster

    attr_reader :name
    attr_reader :combatLevel
    attr_reader :badConsequence
    
    private_class_method:new
    def initialize(n, l, b, p, lC)
      @name = n
      @combatLevel = l
      @badConsequence = b
      @prize = p
      @levelChangeAgainstCultistPlayer = lC
    end
    
    def self.newMonster(n, l, b, p)
      new(n, l, b, p, 0)
    end
    
    def self.newCultistMonster(n, l, b, p, lC)
      new(n, l, b, p, lC)
    end
    
    def getLevelsGained()
      @prize.levels
    end
    
    def getTreasuresGained()
      @prize.treasures
    end
    
    def getCombatLevelAgainstCultistPlayer()
      @combatLevel + @levelChangeAgainstCultistPlayer
    end
    
    def to_s()
      @name + " (#{@combatLevel}) \n\n\tMal rollo: #{@badConsequence} \n\tBuen rollo: #{@prize}\n\n"
    end
    
  end
end
