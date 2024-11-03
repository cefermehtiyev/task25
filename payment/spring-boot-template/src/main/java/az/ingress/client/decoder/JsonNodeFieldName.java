package az.ingress.client.decoder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum JsonNodeFieldName {

    MESSAGE("message"),
    CODE("code");

    private final String value;

}
