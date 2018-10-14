/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */
package NapakalakiGame;

import GUI.*;
import java.util.ArrayList;


public class Main {
    
    public static void main (String[] args){
        
        // Crear instancias únicas de cada clase
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        Dice.createInstance(napakalakiView);

        // Obtener nombres
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        ArrayList<String> names = namesCapture.getNames();        
        
        // Iniciar juego
        game.initGame(names);
         
        // Enlazar modelo a la vista
        napakalakiView.setNapakalaki(game);
                       
        // Mostrar ventana de aplicación
        napakalakiView.setVisible(true);

    }
}
