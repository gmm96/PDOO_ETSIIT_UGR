#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

require_relative 'Cultist.rb'
require_relative 'Player.rb'


module NapakalakiGame
  class CultistPlayer < Player
    
    @@totalCultistPlayers = 0
    
    def initialize(p, c)
      super(p.name)
      @level = p.level
      @dead = p.dead
      @canISteal = p.canISteal
      @hiddenTreasures = p.hiddenTreasures
      @visibleTreasures = p.visibleTreasures
      @enemy = p.enemy
      @pendingBadConsequence = p.pendingBadConsequence
      @myCultistCard = c
      @totalCultistPlayers += 1
    end
    
    protected
    def getOponentLevel(m)
      m.getCombatLevelAgainstCultistPlayer
    end
    
    def shouldConvert()
      false
    end
    
    def getCombatLevel()
      (super * 1.2 + @myCultistCard.gainedLevels).floor
    end
    
    def giveMeATreasure()
      @visibleTreasures.delete_at(rand(@visibleTreasures.length))
    end
    
    def canYouGiveMeATreasure()
      !@visibleTreasures.empty?
    end
    
  end
end
