package Empleados.Repository;

import Empleados.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
}
