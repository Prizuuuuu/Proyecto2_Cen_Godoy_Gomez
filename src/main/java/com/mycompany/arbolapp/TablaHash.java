/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolapp;

/**
 *
 * @author juan
 */
class TablaHash {

    private NodoHash[] tabla;
    private int tamanio;
    private int numElementos;
    private static final double FACTOR_CARGA = 0.75;

    public TablaHash() {
        this.tamanio = 37; // Tamaño inicial de la tabla hash
        this.tabla = new NodoHash[tamanio];
        this.numElementos = 0;
    }

 

    private int hash(String clave) {
        int hash = 0;
        for (int i = 0; i < clave.length(); i++) {
            hash = (31 * hash + clave.charAt(i));
        }
        return Math.abs(hash) % tamanio;
    }

    private String normalizarClave(String clave) {
        return clave == null ? null : clave.trim().toLowerCase();
    }

    public void insertar(String clave, Persona persona) {
        clave = normalizarClave(clave);

        if ((double) numElementos / tamanio >= FACTOR_CARGA) {
            redimensionar();
        }

        int indice = hash(clave);
        NodoHash nuevoNodo = new NodoHash(clave, persona);
        if (tabla[indice] == null) {
            System.out.println("Insertando clave: " + clave + " en índice: " + indice);
            tabla[indice] = nuevoNodo;
        } else {
            NodoHash actual = tabla[indice];
            while (actual.siguiente != null) {
                if (actual.clave.equals(clave)) {
                    actual.valor = persona;
                    System.out.println("Actualizando clave existente: " + clave + " en índice: " + indice);
                    return;
                }
                actual = actual.siguiente;
            }
            if (actual.clave.equals(clave)) {
                actual.valor = persona;
                System.out.println("Actualizando clave existente (final de lista): " + clave + " en índice: " + indice);
                return;
            }
            System.out.println("Insertando clave en colisión: " + clave + " en índice: " + indice);
            actual.siguiente = nuevoNodo;
        }
        numElementos++;
    }

    public Persona buscar(String clave) {
        clave = normalizarClave(clave);

        int indice = hash(clave);
        NodoHash actual = tabla[indice];
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    private void redimensionar() {
        int nuevoTamanio = tamanio * 2;
        NodoHash[] nuevaTabla = new NodoHash[nuevoTamanio];
        for (int i = 0; i < tamanio; i++) {
            NodoHash actual = tabla[i];
            while (actual != null) {
                NodoHash siguiente = actual.siguiente;
                int nuevoIndice = hash(actual.clave) % nuevoTamanio;
                actual.siguiente = nuevaTabla[nuevoIndice];
                nuevaTabla[nuevoIndice] = actual;
                actual = siguiente;
            }
        }
        this.tabla = nuevaTabla;
        this.tamanio = nuevoTamanio;
    }

    public void insertarConClavesAdicionales(Persona persona) {
        // Clave principal (nombre + numeral)
        String clavePrincipal = persona.getNombre() + ", " + persona.getNumeral() + " of his name";
        insertarSiNoExiste(clavePrincipal, persona);

        // Clave por mote
        if (persona.getMote() != null && !persona.getMote().isEmpty()) {
            insertarSiNoExiste(persona.getMote(), persona);
        }
    }

    private void insertarSiNoExiste(String clave, Persona persona) {
        if (buscar(clave) == null) { // Evita duplicados
            insertar(clave, persona);
        } else {
            System.out.println("Clave ya existente: " + clave + ". No se volverá a insertar.");
        }
    }

    public void imprimirContenido() {
        System.out.println("Imprimiendo contenido");
        for (int i = 0; i < tamanio; i++) {
            NodoHash actual = tabla[i];
            while (actual != null) {
                System.out.println("Índice " + i + ": [" + actual.clave + ": " + actual.valor.getNombre() + "] -> ");
                actual = actual.siguiente;
            }
        }
        System.out.println("Número total de elementos: " + numElementos);
    }

    public void establecerRelaciones() {
        for (int i = 0; i < tamanio; i++) {
            NodoHash actual = tabla[i];
            while (actual != null) {
                Persona persona = actual.valor;
                for (String hijoDe : persona.getHijoDe()) {
                    if (hijoDe == null) {
                        continue;
                    }
                    System.out.println("Buscando padre: " + hijoDe + " para " + persona.getNombre());
                    System.out.println("Buscando padre por hijoDe");
                    Persona padre = buscar(hijoDe);

                    if (padre == null) {
                        System.out.println("Buscando padre por nonbre");
                        padre = buscarPorNombre(hijoDe);
                    }

                    if (padre != null) {
                        // Asignar relaciones padre-hijo
//                        persona.setPadre(padre);
                        padre.agregarHijo(persona);
//                        System.out.println(padre.getNombre() + " es el padre de " + persona.getNombre());
                    } else {
                        System.out.println("Padre no encontrado para: " + persona.getNombre());
                    }
                }
                actual = actual.siguiente;
            }
        }
        System.out.println("Relaciones padre-hijo establecidas.");
    }

    public void imprimirHijos() {
        System.out.println("Imprimiendo hijos:");
        for (int i = 0; i < tamanio; i++) {
            NodoHash actual = tabla[i];
            while (actual != null) {
                Persona persona = actual.valor;
                NodoHijo hijoActual = persona.getPrimerHijo();
                if (hijoActual == null) {
                    System.out.println(persona.getNombre() + " no tiene hijos.");
                } else {
                    System.out.println("Hijos de " + persona.getNombre() + ":");
                    while (hijoActual != null) {
                        System.out.println("-- " + hijoActual.hijo.getNombre());
                        hijoActual = hijoActual.siguiente;
                    }
                }
                actual = actual.siguiente;
            }
        }
    }

    public void probarBusqueda() {
        System.out.println("\nProbando búsqueda...");
        for (int i = 0; i < tamanio; i++) {
            NodoHash actual = tabla[i];
            while (actual != null) {
                Persona persona = actual.valor;

                // Buscar por clave principal (nombre + numeral)
//                String clavePrincipal = persona.getNombre() + ", " + persona.getNumeral() + " of his name";
                String clavePrincipal = persona.generarClavePrincipal();
                Persona encontrada = buscar(clavePrincipal);
                if (encontrada != null) {
                    System.out.println("Clave compuesta encontrada correctamente: " + clavePrincipal);
                } else {
                    System.out.println("Clave compuesta NO encontrada: " + clavePrincipal);
                }

                // Buscar por mote (si existe)
                if (persona.getMote() != null && !persona.getMote().isEmpty()) {
                    String claveMote = persona.getMote();
                    encontrada = buscar(claveMote);
                    if (encontrada != null) {
                        System.out.println("Clave por mote encontrada correctamente: " + claveMote);
                    } else {
                        System.out.println("Clave por mote NO encontrada: " + claveMote);
                    }
                }

                actual = actual.siguiente;
            }
        }
    }

    public Persona buscarPorNombre(String nombre) {
        for (int i = 0; i < tamanio; i++) { // Recorremos todos los índices de la tabla
            NodoHash actual = tabla[i]; // Accedemos al nodo inicial del índice
            while (actual != null) { // Iteramos sobre los nodos en la lista enlazada
                if (actual.valor.getNombre().equalsIgnoreCase(nombre)) { // Comparamos el nombre
                    return actual.valor; // Retornamos si encontramos el nombre
                }
                actual = actual.siguiente; // Avanzamos al siguiente nodo en la lista
            }
        }
        return null; // Retornamos null si no encontramos el nombre
    }
    
    public Persona[] buscarPorNombreParcial(String fragmento) {
    fragmento = fragmento.toLowerCase(); // Convertimos el fragmento a minúsculas para comparación
    Persona[] resultados = new Persona[tamanio]; // Array con tamaño máximo igual al número de elementos posibles
    int cantidad = 0; // Contador de resultados

    for (int i = 0; i < tamanio; i++) { // Recorremos todos los índices de la tabla
        NodoHash actual = tabla[i]; // Accedemos al nodo inicial del índice
        while (actual != null) { // Iteramos sobre los nodos en la lista enlazada
            if (actual.valor.getNombre().toLowerCase().contains(fragmento)) { // Verificamos si contiene el fragmento
                resultados[cantidad] = actual.valor; // Agregamos la persona al array
                cantidad++; // Incrementamos el contador de resultados
            }
            actual = actual.siguiente; // Avanzamos al siguiente nodo en la lista
        }
    }

    // Creamos un array ajustado al tamaño real de resultados
    Persona[] resultadosFinales = new Persona[cantidad];
    for (int i = 0; i < cantidad; i++) {
        resultadosFinales[i] = resultados[i];
    }

    return resultadosFinales;
}
}
