package kosmos.consultorio.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AltaCitaRequest {

  @NotBlank(message = "Campo consultorio obligatorio")
  private Integer consultorio;

  @NotBlank(message = "Campo doctor obligatorio")
  private Integer doctor;

  @NotBlank(message = "Campo fecha obligatorio")
  private String fecha;

  @NotBlank(message = "Campo horaInicio obligatorio")
  private String horaInicio;

  @NotBlank(message = "Campo horaFin obligatorio")
  private String horaFin;

  @NotBlank(message = "Campo nombrePaciente obligatorio")
  private String nombrePaciente;

  @NotBlank(message = "Campo apPaternoPaciente obligatorio")
  private String apPaternoPaciente;

  @NotBlank(message = "Campo apMaternoPaciente obligatorio")
  private String apMaternoPaciente;
}
