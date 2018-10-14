/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;
import GUI.Dice;

public class Player {
    
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    protected Player enemy;
    private BadConsequence pendingBadConsequence;
 
    
    public Player (String aname){
        name = aname;
        level = 1;
        pendingBadConsequence = new NumericBadConsequence("", 0, 0, 0);
    }
    
    public Player (Player p){
        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.hiddenTreasures = new ArrayList(p.hiddenTreasures);
        this.visibleTreasures = new ArrayList(p.visibleTreasures);
        this.enemy = p.enemy;
        this.pendingBadConsequence = p.pendingBadConsequence;
    }
    
    public String getName (){
        return name;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    public int getCombatLevel(){
        int suma = level;
        for (Treasure elemento:visibleTreasures)
            suma += elemento.getBonus();
        
        return suma;
    }
    
    private void incrementLevels(int i){
        level += i;
        
        if (level > MAXLEVEL)
            level = MAXLEVEL;
    } 
    
    private void decrementLevels(int i){
        level -= i;
        
        if (level < 1)
            level = 1;
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    private void applyPrize (Monster m){
        incrementLevels(m.getLevelsGained());
        int nTreasures = m.getTreasuresGained();
        if(nTreasures>0) {
            CardDealer dealer = CardDealer.getInstance();
            for(int i=0; i<nTreasures; i++)
                hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    
    private void applyBadConsequence (Monster m){
        BadConsequence bc = m.getBadConsequence();
        decrementLevels(bc.getLevels());
        setPendingBadConsequence(bc.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures));
    }
    
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean condition = true;
        
        int i = 0;
        switch (t.getType()){
            case BOTHHANDS:
                while (i<visibleTreasures.size() && condition){
                    if ( (visibleTreasures.get(i).getType() == TreasureKind.ONEHAND) ||
                        (visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS) )
                        condition = false;
                    else
                        i++;
                }
                
                break;
                
                
            case ONEHAND:
                boolean one_hand = false;
                
                while(i<visibleTreasures.size() && condition){
                    if (visibleTreasures.get(i).getType() == TreasureKind.BOTHHANDS)
                        condition = false;
                    else if (visibleTreasures.get(i).getType() == TreasureKind.ONEHAND)
                        if (one_hand)
                            condition = false;
                        else{
                            one_hand = true;
                            i++;
                        }
                    else
                        i++;
                }
                
                break;
                
                
            default:
                while (i<visibleTreasures.size() && condition){
                    if (visibleTreasures.get(i).getType() == t.getType())
                        condition = false;
                    else 
                        i++;
                }
                
                break;
                
        }
        
        return condition;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind){
        int contador = 0;
        for (Treasure elemento:visibleTreasures)
            if (elemento.getType() == tKind)
                contador++;
        
        return contador;
    }
    
    private void dieIfNoTreasures(){
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty())
            dead = true;
    }
    
    public boolean isDead(){
        return dead;
    }

    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }

    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    
    public CombatResult combat (Monster m){
        CombatResult result;
        
        if(getCombatLevel() > getOponentLevel(m)) {
            applyPrize(m);
            result = (level>=MAXLEVEL)? CombatResult.WINGAME : CombatResult.WIN;
        }
        else {
            applyBadConsequence(m);
            result = shouldConvert()? CombatResult.LOSEANDCONVERT : CombatResult.LOSE;
        }
        
        return result;
    }
    
    public void makeTreasureVisible(Treasure t){
        if(canMakeTreasureVisible(t)) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure (Treasure t){
        visibleTreasures.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractVisibleTreasure(t);
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure (Treasure t){
        hiddenTreasures.remove(t);
        if(pendingBadConsequence!=null && !pendingBadConsequence.isEmpty())
            pendingBadConsequence.substractHiddenTreasure(t);
        dieIfNoTreasures();
    }
    
    public boolean validState (){        
        return (hiddenTreasures.size()<5 && (pendingBadConsequence==null || pendingBadConsequence.isEmpty()));
    }
    
    public void initTreasures(String nombre){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        int number;
        
        bringToLife();
        hiddenTreasures.add(dealer.nextTreasure());
        number = dice.nextNumber(nombre+", en un momento estarás vivo.", "Un número grande te dará más tesoros.");
        if(number>1) {
            hiddenTreasures.add(dealer.nextTreasure());
            if(number==6)
                hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    
    public int getLevels(){
        return level;
    }
    
    public Treasure stealTreasure(){
        Treasure treasure = null;
        
        if(canISteal && enemy.canYouGiveMeATreasure())
        {
            treasure = enemy.giveMeATreasure();
            hiddenTreasures.add(treasure);
            haveStolen();
        }
        
        return treasure;
    }
       
    public void setEnemy (Player enemy){
        this.enemy = enemy;
    }
    
    protected Treasure giveMeATreasure (){
        Random n = new Random();
        return hiddenTreasures.remove(n.nextInt(hiddenTreasures.size()));
    }
    
    public boolean canISteal (){
        return canISteal;
    }
    
    protected boolean canYouGiveMeATreasure(){
        return (!hiddenTreasures.isEmpty());
    }
    
    private void haveStolen(){
        canISteal = false;
    }
    
    public void discardAllTreasures(){
        while(!visibleTreasures.isEmpty())
            discardVisibleTreasure(visibleTreasures.get(0));
        while(!hiddenTreasures.isEmpty())
            discardHiddenTreasure(hiddenTreasures.get(0));
    }
    
    @Override
    public String toString() {
        return name;
    }
   
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        return Dice.getInstance().nextNumber("Lo siento, has perdido el combate.", 
                             "Si sacas un 6, te convertirás en jugador sectario.") == 6;           
    }
    
    public Player getEnemy(){
        return enemy;
    }
      
    
}
