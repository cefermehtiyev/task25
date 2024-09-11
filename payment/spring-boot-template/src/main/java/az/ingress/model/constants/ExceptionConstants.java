package az.ingress.model.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION","Unexpected exception"),
    PAYMENT_NOT_FOUND("PAYMENT_NOT_FOUND","Payment not found"),
    CLIENT_ERROR("CLIENT_ERROR", "Client Error");

    private final String code;
    private final String message;


}
