package core.app.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "numerar")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Numerar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "curs_valutar_id", referencedColumnName = "id")
    private CursValutar cursValutarId;

    @OneToOne
    @JoinColumn(name = "operator_id", referencedColumnName = "id")
    private Operator operatorId;

    @Column(name = "suma_disponibila")
    private Integer sumaDisponibila;

    @Column(name = "data_adaugare_numerar")
    private LocalDateTime dataAdaugareNumerar;

}
