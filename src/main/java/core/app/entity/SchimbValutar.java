package core.app.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "schimb_valutar")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchimbValutar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "curs_valutar_id")
    private Integer cursValutar;

    @Column(name = "operator_id")
    private Integer operator;

    @Column(name = "suma_primita")
    private Integer sumaPrimita;

    @Column(name = "suma_eliberata")
    private Integer sumaEliberata;

    @Column(name = "data_efectuare_operatiune")
    private LocalDateTime dataEfectuareOperatiune;


}
