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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest){
        productService.updateProduct(id,productRequest);
    }

    @GetMapping("{id}")
    public ProductResponse getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }



}
