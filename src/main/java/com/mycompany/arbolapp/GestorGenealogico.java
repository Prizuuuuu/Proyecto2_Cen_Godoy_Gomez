/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author juan
 */
public class GestorGenealogico {

    private TablaHash tabla;
    public Persona personaRaiz;

    public GestorGenealogico(String rutaArchivoJson) throws IOException {
        tabla = new TablaHash();
        String contenidoJson = leerArchivoJson(rutaArchivoJson);
        procesarDatos(contenidoJson);

    }

    private void procesarDatos(String contenidoJson) {
        JSONObject root = new JSONObject(contenidoJson);

        for (String key : root.keySet()) {
            System.out.println("Procesando familia: " + key);
            JSONArray miembros = root.getJSONArray(key);
            System.out.println("Miembros: " + miembros.length());
            for (int i = 0; i < miembros.length(); i++) {
                JSONObject miembro = miembros.getJSONObject(i);
                procesarMiembro(miembro); // Crear la persona y agregarla a la tabla
            }
        }

        System.out.println("Tabla hash cargada con todas las personas.");
        tabla.probarBusqueda();
//        tabla.imprimirContenido();
        tabla.establecerRelaciones();
        imprimirComoArbol();

//        tabla.imprimirPapas();
//        tabla.imprimirHijos();
    }

    private void procesarMiembro(JSONObject miembro) {
        String nombre = miembro.keySet().iterator().next();
        JSONArray atributos = miembro.getJSONArray(nombre);
        Persona persona = new Persona(nombre.trim());

        // Procesar atributos de la persona
        for (int i = 0; i < atributos.length(); i++) {
            JSONObject atributo = atributos.getJSONObject(i);
            for (String clave : atributo.keySet()) {
                switch (clave) {
                    case "Of his name":
                        persona.setNumeral(atributo.getString(clave).trim());
                        break;
                    case "Known throughout as":
                        persona.setMote(atributo.getString(clave).trim());
                        break;
                    case "Born to":
                        String hijoDe = atributo.getString(clave).trim();
                        persona.agregarHijoDe(hijoDe);
                        break;
                    case "Father to":
                        JSONArray hijos = atributo.getJSONArray(clave);
                        for (int j = 0; j < hijos.length(); j++) {
                            String hijo = hijos.getString(j).trim();
                            persona.agregarPadreDe(hijo);
                        }
                        break;
                    case "Held title":
                        persona.setTitulo(atributo.getString(clave).trim());
                        break;
                    case "Of eyes":
                        persona.setColorOjos(atributo.getString(clave).trim());
                        break;
                    case "Of hair":
                        persona.setColorCabello(atributo.getString(clave).trim());
                        break;
                    case "Notes":
                        persona.setNotas(atributo.getString(clave).trim());
                        break;
                    case "Fate":
                        persona.setDestino(atributo.getString(clave).trim());
                        break;
                    default:
                        break;
                }
            }
        }

        // Insertar en la tabla hash con las claves necesarias
        tabla.insertarConClavesAdicionales(persona);
        if (personaRaiz == null && persona.getPadre() == null) {
            personaRaiz = persona;
            System.out.println("Estableciendo raíz del árbol: " + persona.getNombre());
        }
    }

    private String leerArchivoJson(String rutaArchivoJson) throws IOException {
        File archivo = new File(rutaArchivoJson);
        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        StringBuilder contenido = new StringBuilder();
        String linea;
        while ((linea = lector.readLine()) != null) {
            contenido.append(linea);
        }
        lector.close();
        return contenido.toString();
    }

    public void imprimirComoArbol() {
        if (personaRaiz == null) {
            System.out.println("No se ha establecido una raíz para el árbol.");
            return;
        }
        System.out.println("Imprmiendo como arbol.");
        imprimirSubarbol(personaRaiz, 0);
    }

    private void imprimirSubarbol(Persona persona, int nivel) {
        // Imprime la persona con indentación según el nivel
        for (int i = 0; i < nivel; i++) {
            System.out.print("--");
        }
        System.out.println(persona.getNombre());

        // Recorre sus hijos
        NodoHijo hijoActual = persona.getPrimerHijo();
        while (hijoActual != null) {
            imprimirSubarbol(hijoActual.hijo, nivel + 1);
            hijoActual = hijoActual.siguiente;
        }
    }

    public Graph getGrafo(Persona persona) {
        // Crear un grafo para representar el árbol
        Graph grafo = new SingleGraph("Árbol Genealógico");

        // Llamar al método recursivo para agregar nodos y aristas
        agregarNodoAlGrafo(grafo, persona);

        // Configuración visual del grafo
        grafo.setAttribute("ui.stylesheet", estiloGrafo());
        grafo.setAttribute("ui.quality");
        grafo.setAttribute("ui.antialias");

        return grafo;

    }

    // Método recursivo para agregar nodos y aristas al grafo
    public void agregarNodoAlGrafo(Graph grafo, Persona actual) {
        if (actual == null) {
            return;
        }

        // Agregar el nodo actual al grafo con su clave única
        String clave = actual.generarClavePrincipal();
        if (grafo.getNode(clave) == null) {
            grafo.addNode(clave).setAttribute("ui.label", actual.getNombre());
        }

        // Recorrer la lista de hijos y agregar aristas
        NodoHijo temp = actual.getPrimerHijo();
        while (temp != null) {
            if (temp.hijo == null) {
                System.out.println("[DEBUG] Hijo nulo encontrado para padre: " + clave);
                temp = temp.siguiente;
                continue;
            }

            String claveHijo = temp.hijo.generarClavePrincipal();
            if (grafo.getNode(claveHijo) == null) {
                grafo.addNode(claveHijo).setAttribute("ui.label", temp.hijo.getNombre() + " (" + claveHijo + ")");
                System.out.println("[DEBUG] Nodo agregado: " + claveHijo + " (" + temp.hijo.getNombre() + ")");
            }
            if (grafo.getEdge(clave + "-" + claveHijo) == null) {
                grafo.addEdge(clave + "-" + claveHijo, clave, claveHijo, true); // Arista dirigida
                System.out.println("[DEBUG] Arista agregada: " + clave + " -> " + claveHijo);
            }
            agregarNodoAlGrafo(grafo, temp.hijo); // Llamada recursiva para los hijos
            temp = temp.siguiente;
        }
    }

    // Método para definir el estilo visual del grafo
    private String estiloGrafo() {
        return """
            node {
                fill-color: lightblue;
                size: 15px;
                text-size: 11px;
                text-color: black;
            }
            edge {
                fill-color: gray;
                arrow-size: 10px, 7px;
            }
        """;
    }

    public Persona buscar(String clave) {
        return tabla.buscar(clave);
    }

    public Persona[] buscarPorNombreParcial(String clave) {
        return tabla.buscarPorNombreParcial(clave);
    }
}
