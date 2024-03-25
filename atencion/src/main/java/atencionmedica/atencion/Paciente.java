package atencionmedica.atencion;

import java.util.List;

public class Paciente {
    private int id;
    private String nombre;
    private String direccion;
    private List<AtencionMedica> historialMedico;

    // Constructor
    public Paciente(int id, String nombre, String direccion, List<AtencionMedica> historialMedico) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.historialMedico = historialMedico;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<AtencionMedica> getHistorialMedico() {
        return historialMedico;
    }
}

