/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolapp;

/**
 *
 * @author erick
 */
public class Persona {
    private String nombre;
    private Persona padre;
    private NodoHijo primerHijo; // Inicio de la lista enlazada de hijos

    public Persona(String nombre) {
        this.nombre = nombre;
        this.primerHijo = null; // Inicialmente no tiene hijos
        this.padre = null;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getPadre() {
        return padre;
    }

    public NodoHijo getPrimerHijo() {
        return primerHijo;
    }

    public boolean agregarHijo(Persona hijo) {
        NodoHijo nuevoNodo = new NodoHijo(hijo);
        if (primerHijo == null) {
            primerHijo = nuevoNodo; // Si no hay hijos, este es el primer hijo
        } else {
            NodoHijo temp = primerHijo;
            while (temp.siguiente != null) {
                temp = temp.siguiente; // Recorrer hasta el final de la lista
            }
            temp.siguiente = nuevoNodo; // Agregar al final de la lista
        }
        hijo.padre = this; // Establecer la relación padre-hijo
        return true;
    }
}
