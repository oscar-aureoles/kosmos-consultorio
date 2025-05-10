package kosmos.consultorio.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import kosmos.consultorio.dto.ConsultorioDto;
import kosmos.consultorio.model.repository.ConsultorioRepository;
import kosmos.consultorio.service.ConsultorioService;
import org.springframework.stereotype.Service;

@Service
public class ConsultorioServiceImpl implements ConsultorioService {

  private final ConsultorioRepository consultorioRepository;

  public ConsultorioServiceImpl(ConsultorioRepository consultorioRepository) {
    this.consultorioRepository = consultorioRepository;
  }

  @Override
  public List<ConsultorioDto> getConsultorios() {
    return consultorioRepository.findAll().stream().map(consultorio ->
        ConsultorioDto.builder()
            .id(consultorio.getId().toString())
            .numero(consultorio.getNumero().toString())
            .piso(consultorio.getPiso().toString())
            .build()
    ).collect(Collectors.toList());
  }
}
