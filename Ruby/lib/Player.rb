#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

require_relative 'Treasure.rb'
require_relative 'BadConsequence.rb'
require_relative 'Dice.rb'
require_relative 'TreasureKind.rb'

module NapakalakiGame
  class Player
    
    #class << self
    #end
    
    attr_reader :name
    attr_reader :level
    attr_reader :dead
    attr_reader :visibleTreasures
    attr_reader :hiddenTreasures
    attr_reader :canISteal
    
    attr_writer :enemy
    attr_writer :pendingBadConsequence
    
    # No hace falta poner attr_reader para @@MAXLEVEL porque el funcionamiento  
    # de las variables de clase en ruby es diferente a las variables de instancia.
    # Para consultar su valor: Player.class_variable_get(:@@MAXLEVEL)
    @@MAXLEVEL = 10

    
    def initialize(name)
      @name = name
      @level = 1
      @dead = true
      @canISteal = true
      @hiddenTreasures = Array.new
      @visibleTreasures = Array.new
    end
    
    def self.crearCopia(p)
      new(p.name)
      @level = p.level
      @dead = p.dead
      @canISteal = p.canISteal
      @hiddenTreasures = p.hiddenTreasures
      @visibleTreasures = p.visibleTreasures
    end
    
    protected
    def getOponentLevel(m)
      m.combatLevel
    end
    
    def shouldConvert()
      dice = Dice.instance
      dice.nextNumber == 1
    end
    
    def getCombatLevel()
      combatlevel = @level
      
      for i in @visibleTreasures
        combatlevel += i.bonus
      end
       
      combatlevel
    end
    
    private
    def bringToLife()
      @dead = false
    end
    
    def incrementLevels(l)
      @level += l
      
      if(@level > @@MAXLEVEL)
        @level = @@MAXLEVEL
      end
    end
    
    def decrementLevels(l)
      @level -= l
      
      if(@level < 1)
        @level = 1
      end
    end
    
    def applyPrize(m)
      incrementLevels(m.getLevelsGained)
      
      if (m.getTreasuresGained > 0)
        for i in 0..m.getTreasuresGained
          @hiddenTreasures << CardDealer.instance.nexTreasure
        end
      end
      
    end
    
    def applyBadConsequence(m)
      bc = m.badConsequence
      decrementLevels(bc.levels)
      @pendingBadConsequence = bc.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
    end
    
    def canMakeTreasureVisible(t)
      condicion = true
      
      case t.type
      when TreasureKind::BOTHHANDS
        i = 0
        
        while (condicion && i<@visibleTreasures.length) do
          if (@visibleTreasures[i].type==TreasureKind::BOTHHANDS ||
              @visibleTreasures[i].type==TreasureKind::ONEHAND)
            condicion = false
          else
            i+=1
          end
        end
      
      when TreasureKind::ONEHAND
        i = 0
        tiene_onehand = false
        
        while (condicion && i<@visibleTreasures.length) do
          if (@visibleTreasures[i].type==TreasureKind::BOTHHANDS)
            condicion = false
          elsif (@visibleTreasures[i].type==TreasureKind::ONEHAND)
            if(tiene_onehand)
              condicion = false
            else
              tiene_onehand = true
              i += 1
            end
          else
            i+=1
          end
        end
        
      else
        i = 0
        
        while (condicion && i<@visibleTreasures.length) do
          if (t.type==@visibleTreasures[i].type)
            condicion = false
          else
            i+=1
          end
        end
        
      end
              
      condicion
    end

    def howManyVisibleTreasures(tKind)
      contador = 0
      
      for i in @visibleTreasures
        contador += 1 if (i.type == tKind)
      end
      
      contador
    end
    
    def dieIfNoTreasures()
      @dead = true if(@visibleTreasures.empty? && @hiddenTreasures.empty?)
    end
    
    public    
    def combat(m)
      if getCombatLevel() > getOponentLevel(m)
        
        applyPrize(m)
        
        if @level >= @@MAXLEVEL
          CombatResult::WINGAME
        else
          CombatResult::WIN
        end
        
      else
        applyBadConsequence(m)
        
        if(shouldConvert)
          CombatResult::LOSEANDCONVERT
        else
          CombatResult::LOSE
        end
        
      end
    end
    
    def makeTreasureVisible(t)
      if canMakeTreasureVisible(t)
        @visibleTreasures << t
        @hiddenTreasures.delete_at(@hiddenTreasures.index(t))
      end
    end
    
    def discardVisibleTreasure(t)
      @visibleTreasures.delete_at(@visibleTreasures.index(t))
      if (@pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty)
        @pendingBadConsequence.substractVisibleTreasure(t)
      end
      dieIfNoTreasures
    end
    
    def discardHiddenTreasure(t)
      @hiddenTreasures.delete_at(@hiddenTreasures.index(t))
      if (@pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty)
        @pendingBadConsequence.substractHiddenTreasure(t)
      end
      dieIfNoTreasures
    end
    
    def validState()
      @hiddenTreasures.length < 5 && (@pendingBadConsequence == nil || @pendingBadConsequence.isEmpty)
    end
    
    def initTreasures
      
      bringToLife
      @hiddenTreasures << CardDealer.instance.nexTreasure
      dice = Dice.instance
      number = dice.nextNumber
      
      if number > 1
        @hiddenTreasures << CardDealer.instance.nexTreasure
        if number == 6
          @hiddenTreasures << CardDealer.instance.nexTreasure
        end
      end
      
    end
    
    def stealTreasure()
      treasure = nil

      if @canISteal && @enemy.canYouGiveMeATreasure()
        treasure = @enemy.giveMeATreasure
        @hiddenTreasures << treasure
        haveStolen()
      end
      treasure
    end
    
    protected
    def giveMeATreasure()
      @hiddenTreasures.delete_at(rand(@hiddenTreasures.length))
    end
    
    def canYouGiveMeATreasure()
      !@hiddenTreasures.empty?
    end
    
    private
    def haveStolen()
      @canISteal = false
    end
    
    public
    def discardAllTreasures()
      # Mientras haya elementos en el vector, se borra el primero de ellos
      while(!@visibleTreasures.empty?)
        discardVisibleTreasure(@visibleTreasures[0])
      end
      
      while(!@hiddenTreasures.empty?)
        discardHiddenTreasure(@hiddenTreasures[0])
      end
    end
    
    def to_s()
      "#{@name} (#{@level})"
    end
    
  end
end
