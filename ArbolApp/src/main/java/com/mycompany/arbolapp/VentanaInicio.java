/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.arbolapp;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
/**
 *
 * @author erick
 */
public class VentanaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    public VentanaInicio() {
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

        jPanel1 = new javax.swing.JPanel();
        PanelPrecargadas = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PanelBuscador = new javax.swing.JPanel();
        Buscadores = new javax.swing.JLabel();
        BuscarNombre = new javax.swing.JButton();
        BuscarTitulo = new javax.swing.JButton();
        BuscarGeneracion = new javax.swing.JButton();
        PanelJSON = new javax.swing.JPanel();
        btnSeleccionar = new javax.swing.JButton();
        AreaJson = new javax.swing.JTextField();
        PanelRegistro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        EspacioRegistro = new javax.swing.JTextField();
        EspacioRegistrado = new javax.swing.JTextField();
        PanelArbol = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPrecargadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PanelPrecargadas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Baratheon");
        PanelPrecargadas.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 110, 30));

        jButton1.setText("Targaryen");
        PanelPrecargadas.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 110, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Cargar");
        PanelPrecargadas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        jPanel1.add(PanelPrecargadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 170));

        PanelBuscador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PanelBuscador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Buscadores.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Buscadores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Buscadores.setText("Buscar Por:");
        PanelBuscador.add(Buscadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 16, 170, 30));

        BuscarNombre.setText("Nombre");
        PanelBuscador.add(BuscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 110, 30));

        BuscarTitulo.setText("Titulo");
        PanelBuscador.add(BuscarTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 110, 30));

        BuscarGeneracion.setText("Generacion");
        PanelBuscador.add(BuscarGeneracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 110, 30));

        jPanel1.add(PanelBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 170, 320));

        PanelJSON.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PanelJSON.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSeleccionar.setText("Buscar JSON");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        PanelJSON.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, -1));

        AreaJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AreaJsonActionPerformed(evt);
            }
        });
        PanelJSON.add(AreaJson, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 490, 20));

        jPanel1.add(PanelJSON, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 700, 50));

        PanelRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PanelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registro de:");
        PanelRegistro.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 30, 210, -1));

        EspacioRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EspacioRegistroActionPerformed(evt);
            }
        });
        PanelRegistro.add(EspacioRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 190, 350));
        PanelRegistro.add(EspacioRegistrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, -1));

        jPanel1.add(PanelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 210, 450));

        PanelArbol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PanelArbol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(PanelArbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 500, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed

        JFileChooser fileChooser = new JFileChooser();

        // Configurar filtro para archivos JSON
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos JSON (*.json)", "json");
        fileChooser.setFileFilter(filtro);

        // Mostrar el diálogo de selección de archivo
        int seleccion = fileChooser.showOpenDialog(this);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            File archivoSeleccionado = fileChooser.getSelectedFile();
            
            // Mostrar información del archivo seleccionado
            JOptionPane.showMessageDialog(this,
                "Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath(),
                "Información",
                JOptionPane.INFORMATION_MESSAGE);
                AreaJson.setText(archivoSeleccionado.getName());
        } else {
            // Si el usuario cancela la selección
            JOptionPane.showMessageDialog(this,
                "Selección cancelada.",
                "Información",
                JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void EspacioRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EspacioRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EspacioRegistroActionPerformed

    private void AreaJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AreaJsonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AreaJsonActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AreaJson;
    private javax.swing.JLabel Buscadores;
    private javax.swing.JButton BuscarGeneracion;
    private javax.swing.JButton BuscarNombre;
    private javax.swing.JButton BuscarTitulo;
    private javax.swing.JTextField EspacioRegistrado;
    private javax.swing.JTextField EspacioRegistro;
    private javax.swing.JPanel PanelArbol;
    private javax.swing.JPanel PanelBuscador;
    private javax.swing.JPanel PanelJSON;
    private javax.swing.JPanel PanelPrecargadas;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
