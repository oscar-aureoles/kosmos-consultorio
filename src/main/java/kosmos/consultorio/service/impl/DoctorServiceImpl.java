package kosmos.consultorio.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import kosmos.consultorio.dto.DoctorDto;
import kosmos.consultorio.model.repository.DoctorRepository;
import kosmos.consultorio.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

  private final DoctorRepository doctorRepository;

  public DoctorServiceImpl(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
  }

  @Override
  public List<DoctorDto> getDoctores() {
    return doctorRepository.findAll().stream().map(doctor ->
       DoctorDto.builder()
           .id(doctor.getId().toString())
           .nombre(doctor.getNombre())
           .apellidoParterno(doctor.getApellidoParterno())
           .apellidoMaterno(doctor.getApellidoMaterno())
           .especialidad(doctor.getEspecialidad())
           .build()
    ).collect(Collectors.toList());
  }
}
