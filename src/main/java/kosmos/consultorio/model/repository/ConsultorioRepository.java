package kosmos.consultorio.model.repository;

import kosmos.consultorio.model.entity.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Integer> {

}
