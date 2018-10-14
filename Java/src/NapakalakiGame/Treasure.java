/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

public class Treasure {
    private String name;
    private int bonus;
    private TreasureKind type;
    

    // Constructor
       
    public Treasure (String n, int b, TreasureKind t){
        name = n;
        bonus = b;
        type = t;
    }
    
    public String getName(){
        return name;
    }
    
    public int getBonus(){
        return bonus;
    }
    
    public TreasureKind getType(){
        return type;
    }
    
    @Override
    public String toString() {
        return (name+" (Bonus: "+bonus+", Tipo: "+type+")");
    }
}
