/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import java.io.IOException;
import modelo.Persona;

/**
 *
 * @author Usuario Asus
 */
public class PersonaDao extends AdaptadorDao<Persona> {
    
    private Persona persona;
    
    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void modificar(Integer pos) throws VacioException, PosicionException, IOException {
        this.modificar(persona, pos);
    }

    public void guardar() {
        
        persona.setId(generateID());
        try {
            
            this.guardar(persona);
        } catch (IOException ex) {
            
        }
    }

    private Integer generateID() {
        
        return listar().size() + 1;
    }
    
}
