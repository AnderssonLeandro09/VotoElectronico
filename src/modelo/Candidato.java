/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author sergio
 */
public class Candidato extends Persona {

    private static int ultimoId = 0;
    private int id_Candidato;

    public Candidato() {
        ultimoId++;
        id_Candidato = ultimoId;
    }

    public Candidato(int id_Candidato) {
        this.id_Candidato = id_Candidato;
        if (id_Candidato > ultimoId) {
            ultimoId = id_Candidato;
        }
    }

    public int getId_Candidato() {
        return id_Candidato;
    }

    public void setId_Candidato(int id_Candidato) {
        this.id_Candidato = id_Candidato;
        if (id_Candidato > ultimoId) {
            ultimoId = id_Candidato;
        }
    }

}
