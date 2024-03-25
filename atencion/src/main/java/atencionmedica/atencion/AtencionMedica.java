package atencionmedica.atencion;

public class AtencionMedica {
    private String fecha;
    private String diagnostico;
    private String tratamiento;

    // Constructor
    public AtencionMedica(String fecha, String diagnostico, String tratamiento) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    // Getters
    public String getFecha() {
        return fecha;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }
}

