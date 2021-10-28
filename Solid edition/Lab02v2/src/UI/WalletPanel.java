/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

/**
 *
 * @author khali
 */
public class WalletPanel extends javax.swing.JPanel {

    /**
     * Creates new form walletPanel
     */
    
    public WalletPanel(int n, String publicKey, String privateKey, Float balance) {
        initComponents();
        titleLabel.setText(titleLabel.getText()+n);
        publicKeyLabel.setText(publicKeyLabel.getText()+" "+publicKey);
        privateKeyLabel.setText(privateKeyLabel.getText()+" "+privateKey);
        balanceLabel.setText(balanceLabel.getText()+" "+balance);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        publicKeyLabel = new javax.swing.JLabel();
        privateKeyLabel = new javax.swing.JLabel();
        balanceLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        titleLabel.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Billetera #");

        publicKeyLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        publicKeyLabel.setText("Llave publica: ");

        privateKeyLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        privateKeyLabel.setText("Llave privada: ");

        balanceLabel.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        balanceLabel.setText("Balance:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(publicKeyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(privateKeyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(balanceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(25, 25, 25)
                .addComponent(publicKeyLabel)
                .addGap(15, 15, 15)
                .addComponent(privateKeyLabel)
                .addGap(15, 15, 15)
                .addComponent(balanceLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JLabel privateKeyLabel;
    private javax.swing.JLabel publicKeyLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}