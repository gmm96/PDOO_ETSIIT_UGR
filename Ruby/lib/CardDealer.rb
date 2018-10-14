#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#

require 'singleton'
require_relative 'Monster.rb'
require_relative 'Treasure.rb'
require_relative 'Cultist.rb'
require_relative 'SpecificBadConsequence.rb'
require_relative 'NumericBadConsequence.rb'
require_relative 'DeathBadConsequence.rb'
require_relative 'Prize.rb'


module NapakalakiGame
  class CardDealer
    
    include Singleton
    
    private_class_method:new
    
    def initialize
      @unusedTreasures = Array.new
      @unusedMonsters = Array.new
      @usedTreasures = Array.new
      @usedMonsters = Array.new
      @unusedCultists = Array.new
    end
    
    private
    def initTreasureCardDeck()
      
      @unusedTreasures << Treasure.new("¡Sí mi amo!", 4, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Botas de investigación", 3, TreasureKind::SHOES)
      @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("A prueba de babas", 2, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Botas de lluvia ácida", 2, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Ametralladora Thompson", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Camiseta de la UGR", 1, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Fez alópodo", 3, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Hacha prehistórica", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Garabato místico", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("La rebeca metálica", 2, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Necro-comicón", 1, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necronomicón",5 , TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Linterna a 2 manos", 3, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Necro-gnomicón", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Mazo de los antiguos", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necro-playboycón", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Tentáculo de pega", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOES)
      
    end
    
    def initMonsterCardDeck()
      
      prize = Prize.new(2,1)
      badConsequence = SpecificBadConsequence.new("Pierdes tu armadura visible y otra oculta",0,[TreasureKind::ARMOR],[TreasureKind::ARMOR])
      @unusedMonsters << Monster.newMonster("Byakhees de bonanza", 8, badConsequence, prize)

      prize = Prize.new(1,1)
      badConsequence = SpecificBadConsequence.new("Embobado con el lindo primigenio, te descartas de tu casco visible",0,[TreasureKind::HELMET],[])
      @unusedMonsters << Monster.newMonster("Chibithulhu", 2, badConsequence, prize)

      prize = Prize.new(1,1)
      badConsequence = SpecificBadConsequence.new("El primordial bostezo contagioso. Pierdes el calzado visible",0,[TreasureKind::SHOES],[])
      @unusedMonsters << Monster.newMonster("El sopor de Dunwich", 2, badConsequence, prize)

      prize = Prize.new(4,1)
      badConsequence = SpecificBadConsequence.new("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
      @unusedMonsters << Monster.newMonster("Angeles de la noche ibicenca", 14, badConsequence, prize)

      prize = Prize.new(3,1)
      badConsequence = NumericBadConsequence.new("Pierdes todos tus tesoros visibles",0,BadConsequence.class_variable_get(:@@MAXTREASURES),0)
      @unusedMonsters << Monster.newMonster("El gorron en el umbral",10,badConsequence,prize)

      prize = Prize.new(2,1)
      badConsequence = SpecificBadConsequence.new("Pierdes la armadura visible",0,[TreasureKind::ARMOR],[])
      @unusedMonsters << Monster.newMonster("H.P. Munchcraft", 6, badConsequence, prize)

      prize = Prize.new(2,1)
      badConsequence = SpecificBadConsequence.new("Sientes bichos bajo la ropa. Descarta la armadura visible",0,[TreasureKind::ARMOR],[])
      @unusedMonsters << Monster.newMonster("Bichgooth", 2, badConsequence, prize)

      prize = Prize.new(4,2)
      badConsequence = NumericBadConsequence.new("Pierdes 5 niveles y 3 tesoros visibles",5,3,0)
      @unusedMonsters << Monster.newMonster("El rey de rosa",13,badConsequence, prize)

      prize = Prize.new(1,1)
      badConsequence = NumericBadConsequence.new("Toses los pulmones y pierdes 2 niveles",2,0,0)
      @unusedMonsters << Monster.newMonster("La que redacta en las tinieblas",2,badConsequence, prize)

      badConsequence =  DeathBadConsequence.new("Estos monstruos resultan bastate superficiales y te aburren mortalmente. Estas muerto",true);
      prize = Prize.new(2, 1);
      @unusedMonsters << Monster.newMonster("Los hondos", 8, badConsequence, prize);

      badConsequence =  NumericBadConsequence.new("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
      prize = Prize.new(2, 1);
      @unusedMonsters << Monster.newMonster("Semillas Cthulhu", 4, badConsequence, prize);

      badConsequence = SpecificBadConsequence.new("Te intentas escaquear. Pierdes una mano visible.",0, [TreasureKind::ONEHAND], []);
      prize = Prize.new(2,1);
      @unusedMonsters << Monster.newMonster("Dameargo", 1, badConsequence,prize);

      badConsequence =  NumericBadConsequence.new("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
      prize = Prize.new(1, 1);
      @unusedMonsters << Monster.newMonster("Pollipolipo volvante", 3, badConsequence, prize);

      badConsequence =  DeathBadConsequence.new("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
      prize = Prize.new(3, 1);
      @unusedMonsters << Monster.newMonster("Yskhtihyssg-Goth", 12, badConsequence, prize);

      badConsequence =  DeathBadConsequence.new("La familia te atrapa. Estas muerto", true);
      prize = Prize.new(4, 1);
      @unusedMonsters << Monster.newMonster("Familia feliz", 1, badConsequence, prize);

      badConsequence = SpecificBadConsequence.new("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, [TreasureKind::BOTHHANDS],[]);
      prize = Prize.new(2,1);
      @unusedMonsters << Monster.newMonster("Roboggoth", 8, badConsequence,prize);

      badConsequence = SpecificBadConsequence.new("Te asusta en la noche. Pierdes un casco visible",0,[TreasureKind::HELMET],[]);
      prize = Prize.new(1,1);
      @unusedMonsters << Monster.newMonster("El espia", 5, badConsequence,prize);

      badConsequence =  NumericBadConsequence.new("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
      prize = Prize.new(1, 1);
      @unusedMonsters << Monster.newMonster("El Lenguas", 20, badConsequence, prize);  
      
      prize = Prize.new(1,1)
      badConsequence = SpecificBadConsequence.new("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,[TreasureKind::ONEHAND, TreasureKind::BOTHHANDS],[])
      @unusedMonsters << Monster.newMonster("Bicefalo", 20, badConsequence, prize)

      prize = Prize.new(3,1);
      badConsequence = SpecificBadConsequence.new("Pierdes una mano visible",0,[TreasureKind::ONEHAND],[])
      @unusedMonsters << Monster.newCultistMonster("El mal indecible impronunciable", 10, badConsequence, prize, -2)
      
      prize = Prize.new(2,1);
      badConsequence = SpecificBadConsequence.new("Pierdes tus tesoros visibles. Jajaja",0,BadConsequence.class_variable_get(:@@MAXTREASURES),0)
      @unusedMonsters << Monster.newCultistMonster("Testigos oculares", 6, badConsequence, prize, 2)
      
      prize = Prize.new(2,5);
      badConsequence = DeathBadConsequence.new("Hoy no es tu día de suerte. Mueres",true)
      @unusedMonsters << Monster.newCultistMonster("El gran cthulhu", 20, badConsequence, prize, 4)
      
      prize = Prize.new(2,1);
      badConsequence = NumericBadConsequence.new("Tu gobierno te recorta 2 niveles",2,0,0)
      @unusedMonsters << Monster.newCultistMonster("Serpiente Político", 8, badConsequence, prize, -2)
      
      prize = Prize.new(1,1);
      badConsequence = SpecificBadConsequence.new("Pierdes tu casco y tu armadura visible. Pierdes una mano oculta",0,[TreasureKind::HELMET, TreasureKind::ARMOR],[TreasureKind::ONEHAND])
      @unusedMonsters << Monster.newCultistMonster("Felpuggoth", 2, badConsequence, prize, 5)
      
      prize = Prize.new(4,2);
      badConsequence = NumericBadConsequence.new("Pierdes dos niveles",2,0,0)
      @unusedMonsters << Monster.newCultistMonster("Shoggoth", 16, badConsequence, prize, -4)
      
      prize = Prize.new(1,1);
      badConsequence = NumericBadConsequence.new("Pintalabios negro. Pierdes 2 niveles",2,0,0)
      @unusedMonsters << Monster.newCultistMonster("El mal indecible impronunciable", 2, badConsequence, prize, 3)
      
    end
    
    def initCultistCardDeck()
      for i in 0..3
        @unusedCultists << Cultist.new("Sectario",1)
      end
      for i in 0..1
        @unusedCultists << Cultist.new("Sectario",2)
      end
    end
    
    def shuffleTreasures()
      for i in 0..@unusedTreasures.length-1
        j = rand(@unusedTreasures.length)
        
        aux = @unusedTreasures[i]
        @unusedTreasures[i] = @unusedTreasures[j]
        @unusedTreasures[j] = aux
      end
    end
    
    def shuffleMonsters()
      for i in 0..@unusedMonsters.length-1
        j = rand(@unusedMonsters.length)

        aux = @unusedMonsters[i]
        @unusedMonsters[i] = @unusedMonsters[j]
        @unusedMonsters[j] = aux
      end
    end
    
    def shuffleCultists()
      for i in 0..@unusedCultists.length-1
        j = rand(@unusedCultists.length)

        aux = @unusedCultists[i]
        @unusedCultists[i] = @unusedCultists[j]
        @unusedCultists[j] = aux
      end
    end
    
    public
    def nexTreasure()
      if @unusedTreasures.empty?
        @unusedTreasures = @usedTreasures.clone
        @usedTreausres.clear
        shuffleTreasures
      end
      
      @unusedTreasures.pop
    end
    
    def nextMonster()
      if @unusedMonsters.empty?
        @unusedMonsters = @usedMonsters.clone
        @usedMonster.clear
        shuffleMonsters
      end
      
      @unusedMonsters.pop
    end
    
    def nextCultist()
      @unusedCultists.pop
    end
    
    def giveTreasureBack(t)
      @usedTreasures << t
    end
    
    def giveMonsterBack(m)
      @usedMonsters << m
    end
    
    def initCards()
      initTreasureCardDeck
      initMonsterCardDeck
      initCultistCardDeck
      shuffleTreasures
      shuffleMonsters
      shuffleCultists
    end
    
  end
end
