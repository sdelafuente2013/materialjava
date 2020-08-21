/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertarDatos;

import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Invitado
 */
public class JFrame extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Titulo = new javax.swing.JLabel();
        lbl_id = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        btn_insertar = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        lbl_apellido = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_Titulo.setText("Insertar Datos");

        lbl_id.setText("ID");

        lbl_nombre.setText("Nombre");

        btn_insertar.setText("Insertar");
        btn_insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertarActionPerformed(evt);
            }
        });

        txt_id.setToolTipText("");

        lbl_apellido.setText("Apellido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_insertar)
                            .addComponent(lbl_Titulo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_apellido)
                                .addGap(18, 18, 18)
                                .addComponent(txt_apellido))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_nombre)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_id)
                                        .addGap(44, 44, 44)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE))
                                    .addComponent(txt_nombre))))))
                .addGap(206, 206, 206))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nombre)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_apellido)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(btn_insertar)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertarActionPerformed
        // TODO add your handling code here:
        Conectar cc= new Conectar();
        Connection cn= cc.conexion();
        
        try {
            PreparedStatement pst=cn.prepareStatement("INSERT INTO persona (idPersona,nombre,apellido) VALUES (?,?,?)");
            pst.setString(1,txt_id.getText());
            pst.setString(2, txt_nombre.getText());
            pst.setString(3, txt_apellido.getText());
            
            int actualizacion = pst.executeUpdate();
            if (actualizacion > 0) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");                
            }
            else {
                JOptionPane.showMessageDialog(null, "Error al agregar"); 
            
            }            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar.\n"+e.getMessage()); 
        }
    }//GEN-LAST:event_btn_insertarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }
    
    
/*Notar que se modificaron las variables de referencia de los objetos del formulario para una 
    rapida identificacion 
    JLabel1 => lbl_Titulo
    JTextField1 => txt_id
    etcetera*/
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_insertar;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JLabel lbl_apellido;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
