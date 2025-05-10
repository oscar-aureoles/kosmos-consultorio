package kosmos.consultorio.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "doctor", catalog = "kosmos")
@Data
@NoArgsConstructor
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "nombre", length = 50, nullable = false)
  private String nombre;

  @Column(name = "ap_paterno", length = 50, nullable = false)
  private String apellidoParterno;

  @Column(name = "ap_materno", length = 50, nullable = false)
  private String apellidoMaterno;

  @Column(name = "especialidad", length = 50, nullable = false)
  private String especialidad;
}
