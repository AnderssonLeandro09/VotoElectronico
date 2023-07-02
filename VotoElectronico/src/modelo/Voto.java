/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author sergio
 */
public class Voto {
    private int id_Candidato;
    private int id_Votante;
    private String opcion_Votante;

    public int getId_Candidato() {
        return id_Candidato;
    }

    public void setId_Candidato(int id_Candidato) {
        this.id_Candidato = id_Candidato;
    }

    public int getId_Votante() {
        return id_Votante;
    }

    public void setId_Votante(int id_Votante) {
        this.id_Votante = id_Votante;
    }

    public String getOpcion_Votante() {
        return opcion_Votante;
    }

    public void setOpcion_Votante(String opcion_Votante) {
        this.opcion_Votante = opcion_Votante;
    }
    
    
}
