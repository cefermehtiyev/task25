package az.ingress.controller;

import az.ingress.model.request.ProductRequest;
import az.ingress.model.response.ProductResponse;
import az.ingress.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);
    }

    @PutMapping("{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        productService.updateProduct(id,productRequest);
    }

    @GetMapping
    public ProductResponse getProduct(@RequestParam Long id){
        return productService.getProduct(id);
    }



}
