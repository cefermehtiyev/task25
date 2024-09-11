package az.ingress.client;

import az.ingress.client.decoder.CustomErrorDecoder;
import az.ingress.exception.CustomFeignException;
import az.ingress.model.client.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-product",
             url = "${feign.clients.ms-product.url}",
             configuration = CustomErrorDecoder.class )
public interface ProductClient {

    @GetMapping("/internal/v1/products/{id}")
    ProductResponseDto getProduct(@PathVariable Long id);
}
