/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

import java.util.Random;
import java.util.ArrayList;

public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    private CardDealer dealer = CardDealer.getInstance();
    private Monster currentMonster;
    private Player currentPlayer;
    private ArrayList<Player> players = new ArrayList();
    
    private Napakalaki() {}
    
    private void initPlayers(ArrayList<String> names) {
        for (String i:names)
            players.add(new Player(i));
        
        // Inicializamos currentPlayer
        // Esto evita que el primer nextTurn falle al no estar inicializado
        Random n = new Random();
        int ale = n.nextInt(players.size());
        currentPlayer = players.get(ale);   
    
    }
    
    private Player nextPlayer() {
        // La inicialización de currentPlayer se hace en initPlayers
        // para evitar que la primera vez que se ejecute nextTurn falle
        return players.get((players.indexOf(currentPlayer)+1) % players.size());
    }
    
    public boolean nextTurnAllowed() {
        return currentPlayer.validState();
    }
    
    private void setEnemies() {
        for (int i = 0; i < players.size(); i++){
            
            int indice;
            Random n = new Random();
            do{
                indice = n.nextInt(players.size()); 
            }while(indice == i);
            
            players.get(i).setEnemy(players.get(indice));          
        }
  
    }
    
    public static Napakalaki getInstance() {
        return instance;
    }
    
    public CombatResult developCombat() {
        dealer.giveMonsterBack(currentMonster);
        CombatResult a = currentPlayer.combat(currentMonster);
        
        if (a == CombatResult.LOSEANDCONVERT){
            CultistPlayer aux = new CultistPlayer(currentPlayer, CardDealer.getInstance().nextCultist());
            players.set(players.indexOf(currentPlayer), aux);
            currentPlayer = aux;
        }
        
        return a;            
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        for(Treasure treasure:treasures)
        {
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        for(Treasure treasure:treasures)
        {
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        for(Treasure treasure:treasures)
            currentPlayer.makeTreasureVisible(treasure);
    }
    
    public void initGame(ArrayList<String> players) {
        initPlayers(players);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster() {
        return currentMonster;
    }
    
    public boolean nextTurn() {
        boolean stateOK = nextTurnAllowed();
        if(stateOK)
        {
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            if(currentPlayer.isDead())
                currentPlayer.initTreasures(getCurrentPlayer().getName());
        }
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WINGAME;
    }
}
