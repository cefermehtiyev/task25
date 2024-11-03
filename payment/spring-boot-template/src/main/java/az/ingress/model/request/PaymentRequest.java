package az.ingress.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentRequest {
    private BigDecimal amount;
    private String cardNumber;
}
