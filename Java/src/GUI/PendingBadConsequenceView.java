/*
 * Autores:
 * Guillermo Montes Martos
 * Manuel Ruiz López
 *
 */

package GUI;

import NapakalakiGame.BadConsequence;
import NapakalakiGame.NumericBadConsequence;
import NapakalakiGame.SpecificBadConsequence;
import NapakalakiGame.TreasureKind;


public class PendingBadConsequenceView extends javax.swing.JPanel {

    private BadConsequence pendingBCModel;
    
    public PendingBadConsequenceView() {
        initComponents();
    }
    
    private String getVisibleTreasureKindNames(BadConsequence b){
        String visible = new String();
        for (TreasureKind tKind:((SpecificBadConsequence)b).getSpecificVisibleTreasures()){
            visible += tKind.name();
            visible += ", ";
        }
        if (!visible.isEmpty())
            visible = visible.substring(0, visible.length()-2);
        return visible;
    }
    
    private String getHiddenTreasureKindNames(BadConsequence b){
        String hidden = new String();
        for (TreasureKind tKind:((SpecificBadConsequence)b).getSpecificHiddenTreasures()){
            hidden += tKind.name();
            hidden += ", ";
        }
        if (!hidden.isEmpty())
            hidden = hidden.substring(0, hidden.length()-2);
        return hidden;
    }
    
    public void setPendingBadConsequence(BadConsequence bc){
        pendingBCModel = bc;
        
        if (pendingBCModel instanceof SpecificBadConsequence){
            if(((SpecificBadConsequence) pendingBCModel).getSpecificVisibleTreasures().size() == 0) {
                numericVisible.setText("0");
                numericVisible.setVisible(true);
                specificVisible.setVisible(false);
            }
            else {
                specificVisible.setText(this.getVisibleTreasureKindNames(pendingBCModel));
                numericVisible.setVisible(false);
                specificVisible.setVisible(true);
            }
            
            if(((SpecificBadConsequence) pendingBCModel).getSpecificHiddenTreasures().size() == 0) {
                numericHidden.setText("0");
                numericHidden.setVisible(true);
                specificHidden.setVisible(false);
            }
            else {
                specificHidden.setText(this.getHiddenTreasureKindNames(pendingBCModel));
                numericHidden.setVisible(false);
                specificHidden.setVisible(true);
            }
        }
        else{
            numericVisible.setText(Integer.toString(((NumericBadConsequence)pendingBCModel).getNVisibleTreasures()));
            numericHidden.setText(Integer.toString(((NumericBadConsequence)pendingBCModel).getNHiddenTreasures()));

            numericVisible.setVisible(true);
            numericHidden.setVisible(true);
            specificVisible.setVisible(false);
            specificHidden.setVisible(false);
        }
        
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

        jLabel1 = new javax.swing.JLabel();
        visibles = new javax.swing.JLabel();
        ocultos = new javax.swing.JLabel();
        numericVisible = new javax.swing.JLabel();
        numericHidden = new javax.swing.JLabel();
        specificVisible = new javax.swing.JLabel();
        specificHidden = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        visibles.setText("Tesoros visibles");

        ocultos.setText("Tesoros ocultos");

        numericVisible.setText("Numeric visible");

        numericHidden.setText("Numeric Hidden");

        specificVisible.setText("Specific visible");

        specificHidden.setText("Specific hidden");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specificVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ocultos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numericHidden, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numericVisible, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(specificHidden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visibles)
                    .addComponent(numericVisible))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(specificVisible)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ocultos)
                    .addComponent(numericHidden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(specificHidden)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel numericHidden;
    private javax.swing.JLabel numericVisible;
    private javax.swing.JLabel ocultos;
    private javax.swing.JLabel specificHidden;
    private javax.swing.JLabel specificVisible;
    private javax.swing.JLabel visibles;
    // End of variables declaration//GEN-END:variables
}
