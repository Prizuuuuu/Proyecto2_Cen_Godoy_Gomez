/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolapp;

/**
 *
 * @author Godoy
 */
public class ArbolApp {

    public static void main(String[] args) {
         // JOptionPane.showMessageDialog();
       System.setProperty("org.graphstream.ui", "swing");
        // Crear el árbol genealógico
        Persona abuelo = new Persona("Juan");
        ArbolGenealogico arbol = new ArbolGenealogico(abuelo);

        // Crear la tabla hash personalizada
        TablaHash tablaHash = new TablaHash(); // Tabla hash dinámica

        // Agregar personas al árbol y a la tabla hash
        Persona carlos = new Persona("Carlos");
        Persona ana = new Persona("Ana");
        Persona luis = new Persona("Luis");

        arbol.agregarPersona("Juan", carlos);  // Carlos es hijo de Juan
        arbol.agregarPersona("Juan", ana);    // Ana es hija de Juan
        arbol.agregarPersona("Carlos", luis); // Luis es hijo de Carlos

        tablaHash.insertar("Juan", abuelo);
        tablaHash.insertar("Carlos", carlos);
        tablaHash.insertar("Ana", ana);
        tablaHash.insertar("Luis", luis);

        // Buscar personas en la tabla hash
        Persona buscada1 = tablaHash.buscar("Carlos");
        Persona buscada2 = tablaHash.buscar("Luis");
        Persona buscada3 = tablaHash.buscar("Maria");

        System.out.println("Resultados de búsqueda en la Tabla Hash:");
        System.out.println(buscada1 != null ? "Encontrado: " + buscada1.getNombre() : "Carlos no encontrado");
        System.out.println(buscada2 != null ? "Encontrado: " + buscada2.getNombre() : "Luis no encontrado");
        System.out.println(buscada3 != null ? "Encontrado: " + buscada3.getNombre() : "Maria no encontrada");

        arbol.pintarArbol();
    }
}
