package az.ingress.service.abstraction;

import az.ingress.model.request.ProductRequest;
import az.ingress.model.response.ProductResponse;

import java.util.List;

public interface ProductService {
    void addProduct(ProductRequest productRequest);
    ProductResponse getProduct(Long id);
    List<ProductResponse> getProducts();
    void updateProduct(Long id,ProductRequest productRequest);
    void deleteProduct(Long id);

}
