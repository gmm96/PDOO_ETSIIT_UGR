/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

import java.util.ArrayList;

public abstract class BadConsequence {
    static final int MAXTREASURES = 10;
    private String text;
    private int levels = 0;
    
    // Constructores
    
    public BadConsequence (String t, int l){
        this.text = t;
        this.levels = l;
    }
       
    // Métodos get
    
    public int getLevels(){
        return levels;
    }
    
    public String getText(){
        return text;
    }
    
    public abstract boolean isEmpty();
    
    // Métodos modificadores 
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    @Override
    public String toString() {
        return text;
    }
   
}
