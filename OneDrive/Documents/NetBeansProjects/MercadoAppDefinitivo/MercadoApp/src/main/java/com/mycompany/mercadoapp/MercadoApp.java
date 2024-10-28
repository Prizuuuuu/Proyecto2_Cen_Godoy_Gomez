/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mercadoapp;

import com.mycompany.mercadoapp.interfaces.Interface;

/**
 * Clase principal de la aplicación MercadoApp.
 *
 * Esta clase inicia la aplicación al crear una instancia de la ventana
 * principal (Interface) y hacerla visible. La aplicación está diseñada para
 * gestionar la interfaz gráfica del usuario y permitir la visualización y
 * manipulación de datos en formato JSON relacionados con redes de transporte.
 *
 * @author juan
 */
public class MercadoApp {

    /**
     * Método principal que inicia la ejecución de la aplicación.
     *
     * Este método crea una nueva instancia de la clase `Interface`, que
     * representa la ventana principal de la aplicación, y la hace visible al
     * usuario.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en esta
     * aplicación)
     */
    public static void main(String[] args) {
        Interface ventana = new Interface();
        ventana.setVisible(true);
    }
}
