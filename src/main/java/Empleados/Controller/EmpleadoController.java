package Empleados.Controller;

import Empleados.DTO.EmpleadoDTO;
import Empleados.Services.EmpleadoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/empleados")
    @CrossOrigin(origins = "*")
    public class EmpleadoController{
        @Autowired
        private EmpleadoServices empleadoServices;

        @GetMapping
        public ResponseEntity<List<EmpleadoDTO>> listarTodos(){
            return ResponseEntity.ok(empleadoServices.obtenerTodos());
        }

        @GetMapping("/{id}")
        public ResponseEntity<EmpleadoDTO>obtenerPorId(@PathVariable Long id){
            return ResponseEntity.ok(empleadoServices.obtenerPorId(id));
        }

        @PostMapping("/{id}")
        public ResponseEntity<EmpleadoDTO>crear(@Valid @RequestBody EmpleadoDTO dto){
            return new ResponseEntity<>(empleadoServices.crear(dto), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<EmpleadoDTO>actualizar(@PathVariable Long id, @Valid @RequestBody EmpleadoDTO dto){
            return ResponseEntity.ok(empleadoServices.actualizar(id, dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void>eliminar(@PathVariable Long id){
            empleadoServices.eliminar(id);
            return  ResponseEntity.noContent().build();
        }

}


