#encoding: utf-8

# Autores:
# 
#     Guillermo Montes Martos
#     Manuel Ruiz López
#


module NapakalakiGame
  class Prize

    attr_reader :treasures
    attr_reader :levels

    def initialize(t, l)
      @treasures = t
      @levels = l
    end
    
    def to_s
      "Tesoros = #{@treasures}. Niveles = #{@levels}"
    end

  end
end
