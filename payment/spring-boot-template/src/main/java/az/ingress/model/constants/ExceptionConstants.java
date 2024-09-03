package az.ingress.model.constants;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION","Unexpected exception"),
    PAYMENT_NOT_FOUND("PAYMENT_NOT_FOUND","Payment not found"),;

    String code;
    String message;


}
