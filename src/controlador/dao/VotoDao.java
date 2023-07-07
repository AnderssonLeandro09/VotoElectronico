/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import modelo.Voto;

/**
 *
 * @author sergio
 */
public class VotoDao extends AdaptadorDao<Voto> {

    private Voto voto;

    public VotoDao() {
        super(Voto.class);
    }

    public Voto getVoto() {
        if (voto == null) {
            this.voto = new Voto();
        }
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    public void guardar() throws IOException {
        this.guardar(voto);

    }

    public void modificar(Integer pos) {
        this.modificar(pos);
    }

    private Integer generarID() {
        return listar().size() + 1;

    }
    
    

}
