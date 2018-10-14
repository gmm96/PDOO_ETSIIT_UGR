#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

require_relative 'TreasureKind.rb'

module NapakalakiGame
class Treasure
  
  attr_reader :name
  attr_reader :bonus
  attr_reader :type
  
  def initialize(aName, aBonus, aType)
    @name = aName
    @bonus = aBonus
    @type = aType
  end
  
  def to_s()
    "#{@name} (#{@type}, +#{@bonus})"
  end
  
end
end