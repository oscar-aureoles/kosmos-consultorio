package kosmos.consultorio.dto;

import java.sql.Date;
import java.sql.Time;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CitaDto {

  private Integer id;
  private Integer consultorio;
  private Integer doctor;
  private Date fecha;
  private Time horaInicio;
  private Time horaFin;
  private String nombrePaciente;
  private String apPaternoPaciente;
  private String apMaternoPaciente;
}
