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
@Table(name = "consultorio", catalog = "kosmos")
@Data
@NoArgsConstructor
public class Consultorio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "numero", nullable = false)
  private Integer numero;

  @Column(name = "piso", nullable = false)
  private Integer piso;
}
