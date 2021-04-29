package core.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "curs_valutar")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CursValutar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cod_valuta")
    private String codValuta;

    private Integer rata;

    private Double curs;

    @Column(name = "data_adaugare")
    private LocalDateTime dataAdaugare;

    @JsonIgnore
    @OneToOne(mappedBy = "cursValutarId")
    private Numerar numerar;


}
