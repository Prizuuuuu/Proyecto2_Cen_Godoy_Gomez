/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolapp;

/**
 *
 * @author Godoy
 */
class TablaHash {

    private NodoHash[] tabla;   // Array de nodos (encadenamiento para colisiones)
    private int tamanio;        // Tamaño actual de la tabla
    private int numElementos;   // Cantidad de elementos almacenados
    private static final double FACTOR_CARGA = 0.75; // Factor de carga para redimensionar

    // Constructor: tamaño inicial pequeño
    public TablaHash() {
        this.tamanio = 10; // Tamaño inicial
        this.tabla = new NodoHash[tamanio];
        this.numElementos = 0;
    }

    // Clase interna para representar un nodo de la tabla hash
    private static class NodoHash {

        String clave;
        Persona valor;
        NodoHash siguiente;

        NodoHash(String clave, Persona valor) {
            this.clave = clave;
            this.valor = valor;
            this.siguiente = null;
        }
    }

    // Función hash básica: convierte la clave en un índice
    private int hash(String clave) {
        int hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash = (31 * hash + clave.charAt(i)); // Función hash usando multiplicación
        }
        return Math.abs(hash) % tamanio;
    }

    // Método para insertar un valor en la tabla hash
    public void insertar(String clave, Persona valor) {
        if ((double) numElementos / tamanio >= FACTOR_CARGA) {
            redimensionar(); // Redimensionar si se alcanza el factor de carga
        }

        int indice = hash(clave);
        NodoHash nuevoNodo = new NodoHash(clave, valor);

        // Si no hay colisión, insertar directamente
        if (tabla[indice] == null) {
            tabla[indice] = nuevoNodo;
        } else {
            // Manejo de colisiones por encadenamiento
            NodoHash actual = tabla[indice];
            while (actual.siguiente != null) {
                if (actual.clave.equals(clave)) {
                    actual.valor = valor; // Actualizar si la clave ya existe
                    return;
                }
                actual = actual.siguiente;
            }
            if (actual.clave.equals(clave)) {
                actual.valor = valor; // Actualizar si la clave ya existe
                return;
            }
            actual.siguiente = nuevoNodo;
        }
        numElementos++;
    }

    // Método para buscar un valor en la tabla hash por clave
    public Persona buscar(String clave) {
        int indice = hash(clave);
        NodoHash actual = tabla[indice];
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null; // No encontrado
    }

    // Método para redimensionar la tabla cuando se alcanza el factor de carga
    private void redimensionar() {
        int nuevoTamanio = tamanio * 2; // Duplicar el tamaño
        NodoHash[] nuevaTabla = new NodoHash[nuevoTamanio];

        // Rehashing: recalcular las posiciones de todos los elementos
        for (int i = 0; i < tamanio; i++) {
            NodoHash actual = tabla[i];
            while (actual != null) {
                NodoHash siguiente = actual.siguiente; // Guardar referencia al siguiente nodo
                int nuevoIndice = Math.abs(actual.clave.hashCode()) % nuevoTamanio;

                // Insertar en la nueva tabla
                actual.siguiente = nuevaTabla[nuevoIndice];
                nuevaTabla[nuevoIndice] = actual;

                // Avanzar al siguiente nodo
                actual = siguiente;
            }
        }

        // Reemplazar la tabla antigua con la nueva
        this.tabla = nuevaTabla;
        this.tamanio = nuevoTamanio;
    }
}
