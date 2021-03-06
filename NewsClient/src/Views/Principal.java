/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import Code.LoggedPrintStream;
import Code.NewsInterface;
import java.rmi.Naming;
import java.util.*;
import javax.swing.JLabel;

/**
 *
 * @author oscar
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.jlbPutIP.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jlbPutIP = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfIPServer = new javax.swing.JTextField();
        btIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsernameActionPerformed(evt);
            }
        });

        jLabel3.setText("Username");

        jlbPutIP.setForeground(new java.awt.Color(255, 0, 0));
        jlbPutIP.setText("Campos Vacíos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Notizas Cliente");

        jLabel1.setText("IP del Servidor");

        tfIPServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIPServerActionPerformed(evt);
            }
        });

        btIniciar.setText("Iniciar");
        btIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btIniciarMouseClicked(evt);
            }
        });
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(btIniciar)
                .addContainerGap(210, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(jLabel4)
                    .addContainerGap(188, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(81, 81, 81)
                            .addComponent(tfIPServer, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(105, 105, 105)
                            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jlbPutIP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(63, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addComponent(btIniciar)
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1, 1, 1)
                    .addComponent(jLabel4)
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(tfIPServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jlbPutIP)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsernameActionPerformed

    private void tfIPServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIPServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIPServerActionPerformed

    private void btIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btIniciarMouseClicked
        try {
            if (this.tfIPServer.getText().equals("")||this.tfUsername.getText().equals("")) {
                this.jlbPutIP.setVisible(true);
            } else {
                String ip = this.tfIPServer.getText();
                String user = this.tfUsername.getText();
                NewsInterface News = (NewsInterface) Naming.lookup("rmi://" + ip + ":1099/NEWS");
                String result = News.getNoticias(user);
                String s = "Cliente Conectado: ";
                News.send(s+user);
                LoggedPrintStream lpsOut = LoggedPrintStream.create(System.out);
                System.setOut(lpsOut);

                //System.out.println(result);

                StringTokenizer tokens = new StringTokenizer(result, "#");
                int i = 0;
                String[] texto = new String[5];
                while (tokens.hasMoreTokens()) {
                    //System.out.println(tokens.nextToken());
                    texto[i] = tokens.nextToken();
                    i++;
                }

                System.out.println("/////");
                dispose();

                Notizas noticia = new Notizas();
                noticia.setTitle("Lector de Noticias");
                noticia.setVisible(true);

                noticia.jLabel3.setText(texto[0]);
                noticia.jLabel4.setText(texto[1]);
                noticia.jLabel7.setText(texto[2]);
                noticia.jLabel8.setText(texto[3]);
                noticia.jLabel11.setText(texto[4]);

            }
        } catch (Exception e) {
            System.out.println("Server failed: " + e);
        }
    }//GEN-LAST:event_btIniciarMouseClicked

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btIniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jlbPutIP;
    private javax.swing.JTextField tfIPServer;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
