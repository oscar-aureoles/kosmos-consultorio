package kosmos.consultorio.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import kosmos.consultorio.dto.CitaDetailDto;
import kosmos.consultorio.dto.CitaDto;
import kosmos.consultorio.dto.request.AltaCitaRequest;
import kosmos.consultorio.dto.request.CitaFiltroRequest;
import kosmos.consultorio.model.entity.Cita;
import kosmos.consultorio.model.entity.Consultorio;
import kosmos.consultorio.model.entity.Doctor;
import kosmos.consultorio.model.repository.CitaRepository;
import kosmos.consultorio.model.repository.ConsultorioRepository;
import kosmos.consultorio.model.repository.DoctorRepository;
import kosmos.consultorio.service.CitaService;
import kosmos.consultorio.util.ConvertTypes;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CitaServiceImpl implements CitaService {

  private final CitaRepository citaRepository;

  private final ConsultorioRepository consultorioRepository;

  private final DoctorRepository doctorRepository;

  private final ConvertTypes convertTypes;
  public CitaServiceImpl(CitaRepository citaRepository, ConsultorioRepository consultorioRepository,
      DoctorRepository doctorRepository, ConvertTypes convertTypes) {
    this.citaRepository = citaRepository;
    this.consultorioRepository = consultorioRepository;
    this.doctorRepository = doctorRepository;
    this.convertTypes = convertTypes;
  }

  @Override
  public CitaDto saveCita(AltaCitaRequest altaCitaRequest) {
    log.info("Request: " + altaCitaRequest.toString());

    Consultorio consultorio = consultorioRepository.findById(altaCitaRequest.getConsultorio())
        .orElseThrow(()-> new ExecutionException("No se encontro el consultorio"));

    Doctor doctor = doctorRepository.findById(altaCitaRequest.getDoctor())
        .orElseThrow(()-> new ExecutionException("No se encontro el doctor"));
    Cita cita = new Cita();
    cita.setConsultorio(consultorio);
    cita.setDoctor(doctor);
    cita.setFecha(convertTypes.transformStringDate(altaCitaRequest.getFecha()));
    cita.setHoraInicio(convertTypes.transformStringTime(altaCitaRequest.getHoraInicio()));
    cita.setHoraFin(convertTypes.transformStringTime(altaCitaRequest.getHoraFin()));
    cita.setNombrePaciente(altaCitaRequest.getNombrePaciente());
    cita.setApPaternoPaciente(altaCitaRequest.getApPaternoPaciente());
    cita.setApMaternoPaciente(altaCitaRequest.getApMaternoPaciente());

    cita = citaRepository.save(cita);

    return CitaDto.builder()
        .id(cita.getId())
        .build();
  }

  @Override
  public List<CitaDetailDto> getCitasFiltro(CitaFiltroRequest citaFiltroRequest) {
    log.info("data: " + citaFiltroRequest);
    if (Objects.nonNull(citaFiltroRequest)) {
      Date fecha = citaFiltroRequest.getFecha();
      Integer consultorioId = citaFiltroRequest.getConsultorioId();
      Integer doctorId = citaFiltroRequest.getDoctorId();

      if (Objects.nonNull(fecha)) {
        log.info("fecha:" + fecha);
        return transformDto(citaRepository.findByFecha(fecha));
      } else if (Objects.nonNull(consultorioId)) {
        Consultorio consultorio = consultorioRepository.findById(consultorioId)
            .orElseThrow(()-> new ExecutionException("No se encontro el consultorio"));

        return transformDto(citaRepository.findByConsultorio(consultorio));
      } else {
        log.info("doctorId:" + doctorId);
        Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(()-> new ExecutionException("No se encontro el doctor"));
        return transformDto(citaRepository.findByDoctor(doctor));
      }
    } else {
      return transformDto(citaRepository.findAll());
    }
  }

   private List<CitaDetailDto> transformDto(List<Cita> list) {
     return list.stream().map(cita -> CitaDetailDto.builder()
         .id(cita.getId())
         .consultorio(cita.getConsultorio().getNumero().toString())
         .doctor(cita.getDoctor().getNombre() + " " + cita.getDoctor().getApellidoParterno()
             + " " + cita.getDoctor().getApellidoMaterno())
         .fecha(cita.getFecha().toString())
         .horaInicio(cita.getHoraInicio().toString())
         .horaFin(cita.getHoraFin().toString())
         .nombrePaciente(cita.getNombrePaciente())
         .apPaternoPaciente(cita.getApPaternoPaciente())
         .apMaternoPaciente(cita.getApMaternoPaciente())
         .build()).collect(Collectors.toList());
   }
}
