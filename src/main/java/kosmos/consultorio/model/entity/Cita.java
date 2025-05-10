package kosmos.consultorio.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Time;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cita", catalog = "kosmos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cita {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "id_doctor", nullable = false)
  private Doctor doctor;

  @ManyToOne
  @JoinColumn(name = "id_consultorio", nullable = false)
  private Consultorio consultorio;

  @Column(name = "fecha", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date fecha;

  @Column(name = "hora_inicio", nullable = false)
  @Temporal(TemporalType.TIME)
  private Time horaInicio;;

  @Column(name = "hora_fin", nullable = false)
  @Temporal(TemporalType.TIME)
  private Time horaFin;;

  @Column(name = "nombre_paciente", length = 50, nullable = false)
  private String nombrePaciente;

  @Column(name = "ap_paterno_paciente", length = 50, nullable = false)
  private String apPaternoPaciente;

  @Column(name = "ap_materno_paciente", length = 50, nullable = false)
  private String apMaternoPaciente;
}
