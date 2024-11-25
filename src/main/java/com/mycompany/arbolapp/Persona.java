/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.arbolapp;

/**
 *
 * @author juan
 */
class Persona {

    private String nombre;
    private String titulo;
    private String colorOjos;
    private String colorCabello;
    private String notas;
    private String destino;
    private String mote;
    private String numeral;
    private String[] hijoDe;
    private String[] padreDe;
    private Persona padre;
    private NodoHijo primerHijo;
    private int contadorPadres;
    private int contadorHijos;
    private boolean procesado = false;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.primerHijo = null;
        this.padre = null;
        this.hijoDe = new String[2];
        this.contadorPadres = 0;
        this.padreDe = new String[20];
        this.contadorHijos = 0;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public void setColorCabello(String colorCabello) {
        this.colorCabello = colorCabello;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public void setNumeral(String numeral) {
        this.numeral = numeral;
    }

    public void setPadre(Persona padre) {
        this.padre = padre;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public String getColorCabello() {
        return colorCabello;
    }

    public String getNotas() {
        return notas;
    }

    public String getDestino() {
        return destino;
    }

    public String getMote() {
        return mote;
    }

    public String getNumeral() {
        return numeral;
    }

    public String getNombre() {
        return nombre;
    }

    public NodoHijo getPrimerHijo() {
        return primerHijo;
    }

    public Persona getPadre() {
        return padre;
    }

    public String[] getHijoDe() {
        return hijoDe;
    }

    public boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }

    public String generarClavePrincipal() {
        return this.nombre + ", " + this.numeral + " of his name";
    }

    private boolean esAncestro(Persona posibleAncestro) {
        Persona actual = this;
        while (actual != null) {
            if (actual == posibleAncestro) {
                return true; // Se detectó un ciclo
            }
            actual = actual.getPadre(); // Asumiendo que cada Persona tiene una referencia a su padre
        }
        return false;
    }

    public void agregarHijo2(Persona hijo) {
        if (esAncestro(hijo)) {
            System.out.println("No se puede agregar " + hijo.getNombre() + " como hijo de " + this.getNombre() + ". Crearía un ciclo.");
            return;
        }
        NodoHijo nuevoHijo = new NodoHijo(hijo);

        System.out.println("Agregando " + hijo.getNombre() + " como hijo de " + this.getNombre());

        if (primerHijo == null) {
            primerHijo = nuevoHijo;
        } else {
            NodoHijo actual = primerHijo;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoHijo;
        }
    }

    public void agregarHijo(Persona hijo) {
        if (esAncestro(hijo)) {
            System.out.println("No se puede agregar " + hijo.getNombre() + " como hijo de " + this.getNombre() + ". Crearía un ciclo.");
            return;
        }

        // Validar si el hijo ya existe en la lista
        NodoHijo actual = primerHijo;
        while (actual != null) {
            if (actual.hijo.equals(hijo)) { // Verificar si ya está en la lista
                System.out.println(hijo.getNombre() + " ya es hijo de " + this.getNombre());
                return;
            }
            actual = actual.siguiente;
        }

        // Si no está presente, agregarlo
        NodoHijo nuevoHijo = new NodoHijo(hijo);
        System.out.println("Agregando " + hijo.getNombre() + " como hijo de " + this.getNombre());

        if (primerHijo == null) {
            primerHijo = nuevoHijo;
        } else {
            actual = primerHijo;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoHijo;
        }
    }

    public void agregarHijoDe(String referencia) {
        if (contadorPadres < 2) {
            this.hijoDe[contadorPadres] = referencia;
            contadorPadres++;
        } else {
            System.out.println("No se pueden agregar más de 2 padres a 'hijoDe' para " + this.nombre);
        }
    }

    public void agregarPadreDe(String referencia) {
        if (contadorHijos < 20) {
            this.padreDe[contadorHijos] = referencia;
            contadorHijos++;
        } else {
            System.out.println("No se pueden agregar más de 20 hjos a 'padreDe' para " + this.nombre);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        if (titulo != null) {
            sb.append("Título: ").append(titulo).append("\n");
        }
        if (colorOjos != null) {
            sb.append("Color de ojos: ").append(colorOjos).append("\n");
        }
        if (colorCabello != null) {
            sb.append("Color de cabello: ").append(colorCabello).append("\n");
        }
        if (notas != null) {
            sb.append("Notas: ").append(notas).append("\n");
        }
        if (destino != null) {
            sb.append("Destino: ").append(destino).append("\n");
        }
        if (mote != null) {
            sb.append("Mote: ").append(mote).append("\n");
        }
        if (numeral != null) {
            sb.append("Numeral: ").append(numeral).append("\n");
        }
        if (padre != null) {
            sb.append("Padre: ").append(padre.getNombre()).append("\n");
        }
        sb.append("Hijos: ");
        NodoHijo temp = primerHijo;
        if (temp == null) {
            sb.append("Ninguno");
        } else {
            while (temp != null) {
                sb.append(temp.hijo.getNombre()).append(", ");
                temp = temp.siguiente;
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("\n");
        return sb.toString();
    }

    public void imprimirRelaciones() {
        System.out.println("Persona: " + this.nombre);
        if (this.padre != null) {
            System.out.println("  Padre: " + this.padre.getNombre());
        } else {
            System.out.println("  Padre: null");
        }
        System.out.print("  Hijos: ");
        NodoHijo hijoActual = this.primerHijo;
        if (hijoActual == null) {
            System.out.println("Ninguno");
        } else {
            while (hijoActual != null) {
                System.out.print(hijoActual.hijo.getNombre() + " ");
                hijoActual = hijoActual.siguiente;
            }
            System.out.println();
        }
    }
}
