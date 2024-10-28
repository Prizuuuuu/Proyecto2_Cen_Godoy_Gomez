package com.mycompany.mercadoapp.funcionalidades;

import org.graphstream.graph.Graph;

/**
 * Clase que representa un grafo de paradas en una red de transporte,
 * con funcionalidades para manipular y visualizar conexiones entre paradas.
 * Permite agregar paradas, conexiones y líneas, así como gestionar paradas seleccionadas.
 * 
 * @author juan
 */
public class Grafo {

    /** Array de paradas del grafo */
    public Parada[] paradas;

    /** Cantidad de paradas actuales en el grafo */
    public int paradasCount = 0;

    /** Alcance máximo para la cobertura de una estación */
    public int statationReachable = 0;

    /** Grafo visual para la representación de paradas y conexiones */
    public Graph graph;

    /** Arreglo para almacenar las paradas seleccionadas */
    private String[] paradasSeleccionadas = new String[100];

    /** Cantidad de paradas actualmente seleccionadas */
    private int seleccionadasCount = 0;

    /**
     * Constructor para inicializar el grafo con un límite de paradas.
     * 
     * @param maxParadas Número máximo de paradas que puede contener el grafo
     */
    public Grafo(int maxParadas) {
        paradas = new Parada[maxParadas];
    }

    /**
     * Limpia la lista de paradas seleccionadas y reinicia los colores de los nodos en el grafo.
     */
    public void limpiarParadasSeleccionadas() {
        for (int i = 0; i < seleccionadasCount; i++) {
            paradasSeleccionadas[i] = null;
        }
        resetNodeColors();
        seleccionadasCount = 0;
    }

    /**
     * Agrega una parada a la lista de paradas seleccionadas, evitando duplicados.
     * 
     * @param id Identificador de la parada a agregar
     */
    public void agregarParadaSeleccionada(String id) {
        for (int i = 0; i < seleccionadasCount; i++) {
            if (paradasSeleccionadas[i].equals(id)) {
                return; // Evitar duplicados
            }
        }
        paradasSeleccionadas[seleccionadasCount++] = id;
    }

    /**
     * Verifica si una parada está seleccionada.
     * 
     * @param id Identificador de la parada a verificar
     * @return true si la parada está seleccionada, false en caso contrario
     */
    public boolean esParadaSeleccionada(String id) {
        for (int i = 0; i < seleccionadasCount; i++) {
            if (paradasSeleccionadas[i].equals(id)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca una parada en el grafo por su identificador.
     * 
     * @param id Identificador de la parada a buscar
     * @return La instancia de Parada si se encuentra, o null en caso contrario
     */
    public Parada findStation(String id) {
        for (int i = 0; i < paradasCount; i++) {
            if (paradas[i].id.equals(id)) {
                return paradas[i];
            }
        }
        return null;
    }

    /**
     * Agrega una nueva parada al grafo o actualiza el color de línea de una parada existente.
     * 
     * @param id         Identificador de la parada
     * @param lineColor  Color de la línea a la que pertenece la parada
     * @param maxNeighbors Cantidad máxima de conexiones que puede tener la parada
     * @return La parada agregada o actualizada
     */
    public Parada addStation(String id, String lineColor, int maxNeighbors) {
        Parada station = findStation(id);
        if (station == null) {
            station = new Parada(id, lineColor, maxNeighbors);
            paradas[paradasCount++] = station;
        } else if (!station.colorLinea.equals("black") && !station.colorLinea.equals(lineColor)) {
            station.colorLinea = "black";  // Cambia el color a negro si la estación pertenece a múltiples líneas
        }
        return station;
    }

    /**
     * Crea una conexión bidireccional entre dos paradas.
     * 
     * @param from Parada de origen
     * @param to   Parada de destino
     */
    public void addConnection(Parada from, Parada to) {
        from.conectarParada(to);
        to.conectarParada(from);
    }

    /**
     * Restaura el color de todos los nodos del grafo al color negro.
     */
    public void resetNodeColors() {
        for (int i = 0; i < paradasCount; i++) {
            Parada station = paradas[i];
            graph.getNode(station.id).setAttribute("ui.style", "fill-color: black; size: 20px;");
        }
    }

    /**
     * Agrega una nueva línea de estaciones al grafo a partir de una estación de conexión y un arreglo de nombres de estaciones.
     * 
     * @param estacionConexion Nombre de la estación a la que se conectará la nueva línea
     * @param nuevasEstaciones Array de nombres de estaciones de la nueva línea
     * @param colorLinea       Color de la línea de las nuevas estaciones
     */
    public void agregarLineaNueva(String estacionConexion, String[] nuevasEstaciones, String colorLinea) {
        Parada paradaConexion = findStation(estacionConexion);
        if (paradaConexion == null) {
            System.out.println("La estación de conexión no existe en el grafo.");
            return;
        }

        Parada paradaAnterior = paradaConexion; // Empezar desde la estación de conexión
        for (String nombreEstacion : nuevasEstaciones) {
            Parada nuevaParada = addStation(nombreEstacion, colorLinea, 10);
            addConnection(paradaAnterior, nuevaParada);
            paradaAnterior = nuevaParada;
        }
        refrescarGrafo();
    }

    /**
     * Refresca el grafo visualmente para reflejar cualquier cambio en las conexiones o estaciones.
     */
    private void refrescarGrafo() {
        graph.clear(); // Limpiar nodos y aristas existentes

        for (int i = 0; i < paradasCount; i++) {
            Parada station = paradas[i];
            if (graph.getNode(station.id) == null) {
                graph.addNode(station.id).setAttribute("ui.label", station.id);
                graph.getNode(station.id).setAttribute("ui.style", "fill-color: " + station.colorLinea + "; size: 20px;");
            }
        }

        for (int i = 0; i < paradasCount; i++) {
            Parada station = paradas[i];
            for (int j = 0; j < station.paradasConectadasCount; j++) {
                Parada neighbor = station.paradasConectadas[j];
                String edgeId = station.id + "-" + neighbor.id;
                String reverseEdgeId = neighbor.id + "-" + station.id;
                if (graph.getEdge(edgeId) == null && graph.getEdge(reverseEdgeId) == null) {
                    graph.addEdge(edgeId, station.id, neighbor.id, false);
                }
            }
        }
    }

    /**
     * Obtiene un listado de todas las paradas en el grafo.
     * 
     * @return Un array de strings con los nombres de las paradas
     */
    public String[] obtenerListadoParadas() {
        String[] listaParadas = new String[paradasCount];
        for (int i = 0; i < paradasCount; i++) {
            listaParadas[i] = paradas[i].id;
        }
        return listaParadas;
    }

    /**
     * Obtiene el índice de hash basado en el identificador de la parada.
     * 
     * @param id Identificador de la parada
     * @return Índice derivado del hash del identificador
     */
    private int getIndex(String id) {
        return Math.abs(id.hashCode()) % 100;
    }
}
