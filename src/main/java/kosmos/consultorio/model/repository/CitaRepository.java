package kosmos.consultorio.model.repository;

import java.util.Date;
import java.util.List;
import kosmos.consultorio.model.entity.Cita;
import kosmos.consultorio.model.entity.Consultorio;
import kosmos.consultorio.model.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

  List<Cita> findByConsultorio(Consultorio consultorio);
  List<Cita> findByDoctor(Doctor doctor);
  List<Cita> findByFecha(Date fecha);
}
