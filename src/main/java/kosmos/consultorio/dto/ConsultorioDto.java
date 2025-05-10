package kosmos.consultorio.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConsultorioDto {

  private String id;

  private String numero;

  private String piso;
}
