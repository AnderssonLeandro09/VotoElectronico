/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.ed.listas.ListaEnlazada;
import java.io.IOException;
import modelo.Cuenta;

/**
 *
 * @author usuario
 */
public class CuentaDao extends AdaptadorDAO<Cuenta> {

    private Cuenta cuenta;

    public CuentaDao() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        if (this.cuenta == null) {
            this.cuenta = new Cuenta();
        }
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void guardar() {
        cuenta.setId(generateID());
        try {
            this.guardar(cuenta);
        } catch (IOException ex) {
        }
    }

    public void modificar(Integer pos) throws VacioException, PosicionException, IOException {
        this.modificar(cuenta, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

}


