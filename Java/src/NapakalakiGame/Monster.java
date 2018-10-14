/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer;
    
    // Constructor 
    
    public Monster(String n, int l, BadConsequence b, Prize p) {
        this.name = n;
        this.combatLevel = l;
        this.badConsequence = b;
        this.prize = p;
        this.levelChangeAgainstCultistPlayer = 0;
    }
    
    public Monster(String n, int l, BadConsequence b, Prize p, int lC) {
        this.name = n;
        this.combatLevel = l;
        this.badConsequence = b;
        this.prize = p;
        this.levelChangeAgainstCultistPlayer = lC;
    }
    
    
    // Métodos get
    
    public String getName() {
        return name;
    }
    
    public int getCombatLevel() {
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence() {
        return badConsequence;
    }
    
    public Prize getPrize() {
        return prize;
    }
    
    public int getLevelsGained() {
        return prize.getLevels();
    }
    
    public int getTreasuresGained() {
        return prize.getTreasures();
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return levelChangeAgainstCultistPlayer + combatLevel;
    }
    
    @Override
    public String toString() {
        return (name+" (Nivel de combate: "+combatLevel+")\nMal rollo: "+badConsequence.toString()+"\nBuen rollo: "+prize.toString());
    }
    
    // Practica 1
    /*
    public boolean perdidasoloNiveles () {
        return badConsequence.perdidasoloNiveles();
    }
    
    public boolean gananciaNivelesSup1 () {
        return (prize.getLevel() > 1);
    }
    
    public boolean perdidatipoTesoros () {
        return badConsequence.perdidatipoTesoros();
    }    
    
    // Método de salida string
    
    public String toString() {
        return ("Name = " + name + ". Level = " + Integer.toString(combatLevel) 
                + "\n" + "Prize: " + prize.toString() + "\n" 
                + "Bad Consequence: " + badConsequence.toString() + "\n");
        
    }
    */

}
