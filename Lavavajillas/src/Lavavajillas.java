/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Permite el uso de un lavavajillas virtual permitiendo manipular su puerta de
 * apertura, encenderlo y apagarlo, así como establecer manualmente el programa
 * en el que se encuentra el proceso de lavado y realizar el avance automático
 * del mismo.
 *
 * @author Usuario
 */
public class Lavavajillas {

    static final int ENJUAGADO = 1;
    static final int PRELAVADO = 2;
    static final int LAVADO = 3;
    static final int ACLARADO = 4;
    static final int SECADO = 5;

    boolean estado_encendido = false;
    String muestra_encendido;

    boolean puerta = false;
    String posicionPuerta;

    String programaActual;
    int programaActualNum;

    /**
     * Constructor para un lavavajillas con la puerta cerrada, apagado y con el
     * programa preparado para el enjuagado
     *
     */
    Lavavajillas() {
        this.estado_encendido = false;
        this.puerta = false;
        this.programaActualNum = 1;
    }

    /**
     * Constructor para un lavavajillas con la puerta cerrada, encendido y con
     * el programa situado en el que se indique por parámetro.
     *
     * @param programa Situación inicial del lavavajillas en el momento de
     * crearlo.
     */
    Lavavajillas(int programa) {
        estado_encendido = true;
        puerta = false;
        programaActualNum = programa;
    }

    /**
     * Permite encender o apagar el lavavajillas. Si se va a encencer, comprueba
     * que la puerta esté cerrada (si se encuentra abierta no se enciende).
     *
     * @param encendido Indica si se va a encender (true) o apagar (false) el
     * lavavajillas.
     */
    public void setEncendido(boolean encendido) {
        if (puerta == false) {
            if (encendido == true) {
                estado_encendido = true;
            } else {
                estado_encendido = false;
            }
        } else {
            if (encendido == true){
                estado_encendido = false;
            } else {
                estado_encendido = false;
            }
        }
    }

    /**
     * Obtiene una cadena de caracteres indicando si el lavavajillas está
     * encendido o apagado
     *
     * @return "Encendido" o "Apagado" en cada caso.
     */
    public String getEncendido() {
        if (estado_encendido  == true) {
            muestra_encendido = "Encendido";
        } else {
            this.muestra_encendido = "Apagado";
        }
        return this.muestra_encendido;
    }

    /**
     * Permite abrir o cerrar la puerta del lavavajillas. Si se abre, el
     * lavavajillas debe apagarse automáticamente.
     *
     * @param abierto Indica si se va a abrir (true) o cerrar (false) el
     * lavavajillas.
     */
    public void setAbierto(boolean abierto) {
        if (this.estado_encendido == false) {
            if (abierto == true) {
                this.estado_encendido = false;
                this.puerta = true;
            } else {
                this.puerta = false;
            }
        } else {
            if (abierto == true) {
                this.estado_encendido = true;
                this.puerta = false;
            }
        }
    }

    /**
     * Obtiene una cadena de caracteres indicando si el lavavajillas está
     * abierto o cerrado
     *
     * @return "Abierto" o "Cerrado" en cada caso.
     */
    public String getAbierto() {
        if (this.puerta == true) {
            this.posicionPuerta = "Abierta";
        } else {
            this.posicionPuerta = "Cerrada";
        }
        return this.posicionPuerta;
    }

    /**
     * Establece el programa en el que se desea situar el lavavajillas
     *
     * @param programa Valor correspondiente al programa en el que se desea
     * poner el lavavajillas. Se pueden utilizar las constantes definidas para
     * los distintos programas.
     */
    public void setPrograma(int programa) {
        if (this.estado_encendido == true) {
            switch (programa) {
                case Lavavajillas.ENJUAGADO:
                    this.programaActualNum = 1;
                    break;
                case Lavavajillas.PRELAVADO:
                    this.programaActualNum = 2;
                    break;
                case Lavavajillas.LAVADO:
                    this.programaActualNum = 3;
                    break;
                case Lavavajillas.ACLARADO:
                    this.programaActualNum = 4;
                    break;
                case Lavavajillas.SECADO:
                    this.programaActualNum = 5;
                    break;

            }
        }
    }

    /**
     * Obtiene una cadena de caracteres indicando si el programa en el que se
     * encuentra el lavavajillas
     *
     * @return "Enjuagado", "Prelavado", "Lavado" o "Aclarado" para cada posible
     * programa.
     */
    public String getPrograma() {
        switch (this.programaActualNum) {
            case Lavavajillas.ENJUAGADO:
                this.programaActual = "Enjuagado";
                break;
            case Lavavajillas.PRELAVADO:
                this.programaActual = "Prelavado";
                break;
            case Lavavajillas.LAVADO:
                this.programaActual = "Lavado";
                break;
            case Lavavajillas.ACLARADO:
                this.programaActual = "Aclarado";
                break;
            case Lavavajillas.SECADO:
                this.programaActual = "Secado";
                break;
        }
        return this.programaActual;
    }

    /**
     * Avanza automáticamente el estado del programa en el que se encuentre el
     * lavavajillas, pasando al siguiente programa siguiendo este orden:
     * Enjuagado, prelavado, lavado, aclarado y secado. Cuando el programa
     * anterior es el último (secado), al avanzar el programa del lavavajillas,
     * éste se debe apagar y cambiar el programa al inicial (enjuagado). Para
     * que el lavavajillas pueda avanzar de programa, debe encontrarse
     * encendido.
     *
     */
    public void avanzarPrograma() {
        if (this.estado_encendido == true) {
            if (this.programaActualNum >= 1 && this.programaActualNum < 5) {
                this.programaActualNum++;
            } else {
                if (this.programaActualNum == 5) {
                    this.estado_encendido = false;
                    this.programaActualNum = 1;
                }
            }
        }

    }

    /**
     *
     */
    public void mostrarEstado() {
        this.getAbierto();
        this.getEncendido();
        this.getPrograma();
    }
}
