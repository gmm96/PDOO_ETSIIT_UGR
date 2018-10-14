/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CardDealer {

    private static final CardDealer instance = new CardDealer();
    
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultist = new ArrayList();

    private CardDealer() {}
    
    private void initTreasureCardDeck() {
        unusedTreasures.add(new Treasure("¡Si mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 2, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alopodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicon", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicon",5 , TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicon", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycon", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));
    }
    
    private void initMonsterCardDeck() {
        BadConsequence badConsequence;
        Prize prize;
        
        badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y otra oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu", 2, badConsequence, prize));
        
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, badConsequence,prize));
        
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles",0,BadConsequence.MAXTREASURES,0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, badConsequence,prize));    
        
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence,prize));
        
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth", 2, badConsequence,prize));
        
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes 2 niveles",2,0,0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, badConsequence,prize));
        
        badConsequence =  new DeathBadConsequence("Estos monstruos resultan bastate superficiales y te aburren mortalmente. Estas muerto");
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Los hondos", 8, badConsequence, prize));

        badConsequence =  new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence,prize));
        
        badConsequence =  new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, badConsequence, prize));
        
        badConsequence =  new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto");
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        badConsequence =  new DeathBadConsequence("La familia te atrapa. Estás muerto");
        prize = new Prize(4, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence,prize));
        
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence,prize));
        
        badConsequence =  new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El Lenguas", 20, badConsequence, prize));
        
        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",3,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS, TreasureKind.ONEHAND)),new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicefalo", 20, badConsequence,prize));
        
        badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja", 0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, badConsequence, prize, 2));
        
        badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres");
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));
        
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Politico", 8, badConsequence, prize, -2));
        
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. Pierdes una mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET, TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));

        badConsequence = new NumericBadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));
        
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));

        
        
    }
    
    private void initCultistCardDeck(){
        for (int i = 0; i < 4; i++){
            unusedCultist.add(new Cultist("Sectario", 1));
        }
        
        for (int i = 0; i < 2; i++){
            unusedCultist.add(new Cultist("Sectario", 2));
        }
            
    }
    
    private void shuffleTreasures() {
        Random n = new Random();
        
        for(int i=0; i<unusedTreasures.size(); i++) {                    
            int j = n.nextInt(unusedTreasures.size());
            
            Treasure aux = unusedTreasures.get(i);
            unusedTreasures.set(i, unusedTreasures.get(j));
            unusedTreasures.set(j, aux);
        }
    }
    
    private void shuffleMonsters() {
        Random n = new Random();
        
        for(int i=0; i<unusedMonsters.size(); i++) {                    
            int j = n.nextInt(unusedMonsters.size());
            
            Monster aux = unusedMonsters.get(i);
            unusedMonsters.set(i, unusedMonsters.get(j));
            unusedMonsters.set(j, aux);
        }
    }
    
    private void shuffleCultist(){
        Random n = new Random();
        
        for(int i=0; i < unusedCultist.size(); i++) {                    
            int j = n.nextInt(unusedCultist.size());
            
            Cultist aux = unusedCultist.get(i);
            unusedCultist.set(i, unusedCultist.get(j));
            unusedCultist.set(j, aux);
        }
    }
    
    public static CardDealer getInstance () {
        return instance;
    }
    
    public Treasure nextTreasure() {
    
        if (unusedTreasures.isEmpty()){
            unusedTreasures = usedTreasures;
            usedTreasures = new ArrayList();
            this.shuffleTreasures();
        }
        
        return unusedTreasures.remove(unusedTreasures.size()-1);
    }
    
    public Monster nextMonster() {
        
        if (unusedMonsters.isEmpty()){
            unusedMonsters = usedMonsters;
            usedMonsters = new ArrayList();
            this.shuffleMonsters();
            
        }
        
        return unusedMonsters.remove(unusedMonsters.size()-1);
    }
    
    
    public Cultist nextCultist(){
        return unusedCultist.remove(unusedCultist.size()-1);
    }
    
    public void giveTreasureBack(Treasure t) {
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m) {
        usedMonsters.add(m);
    }
    
    public void initCards() {
        initTreasureCardDeck();
        initMonsterCardDeck();
        initCultistCardDeck();
        shuffleTreasures();
        shuffleMonsters();
        shuffleTreasures();
    }
    
   }
