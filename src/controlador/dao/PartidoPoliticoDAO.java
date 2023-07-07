/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import modelo.PartidoPolitico;

/**
 *
 * @author Bravo
 */
public class PartidoPoliticoDAO extends AdaptadorDao<PartidoPolitico>{
    
   PartidoPolitico partidoPolitico = new PartidoPolitico();
   
    public PartidoPoliticoDAO() {
        super(PartidoPolitico.class);
    }

    public PartidoPolitico getPartidoPolitico() {
        if (partidoPolitico == null) {
            this.partidoPolitico = new PartidoPolitico();
        }
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }
    
    public void guardar() throws IOException {
        this.guardar(partidoPolitico);
    }
    
    public void modificar(Integer pos){
        this.modificar(pos);
    }
    
    public static void main(String[] args) throws IOException {
        PartidoPoliticoDAO ppd = new PartidoPoliticoDAO();
        
        ppd.getPartidoPolitico().setNombre("PartidoGenericoXd");
        ppd.guardar();
    }
    
}
