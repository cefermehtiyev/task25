package az.ingress.controller;

import az.ingress.model.response.ProductResponse;
import az.ingress.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("internal/v1/products")
public class InternalProductController {
    private final ProductService productService;

    @GetMapping("{id}")
    public ProductResponse getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }


}
