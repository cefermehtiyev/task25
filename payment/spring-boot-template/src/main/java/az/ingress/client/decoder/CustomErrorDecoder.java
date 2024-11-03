package az.ingress.client.decoder;

import az.ingress.exception.CustomFeignException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import static az.ingress.client.decoder.JsonNodeFieldName.CODE;
import static az.ingress.client.decoder.JsonNodeFieldName.MESSAGE;
import static az.ingress.model.constants.ExceptionConstants.CLIENT_ERROR;

@Slf4j
public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey,
                            Response response){
        var errorMessage = CLIENT_ERROR.getMessage();
        var errorCode = CLIENT_ERROR.getCode();


        JsonNode jsonNode;

        try(var body = response.body().asInputStream()){
            jsonNode = new ObjectMapper().readValue(body,JsonNode.class);
        }catch (Exception e){
            throw new CustomFeignException(CLIENT_ERROR.getMessage(),CLIENT_ERROR.getCode(), response.status());

        }

        if (jsonNode.has(MESSAGE.getValue())&&jsonNode.has(CODE.getValue())){
            errorMessage = jsonNode.get(MESSAGE.getValue()).asText();
            errorCode = jsonNode.get(CODE.getValue()).asText();
        }

        log.error("ActionLog.decode.error Message: {},Code: {} , Method: {}",errorMessage,errorCode,methodKey);
        return new CustomFeignException(errorMessage,errorCode,response.status());
    }
}
