package az.ingress.model.consrants;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionConstants {
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION", "unexpected Exception"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION("HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION", "HTTP request method not supported"),
    PRODUCT_NOT_FOUND("PRODUCT_NOT_FOUND", "Product not Found"),
    DESCRIPTION_NOT_FOUND("DESCRIPTION_NOT_FOUND", "description Not Found"),
    ;

    private final String code;
    private final String message;


}
