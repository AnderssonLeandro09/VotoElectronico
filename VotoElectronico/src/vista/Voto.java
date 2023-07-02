/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import controlador.dao.CuentaDao;

/**
 *
 * @author usuario
 */
public class Voto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CuentaDao c = new CuentaDao();

            c.getCuenta().setUsuario("1150182051");
            c.getCuenta().setContra("cristian");
            c.getCuenta().setEstado(true);
            c.guardar();
            c.listar().imprimir();

            c.getCuenta().setUsuario("1150182052");
            c.getCuenta().setContra("cris");
            c.getCuenta().setEstado(true);
            c.guardar();
            c.listar().imprimir();

        } catch (Exception e) {
        }
    }

}
