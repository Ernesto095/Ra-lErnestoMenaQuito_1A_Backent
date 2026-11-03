package Empleados.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmpleadoDTO {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 20, message = "EL nombre debe tener mas de 3 caracteres y menos de 20 caracteres")
    private String nombre;

    @NotNull(message = "El apellido no puede estar vacio")
    @Size(min = 3, max = 20, message = "EL apellido debe tener mas de 3 caracteres y menos de 20 caracteres")
    private String apellido;

    @NotNull(message = "El email no puede estar vacio")
    @Size(min = 3, max = 30, message = "EL email debe tener mas de 3 caracteres y menos de 30 caracteres")
    private String email;

    private LocalDate fechaNacimiento;

    @NotNull(message = "El estado civil no puede estar vacio")
    @Size(min = 3, max = 15, message = "EL estado civil debe tener mas de 3 caracteres y menos de 15 caracteres")
    private String estadoCivil;

    @NotNull(message = "El sueldo no puede estar vacio")
    @Positive(message = "EL sueldo debe ser mayor a 0")
    private BigDecimal sueldo;

    public EmpleadoDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }
}
