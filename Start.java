
package View;

import Controller.Controller;
import Controller.ControllerToken;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class Start extends javax.swing.JFrame {
        ApprenticeForm ap1 = new ApprenticeForm();
            TokenForm nv = new TokenForm();
            CardLayout vista;
    
    public Start() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_vista = new javax.swing.JPanel();
        btnToken = new javax.swing.JButton();
        btnApprentice = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_vista.setBackground(new java.awt.Color(0, 255, 51));

        btnToken.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnToken.setForeground(new java.awt.Color(0, 0, 0));
        btnToken.setText("Token");
        btnToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTokenActionPerformed(evt);
            }
        });

        btnApprentice.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnApprentice.setForeground(new java.awt.Color(0, 0, 0));
        btnApprentice.setText("Apprentice");
        btnApprentice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApprenticeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Main ");

        btnExit.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(0, 0, 0));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo-sena-negro-jpg-2022.jpg"))); // NOI18N

        javax.swing.GroupLayout pnl_vistaLayout = new javax.swing.GroupLayout(pnl_vista);
        pnl_vista.setLayout(pnl_vistaLayout);
        pnl_vistaLayout.setHorizontalGroup(
            pnl_vistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_vistaLayout.createSequentialGroup()
                .addGroup(pnl_vistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_vistaLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnToken, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_vistaLayout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnExit)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_vistaLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(pnl_vistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_vistaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_vistaLayout.createSequentialGroup()
                        .addComponent(btnApprentice, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_vistaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(78, 78, 78))))
        );
        pnl_vistaLayout.setVerticalGroup(
            pnl_vistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_vistaLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(btnApprentice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnToken)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_vista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_vista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(null,"¿Need exit the Program!!!!?","Messagee",JOptionPane.YES_NO_OPTION);
        if (confirmar==JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnApprenticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApprenticeActionPerformed
        ApprenticeForm f  = new ApprenticeForm();

        Controller con =  new Controller(f);

        f.setVisible(true);
        f.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnApprenticeActionPerformed

    private void btnTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTokenActionPerformed
        TokenForm f  = new TokenForm();

        ControllerToken con =  new ControllerToken(f);

        f.setVisible(true);
        f.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_btnTokenActionPerformed
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprentice;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnToken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnl_vista;
    // End of variables declaration//GEN-END:variables
}

