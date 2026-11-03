package Empleados.Services;

import Empleados.DTO.EmpleadoDTO;
import Empleados.Entity.Empleado;
import Empleados.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmpleadoServices {
    @Autowired
    private EmpleadoRepository empleadoRepository;


    public List<EmpleadoDTO> obtenerTodos(){
        return empleadoRepository.findAll()
                .stream()
                .map(this::convertirADTo)
                .toList();
    }

    public EmpleadoDTO obtenerPorId(Long id){
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con Id:" + id));
        return convertirADTo(empleado);
    }

    public EmpleadoDTO crear(EmpleadoDTO dto){
        Empleado empleado = new Empleado();
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setEmail(dto.getEmail());
        empleado.setFechaNacimiento(LocalDate.now());
        empleado.setEstadoCivil(dto.getEstadoCivil());
        empleado.setSueldo(dto.getSueldo());

        Empleado guardado = empleadoRepository.save(empleado);
        return convertirADTo(guardado);
    }

    public EmpleadoDTO actualizar(Long id, EmpleadoDTO dto){
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(()  -> new RuntimeException("Empleado no encontrado con ese ID:"+ id));
        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setEmail(dto.getEmail());
        empleado.setEstadoCivil(dto.getEstadoCivil());
        empleado.setSueldo(dto.getSueldo());

        Empleado actualizado = empleadoRepository.save(empleado);
        return convertirADTo(actualizado);
    }

    public void eliminar (Long id){
        if (!empleadoRepository.existsById(id)){
            throw new RuntimeException("No existe el id:"+ id);
        }
        empleadoRepository.deleteById(id);
    }


    private EmpleadoDTO convertirADTo(Empleado empleado){
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(empleado.getId());
        dto.setNombre(empleado.getNombre());
        dto.setApellido(empleado.getApellido());
        dto.setEmail(empleado.getEmail());
        dto.setFechaNacimiento(empleado.getFechaNacimiento());
        dto.setEstadoCivil(empleado.getEstadoCivil());
        dto.setSueldo(empleado.getSueldo());
        return dto;
    }
}
