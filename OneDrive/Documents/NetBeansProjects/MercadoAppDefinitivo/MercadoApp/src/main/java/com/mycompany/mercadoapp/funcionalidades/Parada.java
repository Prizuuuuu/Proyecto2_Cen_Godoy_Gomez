package com.mycompany.mercadoapp.funcionalidades;

/**
 * Representa una parada en una línea de transporte con conexiones a otras paradas.
 * Gestiona conexiones y permite realizar búsquedas de paradas alcanzables
 * utilizando BFS y DFS.
 * 
 * @author juan
 */
public class Parada {

    /** El identificador único de la parada */
    public String id;

    /** El color de la línea a la que pertenece la parada */
    public String colorLinea;

    /** Las paradas conectadas directamente a esta parada */
    public Parada[] paradasConectadas;

    /** El número de paradas conectadas a esta parada */
    public int paradasConectadasCount = 0;

    /**
     * Crea una nueva instancia de Parada.
     * 
     * @param id               El identificador de la parada
     * @param colorLinea       El color de la línea de la parada
     * @param maxConexiones    El número máximo de paradas conectadas
     */
    Parada(String id, String colorLinea, int maxConexiones) {
        this.id = id;
        this.colorLinea = colorLinea;
        this.paradasConectadas = new Parada[maxConexiones];
    }

    /**
     * Conecta esta parada con otra parada, evitando duplicados.
     * 
     * @param paradaConectada La parada a conectar con esta parada
     */
    void conectarParada(Parada paradaConectada) {
        for (int i = 0; i < paradasConectadasCount; i++) {
            if (paradasConectadas[i] == paradaConectada) {
                return;  // Evita duplicados
            }
        }
        paradasConectadas[paradasConectadasCount++] = paradaConectada;
    }

    /**
     * Realiza una búsqueda en anchura (BFS) para obtener las paradas alcanzables
     * dentro de un rango determinado.
     * 
     * @param alcanceParadas El alcance en número de paradas desde la parada inicial
     * @return Un array de paradas alcanzables dentro del rango especificado
     */
    public Parada[] getParadasCubiertasBfs(int alcanceParadas) {
        Parada[] queue = new Parada[100]; // Cola para el recorrido BFS
        int[] levels = new int[100]; // Niveles para controlar la distancia desde el origen
        boolean[] visited = new boolean[100]; // Array para marcar nodos visitados

        Parada[] reachable = new Parada[100]; // Almacena las paradas dentro de la cobertura
        int front = 0, rear = 0, count = 0;

        queue[rear] = this; // Inicia con la parada actual
        levels[rear++] = 0;
        visited[getIndex(this.id)] = true;

        while (front < rear) {
            Parada current = queue[front];
            int currentLevel = levels[front++];

            // Detener la expansión si alcanzamos el límite de cobertura
            if (currentLevel >= alcanceParadas) {
                continue;
            }

            for (int i = 0; i < current.paradasConectadasCount; i++) {
                Parada neighbor = current.paradasConectadas[i];
                int index = getIndex(neighbor.id);

                if (!visited[index]) { // Añadir solo si no ha sido visitado
                    visited[index] = true;
                    queue[rear] = neighbor;
                    levels[rear++] = currentLevel + 1;

                    if (neighbor != this) { // Evitar añadir la parada inicial a reachable
                        reachable[count++] = neighbor;
                    }
                }
            }
        }

        // Redimensionar el arreglo reachable para eliminar elementos nulos
        Parada[] resultado = new Parada[count];
        for (int i = 0; i < count; i++) {
            resultado[i] = reachable[i];
        }
        return resultado;
    }

    /**
     * Realiza una búsqueda en profundidad (DFS) para obtener las paradas alcanzables
     * dentro de un rango determinado.
     * 
     * @param alcanceParadas El alcance en número de paradas desde la parada inicial
     * @return Un array de paradas alcanzables dentro del rango especificado
     */
    public Parada[] getParadasCubiertasDfs(int alcanceParadas) {
        boolean[] visited = new boolean[100];
        Parada[] reachable = new Parada[100];
        int count = dfsRecursivo(this, 0, alcanceParadas, visited, reachable, 0);

        // Redimensionar el arreglo reachable para eliminar elementos nulos
        Parada[] resultado = new Parada[count];
        for (int i = 0; i < count; i++) {
            resultado[i] = reachable[i];
        }
        return resultado;
    }

    /**
     * Método recursivo auxiliar para la búsqueda en profundidad (DFS).
     * 
     * @param current     La parada actual en la búsqueda
     * @param level       La profundidad actual en la búsqueda
     * @param maxAlcance  El máximo alcance permitido
     * @param visited     Array para registrar las paradas visitadas
     * @param reachable   Array para almacenar las paradas alcanzables
     * @param count       El contador de paradas alcanzables
     * @return El número total de paradas alcanzables dentro del alcance especificado
     */
    private int dfsRecursivo(Parada current, int level, int maxAlcance, boolean[] visited, Parada[] reachable, int count) {
        if (level >= maxAlcance) {
            return count; // Limitar la profundidad de la búsqueda
        }
        int index = getIndex(current.id);
        visited[index] = true;

        // Agregar la parada actual a reachable
        reachable[count++] = current;

        // Llamar a DFS recursivo para cada vecino no visitado
        for (int i = 0; i < current.paradasConectadasCount; i++) {
            Parada neighbor = current.paradasConectadas[i];
            int neighborIndex = getIndex(neighbor.id);
            if (!visited[neighborIndex]) {
                count = dfsRecursivo(neighbor, level + 1, maxAlcance, visited, reachable, count);
            }
        }
        return count;
    }

    /**
     * Genera un índice único basado en el id de la parada para su uso en el array de visitados.
     * 
     * @param id El identificador de la parada
     * @return Un índice derivado del hash del id
     */
    private int getIndex(String id) {
        return Math.abs(id.hashCode()) % 100;
    }
}
