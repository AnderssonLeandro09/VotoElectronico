/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.dao;

import controlador.ed.listas.ListaEnlazada;
import controlador.ed.lista.exception.VacioException;
import controlador.ed.lista.exception.PosicionException;
import java.io.IOException;
import modelo.Cuenta;
import modelo.Usuario;

/**
 *
 * @author anonimo
 */
public class UsuarioDao extends AdaptadorDAO<Usuario> {

    private Usuario usuario;

    public UsuarioDao() {
        super(Usuario.class);
    }

    public Usuario getUsuario() {
        if (this.usuario == null) {
            this.usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void guardar() throws IOException {
        usuario.setId(generateID());
        this.guardar(usuario);
    }

    public void modificar(Integer pos) throws VacioException, PosicionException, IOException {
        this.modificar(usuario, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

   

}
