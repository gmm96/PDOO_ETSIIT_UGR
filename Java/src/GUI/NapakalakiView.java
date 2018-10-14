/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */

package GUI;

import NapakalakiGame.CombatResult;
import NapakalakiGame.Napakalaki;
import java.awt.Font;


public class NapakalakiView extends javax.swing.JFrame {

    private Napakalaki napakalakiModel;
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
        monsterView1.setVisible(false);
        meetMonster.setEnabled(true);
        combat.setEnabled(false);
        nextTurn.setEnabled(false);
        estado.setFont(new Font("", Font.BOLD, 20));
        status.setFont(new Font("", Font.ITALIC + Font.BOLD, 16));
        status.setText("Comienza la partida");
        cabeceraMonstruo.setFont(new Font("", Font.BOLD, 15));
    }
    
    public void setNapakalaki(Napakalaki napakalaki){
        napakalakiModel = napakalaki;
        monsterView1.setMonster(napakalakiModel.getCurrentMonster());
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView.setNapakalaki(napakalakiModel);
        
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerView2 = new GUI.PlayerView();
        meetMonster = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        nextTurn = new javax.swing.JButton();
        estado = new javax.swing.JLabel();
        cabeceraMonstruo = new javax.swing.JLabel();
        monsterView1 = new GUI.MonsterView();
        playerView = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        meetMonster.setText("Conoce al monstruo");
        meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetMonsterActionPerformed(evt);
            }
        });

        combat.setText("Combatir");
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });

        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        nextTurn.setText("Siguiente Turno");
        nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnActionPerformed(evt);
            }
        });

        estado.setText("Estado:");

        cabeceraMonstruo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cabeceraMonstruo.setText("Monstruo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(estado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(40, 50, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nextTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(meetMonster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cabeceraMonstruo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estado)
                    .addComponent(status))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nextTurn)
                        .addGap(18, 18, 18)
                        .addComponent(meetMonster)
                        .addGap(18, 18, 18)
                        .addComponent(combat)
                        .addGap(134, 134, 134)
                        .addComponent(cabeceraMonstruo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        CombatResult result = napakalakiModel.developCombat();
        switch (result) {
            case WINGAME : 
                status.setText("Enhorabuena " + napakalakiModel.getCurrentPlayer().getName() + " ¡¡ HAS GANADO !!");
                break;
            case WIN :
                status.setText(napakalakiModel.getCurrentPlayer().getName() + ", ganaste el combate!"); 
                break;
            case LOSE :
                status.setText(napakalakiModel.getCurrentPlayer().getName() + 
                                    ", has perdido el combate. Debes cumplir el mal rollo.");
                break;
            case LOSEANDCONVERT :
                status.setText(napakalakiModel.getCurrentPlayer().getName() + ", has perdido el combate y te conviertes en sectario.");
                break;
        }
        
        combat.setEnabled(false);
        nextTurn.setEnabled(true);

        setNapakalaki(napakalakiModel);
    }//GEN-LAST:event_combatActionPerformed

    private void meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetMonsterActionPerformed
        monsterView1.setVisible(true);
        meetMonster.setEnabled(false);
        combat.setEnabled(true);

        setNapakalaki(napakalakiModel);
    }//GEN-LAST:event_meetMonsterActionPerformed

    private void nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnActionPerformed
        if(napakalakiModel.nextTurnAllowed()) {
            napakalakiModel.nextTurn();
            monsterView1.setVisible(false);
            meetMonster.setEnabled(true);
            nextTurn.setEnabled(false);
            status.setText(napakalakiModel.getCurrentPlayer().getName() + ", es tu turno.");
        }
        else
            status.setText("No puedes pasar turno, tienes que cumplir el mal rollo");

        setNapakalaki(napakalakiModel);
    }//GEN-LAST:event_nextTurnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cabeceraMonstruo;
    private javax.swing.JButton combat;
    private javax.swing.JLabel estado;
    private javax.swing.JButton meetMonster;
    private GUI.MonsterView monsterView1;
    private javax.swing.JButton nextTurn;
    private GUI.PlayerView playerView;
    private GUI.PlayerView playerView2;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
