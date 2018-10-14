/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

import java.util.ArrayList;

public class NumericBadConsequence extends BadConsequence {
    private int nVisibleTreasures = 0;
    private int nHiddenTreasures = 0;
    
    public NumericBadConsequence (String t, int l, int nVisible, int nHidden) {
            super(t,l);
            nVisibleTreasures = nVisible;
            nHiddenTreasures = nHidden;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty() {
        return nVisibleTreasures==0 && nHiddenTreasures==0;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t) {
        if(nVisibleTreasures>0)
            nVisibleTreasures--;
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        if(nHiddenTreasures>0)
            nHiddenTreasures--;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        BadConsequence nuevo;
        
        int nv = (nVisibleTreasures<v.size())? nVisibleTreasures : v.size();
        int nh = (nHiddenTreasures<h.size())? nHiddenTreasures : h.size();
        nuevo = new NumericBadConsequence(this.getText(), this.getLevels(), nv, nh);
                
        return nuevo;
    }

}
