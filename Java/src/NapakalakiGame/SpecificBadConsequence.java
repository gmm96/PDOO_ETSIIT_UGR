/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

import java.util.ArrayList;

public class SpecificBadConsequence extends BadConsequence{
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    public SpecificBadConsequence (String t, int l, ArrayList<TreasureKind> v, ArrayList<TreasureKind> h){
        super(t, l);
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
    }
     
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }

    @Override
    public boolean isEmpty() {
    return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t) {
        specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        BadConsequence nuevo;

        ArrayList<TreasureKind> sv, sh;
        sv = intersection(specificVisibleTreasures, v);
        sh = intersection(specificHiddenTreasures, h);
        nuevo = new SpecificBadConsequence(this.getText(), this.getLevels(), sv, sh);
        
        return nuevo;
    }
    
    private ArrayList<TreasureKind> intersection(ArrayList<TreasureKind> tk, ArrayList<Treasure> t) {
    ArrayList<TreasureKind> salida = new ArrayList();

    if(!tk.isEmpty() && !t.isEmpty())
    {
        ArrayList<TreasureKind> aux = new ArrayList(tk);
        
        for(Treasure treasure:t) {
            int i = aux.indexOf(treasure.getType());
            if(i != -1)
                salida.add(aux.remove(i));
        }
    }

    return salida;
    }
}
