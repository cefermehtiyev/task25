package az.ingress.model.consrants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("Unexpected exception", "unexpected Exception"),
    PRODUCT_NOT_FOUND("PRODUCT_NOT_FOUND", "Product not Found"),
    DESCRIPTION_NOT_FOUND("DESCRIPTION_NOT_FOUND", "description Not Found"),;

    String code;
    String message;


}
