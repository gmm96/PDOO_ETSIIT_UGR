/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */

package GUI;

import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;


public class PlayerView extends javax.swing.JPanel {
    
    private Player playerModel;
    private Napakalaki napakalakiModel;

    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
        jugadorSectario.enableInputMethods(false);
        jugadorSectario.setEnabled(false);
    }
    
    public void setPlayer (Player p) {
        playerModel = p;
        
        playerName.setText(playerModel.getName());
        playerLevel.setText(Integer.toString(playerModel.getLevels()));
        playerCombatLevel.setText(Integer.toString(playerModel.getCombatLevel()));
        playerEnemy.setText(playerModel.getEnemy().getName());
        pendingBadConsequenceView.setPendingBadConsequence(p.getPendingBadConsequence());
        
        jugadorSectario.setSelected(playerModel instanceof CultistPlayer);
        if(playerModel.canISteal())
            stealTreasure.setEnabled(true);
        
        fillTreasurePanel(visibleTreasures,playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasures,playerModel.getHiddenTreasures());        
        repaint();
        revalidate();
    }
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.
        
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
        }
        return output;
    } 
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua, si la hubiera
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        nivelcombate = new javax.swing.JLabel();
        enemigo = new javax.swing.JLabel();
        playerName = new javax.swing.JLabel();
        playerLevel = new javax.swing.JLabel();
        playerCombatLevel = new javax.swing.JLabel();
        playerEnemy = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        stealTreasure = new javax.swing.JButton();
        makeVisible = new javax.swing.JButton();
        discardTreasure = new javax.swing.JButton();
        discardAllTreasures = new javax.swing.JButton();
        sectario = new javax.swing.JLabel();
        pendingBadConsequenceView = new GUI.PendingBadConsequenceView();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jugadorSectario = new javax.swing.JCheckBox();

        name.setText("Nombre");

        nivel.setText("Nivel");

        nivelcombate.setText("Nivel de combate");

        enemigo.setText("Enemigo");

        playerName.setText("Player name");

        playerLevel.setText("Player level");

        playerCombatLevel.setText("Player combat level");

        playerEnemy.setText("Player enemy");

        visibleTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        stealTreasure.setText("Robar Tesoro");
        stealTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stealTreasureActionPerformed(evt);
            }
        });

        makeVisible.setText("Hacer visible");
        makeVisible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisibleActionPerformed(evt);
            }
        });

        discardTreasure.setText("Descartar tesoro");
        discardTreasure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardTreasureActionPerformed(evt);
            }
        });

        discardAllTreasures.setText("Descartas todos");
        discardAllTreasures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardAllTreasuresActionPerformed(evt);
            }
        });

        sectario.setText("Jugador sectario");

        jLabel1.setText("Mal rollo pendiente");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lista de tesoros visible");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lista de tesoros ocultos");

        jugadorSectario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugadorSectarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(enemigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sectario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(playerEnemy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(playerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nivelcombate)
                                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(playerCombatLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(playerLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jugadorSectario)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stealTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(makeVisible, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(discardTreasure, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(discardAllTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nivel)
                            .addComponent(playerLevel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nivelcombate)
                            .addComponent(playerCombatLevel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(playerName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enemigo)
                            .addComponent(playerEnemy))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jugadorSectario)
                            .addComponent(sectario))))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stealTreasure)
                    .addComponent(makeVisible)
                    .addComponent(discardTreasure)
                    .addComponent(discardAllTreasures))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stealTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stealTreasureActionPerformed
        playerModel.stealTreasure();
        setPlayer(playerModel);
        stealTreasure.setEnabled(false);
    }//GEN-LAST:event_stealTreasureActionPerformed

    private void discardAllTreasuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardAllTreasuresActionPerformed
        playerModel.discardAllTreasures();
        setPlayer(playerModel);
    }//GEN-LAST:event_discardAllTreasuresActionPerformed

    private void makeVisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(playerModel);
    }//GEN-LAST:event_makeVisibleActionPerformed

    private void discardTreasureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardTreasureActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList<Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        
        for (Treasure t : selHidden)
            playerModel.discardHiddenTreasure(t);
        for (Treasure t : selVisible)
            playerModel.discardVisibleTreasure(t);
        
        setPlayer(playerModel);
    }//GEN-LAST:event_discardTreasureActionPerformed

    private void jugadorSectarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugadorSectarioActionPerformed

    }//GEN-LAST:event_jugadorSectarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton discardAllTreasures;
    private javax.swing.JButton discardTreasure;
    private javax.swing.JLabel enemigo;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JCheckBox jugadorSectario;
    private javax.swing.JButton makeVisible;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel nivelcombate;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView;
    private javax.swing.JLabel playerCombatLevel;
    private javax.swing.JLabel playerEnemy;
    private javax.swing.JLabel playerLevel;
    private javax.swing.JLabel playerName;
    private javax.swing.JLabel sectario;
    private javax.swing.JButton stealTreasure;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
