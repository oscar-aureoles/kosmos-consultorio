package kosmos.consultorio.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CitaDetailDto {

  private Integer id;
  private String consultorio;
  private String doctor;
  private String fecha;
  private String horaInicio;
  private String horaFin;
  private String nombrePaciente;
  private String apPaternoPaciente;
  private String apMaternoPaciente;
}
