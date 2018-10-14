#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

require 'singleton'
require_relative 'Monster.rb'
require_relative 'CardDealer.rb'
require_relative 'Player.rb'
require_relative 'CombatResult.rb'

module NapakalakiGame
  class Napakalaki
    
    include Singleton
    
    private_class_method:new
    
    attr_reader :currentPlayer
    attr_reader :currentMonster
    
    def initialize
      @dealer = CardDealer.instance
    end
    
    private
    def initPlayers(names)
      @players = Array.new
      for i in names  
        @players << Player.new(i)
      end
      
      # Inicializamos currentPlayer, evitando que el primer nextTurn falle
      @currentPlayer = @players[rand(@players.length)]
    end
    
    def nextPlayer()
      # La inicialización de currentPlayer se hace en initPlayers
      # para evitar su comprobación cada vez que pasamos turno
      @players[(@players.index(@currentPlayer)+1) % @players.length]
    end
    
    def nextTurnAllowed()
      @currentPlayer.validState
    end
    
    def setEnemies()
      for j in @players
        
        begin
          enemy = @players[rand(@players.length)]
        end while (j == enemy)
        
        j.enemy = enemy
      end
    end
    
    public
    def developCombat() 
      combatResult = @currentPlayer.combat(@currentMonster)
      CardDealer.instance.giveMonsterBack(@currentMonster)
      combatResult
    end
    
    def discardVisibleTreasures(treasures)
      for i in treasures
        @currentPlayer.discardVisibleTreasure(i)
        CardDealer.instance.giveTreasureBack(i)
      end
    end
    
    def discardHiddenTreasures(treasures)
      for i in treasures
        @currentPlayer.discardHiddenTreasure(i)
        CardDealer.instance.giveTreasureBack(i)
      end
    end
    
    def makeTreasuresVisible(treasures)
      for t in treasures
        @currentPlayer.makeTreasureVisible(t)
      end
    end
    
    def initGame(players)
      initPlayers(players)
      setEnemies()
      @dealer.initCards
      nextTurn()
    end
    
    def nextTurn()
      valido = nextTurnAllowed
      
      if (valido)
        @currentMonster = CardDealer.instance.nextMonster
        @currentPlayer = nextPlayer
        
        if (@currentPlayer.dead)
          @currentPlayer.initTreasures
        end
      end
      
      valido
    end
    
    def endOfGame(result)
      result == CombatResult::WINGAME
    end
      
  end
end
