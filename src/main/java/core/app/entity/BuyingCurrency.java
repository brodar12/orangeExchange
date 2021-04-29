package core.app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BuyingCurrency {
    @JsonProperty("codValuta")
    private String currencyId;

    @JsonProperty("utilizator")
    private String operatorId;

    @JsonProperty("sumaPrimita")
    private int receivedAmount;

}
