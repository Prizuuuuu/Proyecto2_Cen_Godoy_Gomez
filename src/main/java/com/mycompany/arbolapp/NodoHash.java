/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolapp;

/**
 *
 * @author juan
 */
public class NodoHash {

    String clave;
    Persona valor;
    NodoHash siguiente;

    NodoHash(String clave, Persona valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
