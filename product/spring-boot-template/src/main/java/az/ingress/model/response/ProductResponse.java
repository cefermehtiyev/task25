package az.ingress.model.response;

import az.ingress.model.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String productName;
    private BigDecimal price;

}
