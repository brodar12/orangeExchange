package core.app.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "operator")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String nume;

    private String prenume;

    @OneToOne(mappedBy = "operatorId")
    private Numerar numerar;
}
