/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Start;

import DB.DB1;
import DB.DB2;
import Game.Game;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author osku0
 */
public class NewGame extends javax.swing.JFrame {

    private DB2 bMan;
    static int vaikeus = 1;
    static int alkuKassa = 1;

    /**
     * Creates new form NewGame
     */
    public NewGame() {
        try {
            initComponents();
            vaikeus = 1;
            alkuKassa = 1;
            bMan = new DB2();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Class not found: " + ex);
            JOptionPane.showMessageDialog(this, "Error class not found:" + ex);
        } catch (SQLException ex) {
            Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error SQL: " + ex);
            JOptionPane.showMessageDialog(this, "Error SQL:" + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 200, 25));

        jLabel2.setText("Your Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 142, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 95, 200, 25));

        jLabel1.setText("City Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 98, -1, -1));

        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 274, -1, -1));

        jLabel3.setText("Difficulty");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 186, -1, -1));

        jButton2.setText("<");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 182, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Easy");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 186, 50, -1));

        jButton3.setText(">");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 182, -1, -1));

        jLabel5.setText("Start money: 50K €");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        setSize(new java.awt.Dimension(1016, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DB1 DB = bMan.getStorageManager();

        if (jTextField1.equals("") && jTextField2.equals("")) {

        } else {
            this.setVisible(false);
            new Game().setVisible(true);
            
            try {
                DB.getGames();
            } catch (SQLException ex) {
                Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                DB.getID();
            } catch (SQLException ex) {
                Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            DB.toDB(jTextField1.getText(), jTextField2.getText(), vaikeus, alkuKassa);
            
            try {
                DB.LoadGame2(1);
            } catch (SQLException ex) {
                Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        vaikeus--;
        if (vaikeus == 0) {
            vaikeus = 1;
        }

        alkuKassa--;
        if (alkuKassa == 0) {
            alkuKassa = 1;
        }
        jLabel4.setText(NewGameHelp1.Vaikeus(vaikeus));
        jLabel5.setText("Start money: " + Integer.toString(NewGameHelp1.alkuKassa(alkuKassa)) + "K €");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        vaikeus++;
        if (vaikeus == 4) {
            vaikeus = 3;
        }

        alkuKassa++;
        if (alkuKassa == 4) {
            alkuKassa = 3;
        }
        jLabel4.setText(NewGameHelp1.Vaikeus(vaikeus));
        jLabel5.setText("Start money: " + Integer.toString(NewGameHelp1.alkuKassa(alkuKassa)) + "K €");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
