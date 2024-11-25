/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.arbolapp;

/**
 *
 * @author Godoy
 */
public class BusquedaPorNombre extends javax.swing.JFrame {
    private final GestorGenealogico gestorGenealogico;
    /**
     * Creates new form BusquedaPorNombre
     * @param gestorGenealogico
     */
    public BusquedaPorNombre(GestorGenealogico gestorGenealogico) {
        this.gestorGenealogico = gestorGenealogico;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private VentanaInicio vPrincipal;

    public void setvPrincipal(VentanaInicio vPrincipal) {
        this.vPrincipal = vPrincipal;
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
        jPanel2 = new javax.swing.JPanel();
        Nombre = new javax.swing.JTextField();
        btnNombre = new javax.swing.JButton();
        ListaNombres = new javax.swing.JComboBox<>();
        btnMostrarRegistroNombre = new javax.swing.JButton();
        btnMostrarAncentrosNombre = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        PanelRegistro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        informacionRegistro = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreActionPerformed(evt);
            }
        });
        jPanel2.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, 20));

        btnNombre.setText("Buscar");
        btnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNombreActionPerformed(evt);
            }
        });
        jPanel2.add(btnNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, -1));

        ListaNombres.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(ListaNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, -1));

        btnMostrarRegistroNombre.setText("Mostrar registros");
        btnMostrarRegistroNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarRegistroNombreActionPerformed(evt);
            }
        });
        jPanel2.add(btnMostrarRegistroNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 140, -1));

        btnMostrarAncentrosNombre.setText("Mostrar Ancestros");
        jPanel2.add(btnMostrarAncentrosNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 140, -1));

        jLabel1.setText("Busca un nombre");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jLabel3.setText("Selecciona un");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 10));

        jLabel4.setText("intengrante");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel2.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 480));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        PanelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Informacion de Registro:");
        PanelRegistro.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 30, 210, -1));

        informacionRegistro.setColumns(20);
        informacionRegistro.setLineWrap(true);
        informacionRegistro.setRows(5);
        jScrollPane1.setViewportView(informacionRegistro);

        PanelRegistro.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 51, 170, 380));

        jPanel3.add(PanelRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 210, 480));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 720, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreActionPerformed

    private void btnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNombreActionPerformed
        Persona[] personas = gestorGenealogico.buscarPorNombreParcial(Nombre.getText());
        for(Persona persona: personas) {
            System.out.println(persona.getNombre());
        }
    }//GEN-LAST:event_btnNombreActionPerformed

    private void btnMostrarRegistroNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarRegistroNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarRegistroNombreActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        vPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ListaNombres;
    private javax.swing.JTextField Nombre;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JButton btnMostrarAncentrosNombre;
    private javax.swing.JButton btnMostrarRegistroNombre;
    private javax.swing.JButton btnNombre;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTextArea informacionRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}