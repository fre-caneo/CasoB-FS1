package atencionmedica.atencion;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private List<Paciente> pacientes = new ArrayList<>();

    public PacienteController() {
        // Crear algunos pacientes de ejemplo
        List<AtencionMedica> historial1 = new ArrayList<>();
        historial1.add(new AtencionMedica("2023-01-15", "Fiebre", "Paracetamol"));
        historial1.add(new AtencionMedica("2023-02-20", "Dolor de cabeza", "Descanso"));

        List<AtencionMedica> historial2 = new ArrayList<>();
        historial2.add(new AtencionMedica("2022-12-10", "Dolor de garganta", "Antibióticos"));

        pacientes.add(new Paciente(1, "Juan", "Calle 123", historial1));
        pacientes.add(new Paciente(2, "María", "Avenida 456", historial2));
    }

    @GetMapping
    public List<Paciente> obtenerTodosLosPacientes() {
        if (pacientes.isEmpty()) {
            throw new RuntimeException("No hay pacientes registrados");
        }
        return pacientes;
    }

    @GetMapping("/{id}")
    public Paciente obtenerPacientePorId(@PathVariable int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        throw new RuntimeException("Paciente con ID " + id + " no encontrado");
    }

    @PostMapping("/{id}/atenciones")
    public Paciente agregarAtencionMedica(@PathVariable int id, @RequestBody AtencionMedica atencionMedica) {
        Paciente paciente = obtenerPacientePorId(id);
        if (paciente != null) {
            paciente.getHistorialMedico().add(atencionMedica);
        }
        return paciente;
    }

    @GetMapping("/{id}/historial")
    public List<AtencionMedica> obtenerHistorialMedico(@PathVariable int id) {
        Paciente paciente = obtenerPacientePorId(id);
        if (paciente != null) {
            return paciente.getHistorialMedico();
        }
        throw new RuntimeException("Paciente con ID " + id + " no encontrado");
    }
}
