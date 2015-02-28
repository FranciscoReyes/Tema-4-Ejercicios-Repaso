/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MesaElectoral;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MesaElectoral mesa = new MesaElectoral("Francisco Jones", "Paco Jerlo", "Eustaquio García", 20000);
        mesa.setVotos(100, MesaElectoral.UI);
        System.out.println(mesa.getVotos(3));
        mesa.setAbierta(true);
        mesa.setVotos(100, MesaElectoral.UI);
        System.out.println(mesa.getVotos(MesaElectoral.UI));
        System.out.println("");
        
        MesaElectoral mesa2 = new MesaElectoral(25000);
        mesa2.setVotos(2000, MesaElectoral.PSAO);
        mesa2.setVotos(100, MesaElectoral.BB);
        mesa2.setVotos(10000, MesaElectoral.UI);
        mesa2.setVotos(MesaElectoral.UI);
        System.out.println(mesa2.getVotos(MesaElectoral.PSAO) + "\n" + mesa2.getVotos(MesaElectoral.BB) + "\n" + mesa2.getVotos(MesaElectoral.UI));
        System.out.println(mesa2.participacion());
        
    }
    
}
