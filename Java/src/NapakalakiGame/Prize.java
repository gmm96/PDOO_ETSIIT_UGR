/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

public class Prize {
    private int treasures, levels;
    
    // Constructor

    public Prize (int t, int l){
        this.treasures = t;
        this.levels = l;
    }
    
    // Métodos get
    
    public int getTreasures(){
        return treasures;
    }
   
    public int getLevels(){
        return levels;
    }
    
    @Override
    public String toString() {
        return ("Tesoros: "+treasures+", Niveles: "+levels);
    }
    
    // Práctica 1
    /*
    // Método de salida string
    
    public String toString() {
        return "Treasures = " + Integer.toString(treasures) +
                ". Levels = " + Integer.toString(levels);
    }
    */
}
