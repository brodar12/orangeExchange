package core.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cash {
    @JsonProperty("utilizator")
    private String operatorId;

    @JsonProperty("codValuta")
    private String currencyId;

    @JsonProperty("suma")
    private double moneyAmount;

    @JsonProperty("data")
    private LocalDateTime dateTime;

}
