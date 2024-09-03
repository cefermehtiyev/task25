package az.ingress.client;

import az.ingress.model.client.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-product",url = "http://localhost:9999")
public interface ProductClient {

    @GetMapping("/internal/v1/product/{id}")
    ProductResponseDto getProduct(@PathVariable Long id);
}
