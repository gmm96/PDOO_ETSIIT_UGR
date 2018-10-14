#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#


require_relative 'bad_consequence.rb'
require_relative 'prize.rb'
require_relative 'monster.rb'
require_relative 'treasure_kind.rb'

module PruebaNapakalaki

  #                     #
  #   Pŕactica 1        #
  #                     #
=begin  
  # Nivel de combate superior a 10
  puts "\n\nMonstruos cuyo nivel de combate es superior a 10:\n\n"
  
  for i in monsters
    puts i.to_s if (i.combatLevel > 10)
  end
  
   # Su mal rollo implica sólo pérdida de niveles
  puts "\n\nMonstruos cuyo mal rollo implica unicamente la perdida de niveles:\n\n"
  
  for i in monsters
    puts i.to_s if (i.perdidasoloniveles)
  end
  
  # Su buen rollo indique una ganancia de niveles superior a 1
  puts "\n\nMonstruos cuyo buen rollo implica una ganancia de niveles superior a 1:\n\n"
  
  for i in monsters
    puts i.to_s if (i.ganancianivelessupa(1))
  end
  
  
  # Cuyo mal rollo suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos.
  puts "\n\nMonstruos Cuyo mal rollo suponga la perdida de un determinado tipo de tesoros ya sea visibles y/o ocultos:\n\n"
  
  for j in monsters
    puts j.to_s if (j.perdidatipotesoros)
  end
=end
  
end
