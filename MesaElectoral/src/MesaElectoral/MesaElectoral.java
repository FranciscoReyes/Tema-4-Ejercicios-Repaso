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
public class MesaElectoral {

    private String presidente;
    private String secretario;
    private String vocal;
    private int censo;
    private boolean abierta;
    private int votosPartido0;
    private int votosPartido1;
    private int votosPartido2;

    final static int BB = 0;
    final static int PSAO = 1;
    final static int UI = 2;
    
    double votosTotales;

    MesaElectoral(String presidente, String secretario, String vocal, int censo) {
        this.presidente = presidente;
        this.secretario = secretario;
        this.vocal = vocal;
        this.censo = censo;
        this.abierta = false;
    }

    MesaElectoral(int censo) {
        this.censo = censo;
        this.abierta = true;
    }

    public void setAbierta(boolean estado) {
        if (estado == true) {
            this.abierta = true;
        } else {
            this.abierta = false;
        }
    }

    public void setVotos(int num, int partido) {
        if (this.abierta == true) {
            switch (partido) {
                case MesaElectoral.BB:
                    this.votosPartido0 = num;
                    break;
                case MesaElectoral.PSAO:
                    this.votosPartido1 = num;
                    break;
                case MesaElectoral.UI:
                    this.votosPartido2 = num;
                    break;
            }
        } else {

        }
    }

    public void setVotos(int partido) {
        if (this.abierta == true) {
            switch (partido) {
                case MesaElectoral.BB:
                    this.votosPartido0++;
                    break;
                case MesaElectoral.PSAO:
                    this.votosPartido1++;
                    break;
                case MesaElectoral.UI:
                    this.votosPartido2++;
                    break;
            }
        } else {

        }
    }
    
    public int getVotos (int partido) {
        
        if (partido == MesaElectoral.BB) {
            return this.votosPartido0;
        } else {
            if (partido == MesaElectoral.PSAO) {
                return this.votosPartido1;
            } else {
                if (partido == MesaElectoral.UI) {
                    return this.votosPartido2;
                } else {
                    return 0;
                }
            }
        }
    } 
    
    public double participacion () {
        votosTotales = (((double) this.votosPartido0 + (double) this.votosPartido1 + (double) this.votosPartido2) / (double)this.censo) * 100.0;
        return votosTotales;
    }
}
