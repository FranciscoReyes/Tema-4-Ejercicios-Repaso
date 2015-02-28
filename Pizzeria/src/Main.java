/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pizzeria pizza1 = new Pizzeria(Pizzeria.TAM_PEQUEÑA, Pizzeria.ING_JAMON, Pizzeria.ING_CHAMPIÑONES);
        
        Pizzeria pizza2 = new Pizzeria(Pizzeria.TAM_GRANDE, Pizzeria.ING_ATUN, Pizzeria.ING_CEBOLLA);
        Pizzeria pizza3 = new Pizzeria(Pizzeria.TAM_PEQUEÑA, Pizzeria.ING_JAMON, Pizzeria.ING_BACON, Pizzeria.ING_PIMIENTO);
        
        pizza1.cocinar();
        
        pizza2.setIngrediente(2, Pizzeria.ING_VACIO);
        pizza2.setIngrediente(2, 4);
        pizza2.setIngrediente(2, 0);
        
        pizza1.servir();
        
        pizza2.cocinar();
        
        pizza2.servir();
        
        pizza3.cocinar();
        
        System.out.println(pizza1.toString());
        System.out.println(pizza2.toString());
        System.out.println(pizza3.toString());
    }
    
}
