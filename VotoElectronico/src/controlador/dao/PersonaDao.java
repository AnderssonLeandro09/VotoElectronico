package controlador.dao;

import java.io.FileWriter;
import java.io.IOException;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import modelo.Persona;

/**
 *
 * @author sergio
 */

public class PersonaDao extends AdaptadorDao<Persona> {

    private Persona persona;

    public PersonaDao() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (persona == null) {
            this.persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void guardar() throws IOException, VacioException, PosicionException {
        ListaEnlazada<Persona> lista = listar();

        // Verificar si la persona ya existe en la lista por su cédula
        for (int i = 0; i < lista.size(); i++) {
            Persona p = lista.get(i);
            if (p.getCedula().equals(persona.getCedula())) {
                // Actualizar persona existente
                lista.modificar(persona, i);
                conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
                conexion.getXstream().toXML(lista, new FileWriter(url));
                return; // Terminar la ejecución del método
            }
        }

        // Nueva persona, asignar cédula como ID
        persona.setId(persona.getCedula());
        lista.insertarNodo(persona);

        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
    }

    public void modificar(Integer pos) throws Exception {
        ListaEnlazada<Persona> lista = listar();
        lista.modificar(persona, pos);
        conexion.getXstream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXstream().toXML(lista, new FileWriter(url));
    }

    private String generateID() {
        return persona.getCedula();
    }

    public Persona obtenerPorNombre(String nombre) throws VacioException, PosicionException {
        ListaEnlazada<Persona> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Persona persona = lista.get(i);
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return persona;
            }
        }
        return null; // Si no se encuentra la persona con el nombre especificado
    }

    public static void main(String[] args) throws IOException, VacioException, PosicionException {
        PersonaDao pd = new PersonaDao();
        Persona persona = new Persona();

        persona.setCedula("1105918419");
        persona.setVotoRealizado(false);
        persona.setEleccionVoto("");
        persona.setEdad(18);
        persona.setGenero("M");
        persona.setNombre("Emilio");

        pd.setPersona(persona);
        pd.guardar();

        persona.setCedula("1105918418");
        persona.setVotoRealizado(false);
        persona.setEleccionVoto("");
        persona.setEdad(18);
        persona.setGenero("M");
        persona.setNombre("Andres");

        pd.setPersona(persona);
        pd.guardar();
    }
}
