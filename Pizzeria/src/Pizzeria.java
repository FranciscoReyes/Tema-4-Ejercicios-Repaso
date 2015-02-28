/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Pizzeria {

    static final int ING_ATUN = 1;
    static final int ING_BACON = 2;
    static final int ING_CEBOLLA = 3;
    static final int ING_CHAMPIÑONES = 4;
    static final int ING_JAMON = 5;
    static final int ING_PIMIENTO = 6;
    static final int ING_VACIO = 0;

    String[] ingredientes = {" ", "Atun", "Bacon", "Cebolla", "Champiñones", "Jamón", "Pimiento"};

    static final int TAM_GRANDE = 0;
    static final int TAM_PEQUEÑA = 1;

    static public int numPedido;
    public int nPedido;

    private boolean tamañoCorrecto;
    private boolean ingCorrectos;

    private int ing1;
    private int ing2;
    private int ing3;

    private int tamañoElegido;

    private boolean enCocina;
    private int estado;

    /**
     *
     */
    public int numIngredientes;

    /**
     *
     */
    public double precioTotal;

    /**
     *
     */
    public String ticket;
    private String tamaño;
    private String ingre1;
    private String ingre2;
    private String ingre3;
    private String estadoText;

    Pizzeria(int tamaño, int ingrediente1) {
        if (tamaño != Pizzeria.TAM_GRANDE || tamaño != Pizzeria.TAM_PEQUEÑA) {
            if (ingrediente1 < 7 && ingrediente1 > -1) {
                this.ingCorrectos = true;
                this.tamañoCorrecto = true;
                this.numPedido++;
                this.nPedido = Pizzeria.numPedido;
                this.ing1 = ingrediente1;
                this.tamañoElegido = tamaño;
                this.numIngredientes = 1;
                this.estado = 0;
            } else {
                this.ingCorrectos = false;
            }
        } else {
            this.tamañoCorrecto = false;
        }

    }

    Pizzeria(int tamaño, int ingrediente1, int ingrediente2) {
        if (tamaño != Pizzeria.TAM_GRANDE || tamaño != Pizzeria.TAM_PEQUEÑA) {
            if ((ingrediente1 < 7 && ingrediente1 > -1) && (ingrediente2 < 7 && ingrediente2 > -1)) {
                this.ingCorrectos = true;
                this.tamañoCorrecto = true;
                this.numPedido++;
                this.nPedido = Pizzeria.numPedido;
                this.ing1 = ingrediente1;
                this.ing2 = ingrediente2;
                this.tamañoElegido = tamaño;
                this.numIngredientes = 2;
                this.estado = 0;
            } else {
                this.ingCorrectos = false;
            }
        } else {
            this.tamañoCorrecto = false;
        }
    }

    Pizzeria(int tamaño, int ingrediente1, int ingrediente2, int ingrediente3) {
        if (tamaño != Pizzeria.TAM_GRANDE || tamaño != Pizzeria.TAM_PEQUEÑA) {
            if ((ingrediente1 < 7 && ingrediente1 > -1) && (ingrediente2 < 7 && ingrediente2 > -1) && (ingrediente3 < 7 && ingrediente3 > -1)) {
                this.ingCorrectos = true;
                this.tamañoCorrecto = true;
                this.numPedido++;
                this.nPedido = Pizzeria.numPedido;
                this.ing1 = ingrediente1;
                this.ing2 = ingrediente2;
                this.ing3 = ingrediente3;
                this.tamañoElegido = tamaño;
                this.numIngredientes = 3;
                this.estado = 0;
            } else {
                this.ingCorrectos = false;
            }
        } else {
            this.tamañoCorrecto = false;
        }
    }

    /**
     *
     */
    public void cocinar() {
        if (this.tamañoCorrecto == true && this.ingCorrectos == true) {
            this.enCocina = true;
            this.estado = 1;
        } else {
            this.enCocina = false;
        }

    }

    /**
     *
     */
    public void servir() {
        if (this.enCocina == true) {
            if (this.tamañoElegido == Pizzeria.TAM_PEQUEÑA) {
                this.precioTotal += 5;
                this.estado = 2;
                switch (this.numIngredientes) {
                    case 1:
                        this.precioTotal += 1;
                        break;
                    case 2:
                        this.precioTotal += 2;
                        break;
                    case 3:
                        this.precioTotal += 3;
                        break;
                }
            } else {
                if (this.tamañoElegido == Pizzeria.TAM_GRANDE) {
                    this.precioTotal += 7.50;
                    this.estado = 2;
                    switch (this.numIngredientes) {
                        case 1:
                            this.precioTotal += 1 * 2;
                            break;
                        case 2:
                            this.precioTotal += 2 * 2;
                            break;
                        case 3:
                            this.precioTotal += 3 * 2;
                            break;
                    }
                }
            }

        }
    }

    /**
     *
     * @param ordenIngrediente
     * @param ingrediente
     */
    public void setIngrediente(int ordenIngrediente, int ingrediente) {
        if ((this.ing1 == 0 && ingrediente != 0) || (this.ing2 == 0 && ingrediente != 0) || (this.ing3 == 0 && ingrediente != 0)){
            this.numIngredientes++;
        }
        
        if (this.enCocina == false) {
            switch (ordenIngrediente) {
                case 1:
                    this.ing1 = ingrediente;
                    break;
                case 2:
                    this.ing2 = ingrediente;
                    break;
                case 3:
                    this.ing3 = ingrediente;
                    break;
            }
        }

        if (ingrediente == Pizzeria.ING_VACIO) {
            this.numIngredientes--;
        }
    }

    /**
     *
     * @param tamaño
     */
    public void setTamaño(int tamaño) {
        if (this.enCocina == false) {
            this.tamañoElegido = tamaño;
        }
    }

    @Override
    public java.lang.String toString() {
        switch (this.estado) {
            case 0:
                this.estadoText = "En espera...";
                break;
            case 1:
                this.estadoText = "En cocina";
                break;
            case 2:
                this.estadoText = "Servida";
                break;
        }

        switch (this.tamañoElegido) {
            case 0:
                this.tamaño = "Grande";
                break;
            case 1:
                this.tamaño = "Pequeña";
                break;
        }

        this.ticket = "----------\nPedido nº: " + this.nPedido + "\nTamaño: " + this.tamaño
                + "\nIngrediente1: " + ingredientes[this.ing1] + "\nIngrediente2: " + ingredientes[this.ing2]
                + "\nIngrediente3: " + ingredientes[this.ing3] + "\nEstado: " + this.estadoText + "\nPrecio: "
                + this.precioTotal + "\n----------";
        return ticket;

    }

}
