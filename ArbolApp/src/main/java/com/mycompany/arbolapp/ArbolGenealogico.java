/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolapp;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

/**
 *
 * @author erick
 */
class ArbolGenealogico implements ViewerListener {

    boolean loop = true;
    private Persona raiz;

    public ArbolGenealogico(Persona raiz) {
        this.raiz = raiz;
    }

    public Persona getRaiz() {
        return raiz;
    }

    public boolean agregarPersona(String nombrePadre, Persona nuevaPersona) {
        Persona padre = buscarPorNombre(raiz, nombrePadre);
        if (padre != null) {
            return padre.agregarHijo(nuevaPersona);
        }
        return false; // Padre no encontrado
    }

    private Persona buscarPorNombre(Persona actual, String nombre) {
        if (actual == null) {
            return null;
        }
        if (actual.getNombre().equalsIgnoreCase(nombre)) {
            return actual;
        }
        NodoHijo temp = actual.getPrimerHijo();
        while (temp != null) {
            Persona encontrado = buscarPorNombre(temp.hijo, nombre); // Búsqueda recursiva
            if (encontrado != null) {
                return encontrado;
            }
            temp = temp.siguiente; // Avanzar al siguiente hijo
        }
        return null;
    }

    // Método para pintar el árbol usando GraphStream
    public void pintarArbol() {

        // Crear un grafo para representar el árbol
        Graph grafo = new SingleGraph("Árbol Genealógico");

        // Llamar al método recursivo para agregar nodos y aristas
        agregarNodoAlGrafo(grafo, raiz);

        // Configuración visual del grafo
        grafo.setAttribute("ui.stylesheet", estiloGrafo());
        grafo.setAttribute("ui.quality");
        grafo.setAttribute("ui.antialias");

        // Mostrar el grafo
        Viewer viewer = grafo.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);

        ViewerPipe viewerPipe = viewer.newViewerPipe();
        viewerPipe.addViewerListener(this);
        viewerPipe.addSink(grafo);

        while (loop) {
            viewerPipe.pump();
        }
    }

    @Override
    public void viewClosed(String id) {
        loop = false;
    }

    @Override
    public void buttonPushed(String id) {
    }

    // Método recursivo para agregar nodos y aristas al grafo
    private void agregarNodoAlGrafo(Graph grafo, Persona actual) {
        if (actual == null) {
            return;
        }

        // Agregar el nodo actual al grafo
        if (grafo.getNode(actual.getNombre()) == null) {
            grafo.addNode(actual.getNombre()).setAttribute("ui.label", actual.getNombre());
        }

        // Recorrer la lista de hijos y agregar aristas
        NodoHijo temp = actual.getPrimerHijo();
        while (temp != null) {
            if (grafo.getNode(temp.hijo.getNombre()) == null) {
                grafo.addNode(temp.hijo.getNombre()).setAttribute("ui.label", temp.hijo.getNombre());
            }
            grafo.addEdge(actual.getNombre() + "-" + temp.hijo.getNombre(),
                    actual.getNombre(), temp.hijo.getNombre(), true); // Arista dirigida
            agregarNodoAlGrafo(grafo, temp.hijo); // Llamada recursiva para los hijos
            temp = temp.siguiente;
        }
    }

    // Método para definir el estilo visual del grafo
    private String estiloGrafo() {
        return """
            node {
                fill-color: lightblue;
                size: 30px;
                text-size: 14px;
                text-color: black;
                text-style: bold;
            }
            edge {
                fill-color: gray;
                arrow-size: 10px, 7px;
            }
        """;
    }

    @Override
    public void buttonReleased(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}