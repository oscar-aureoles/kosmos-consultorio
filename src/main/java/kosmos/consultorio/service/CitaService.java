package kosmos.consultorio.service;

import java.util.List;
import kosmos.consultorio.dto.CitaDetailDto;
import kosmos.consultorio.dto.CitaDto;
import kosmos.consultorio.dto.request.AltaCitaRequest;
import kosmos.consultorio.dto.request.CitaFiltroRequest;

public interface CitaService {

  CitaDto saveCita(AltaCitaRequest altaCitaRequest);

  List<CitaDetailDto> getCitasFiltro(CitaFiltroRequest citaFiltroRequest);
}
