/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pis;

import controlador.dao.PersonaDao;
import modelo.Persona;

/**
 *
 * @author Wilman
 */
public class Pis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            PersonaDao p = new PersonaDao();
            
            Persona persona = new Persona();
            persona.setCedula("1106002593");
            persona.setNacionalidad("Ecuatoriano");
            persona.setNombre("Wilman");
            p.setPersona(persona);
            p.guardar();
            p.listar().imprimir();
            
            Persona persona1 = new Persona();
            persona.setCedula("1106012345");
            persona.setNacionalidad("Ecuatoriano");
            persona.setNombre("Juan");
            p.setPersona(persona);
            p.guardar();
            p.listar().imprimir();

        } catch (Exception e) {
        }

    }

}
