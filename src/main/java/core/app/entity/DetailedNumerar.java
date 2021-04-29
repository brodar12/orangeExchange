package core.app.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailedNumerar {
    private String utilizator;

    private String codValuta;

    private Integer suma;
}
