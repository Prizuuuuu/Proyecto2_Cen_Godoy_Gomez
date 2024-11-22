package com.mycompany.arbolapp;

package com.mycompany.arbolapp.interfaz;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto2;

import java.io.BufferedReader;
import javax.swing.JFileChooser;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;


/**
 *
 * @author erick
 */
public class Interfaz1 extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz1
     */
    public Interfaz1() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Siguiente = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        BTNsiguiente = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        BTNcargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Siguiente.setBackground(new java.awt.Color(153, 204, 255));
        Siguiente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        Siguiente.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 510, 230));

        BTNsiguiente.setText("Siguiente");
        BTNsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNsiguienteActionPerformed(evt);
            }
        });
        Siguiente.add(BTNsiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, -1, -1));

        jTextField1.setBackground(new java.awt.Color(255, 0, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("IMPORTANTE: Este programa solo puede leer archivos de tipo .json");
        Siguiente.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 30));

        BTNcargar.setText("Cargar");
        BTNcargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNcargarActionPerformed(evt);
            }
        });
        Siguiente.add(BTNcargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        getContentPane().add(Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNsiguienteActionPerformed
        Interfaz2 p2 = new Interfaz2(json);
        p2.setP1(this);
        p2.setVisible(true);
        this.setVisible(false);
    }            
    }//GEN-LAST:event_BTNsiguienteActionPerformed

    private void BTNcargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNcargarActionPerformed
//     Creamos el objeto JFileChooser.
        JFileChooser cargar = new JFileChooser();

        // Se abre la ventana y se guarda la opción seleccionada por el usuario.
        int seleccionar = cargar.showOpenDialog(this);

        if (seleccionar == JFileChooser.APPROVE_OPTION) {
            File archivo = cargar.getSelectedFile();
            this.Path.setText(archivo.getAbsolutePath());

            // Lectura y parseo del JSON
            try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
                StringBuilder contenidoJson = new StringBuilder();
                String linea;

                while ((linea = leer.readLine()) != null) {
                    System.out.println("Contenido linea:");
                    System.out.println(linea);

                    contenidoJson.append(linea);
                }

                // Parsear el JSON
                json = new JSONObject(contenidoJson.toString());

                // Guardar en una variable y mostrar en consola
//            String primeraClave = json.keys().next(); // Esto obtiene la primera clave directamente
//            JSONArray jsonArray = json.getJSONArray(primeraClave);
                String jsonLiteral = json.toString(4); // `4` para formato de impresión legible
                System.out.println("Contenido JSON:");
                System.out.println(jsonLiteral);

                // Mostrar en el componente de la UI
                this.Contenido.setText(jsonLiteral);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }        // TODO add your handling code here:
    }//GEN-LAST:event_BTNcargarActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNcargar;
    private javax.swing.JButton BTNsiguiente;
    private javax.swing.JPanel Siguiente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
