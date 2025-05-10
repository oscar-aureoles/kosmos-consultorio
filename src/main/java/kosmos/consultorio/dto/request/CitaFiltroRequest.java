package kosmos.consultorio.dto.request;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CitaFiltroRequest {

  private Date fecha;
  private Integer consultorioId;
  private Integer doctorId;
}
