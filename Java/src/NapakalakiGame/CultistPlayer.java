/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

import java.util.Random;

public class CultistPlayer extends Player{
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    
    // Constructor
    
    public CultistPlayer(Player p, Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
        
    @Override
    public int getCombatLevel(){
        return ( (int) (super.getCombatLevel() * 1.2 + myCultistCard.getGainedLevels() * totalCultistPlayers) );
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert (){
        return false;
    }

    @Override
    protected Treasure giveMeATreasure (){
        Random n = new Random();
        return getVisibleTreasures().remove(n.nextInt(getVisibleTreasures().size()));
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return !getVisibleTreasures().isEmpty();
    }
    
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    
}
