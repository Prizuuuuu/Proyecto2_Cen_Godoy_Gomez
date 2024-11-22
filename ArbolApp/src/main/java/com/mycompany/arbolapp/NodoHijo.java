/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolapp;

/**
 *
 * @author Godoy
 */
class NodoHijo {

    Persona hijo;
    NodoHijo siguiente;

    public NodoHijo(Persona hijo) {
        this.hijo = hijo;
        this.siguiente = null;
    }
}
