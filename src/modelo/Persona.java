/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 * Clase que representa una persona.
 */
public class Persona {

    private String id;
    private String cedula;
    private int edad;
    private boolean esDiscapacitado;
    private String genero;
    private String nombre;
    private boolean votoRealizado;
    private String eleccionVoto;
    private String rol;
    private String Contra;

    public String getContra() {
        return Contra;
    }

    public void setContra(String Contra) {
        this.Contra = Contra;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEsDiscapacitado() {
        return esDiscapacitado;
    }

    public void setEsDiscapacitado(boolean esDiscapacitado) {
        this.esDiscapacitado = esDiscapacitado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVotoRealizado() {
        return votoRealizado;
    }

    public void setVotoRealizado(boolean votoRealizado) {
        this.votoRealizado = votoRealizado;
    }

    public String getEleccionVoto() {
        return eleccionVoto;
    }

    public void setEleccionVoto(String eleccionVoto) {
        this.eleccionVoto = eleccionVoto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.id, other.id);
    }

    private PartidoPolitico partidoPolitico;
}
