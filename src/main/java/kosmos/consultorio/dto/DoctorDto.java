package kosmos.consultorio.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DoctorDto {

  private String id;

  private String nombre;

  private String apellidoParterno;

  private String apellidoMaterno;

  private String especialidad;
}
