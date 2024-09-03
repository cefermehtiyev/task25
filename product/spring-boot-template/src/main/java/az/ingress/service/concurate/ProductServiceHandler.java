package az.ingress.service.concurate;

import az.ingress.dao.entity.ProductEntity;
import az.ingress.dao.repository.ProductRepository;
import az.ingress.exception.NotFoundException;
import az.ingress.model.request.ProductRequest;
import az.ingress.model.response.ProductResponse;
import az.ingress.service.abstraction.DescriptionService;
import az.ingress.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static az.ingress.mapper.ProductMapper.PRODUCT_MAPPER;
import static az.ingress.model.consrants.ExceptionConstants.PRODUCT_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ProductServiceHandler implements ProductService {
    private final ProductRepository productRepository;
    private final DescriptionService descriptionService;

    @Override
    @Transactional
    public void addProduct(ProductRequest productRequest) {
        var product = productRepository.save(PRODUCT_MAPPER.buildProductEntity(productRequest));
        descriptionService.addDescription(product,productRequest.getDescription());
    }

    @Override
    public ProductResponse getProduct(Long id) {
        return PRODUCT_MAPPER.buildProductResponse(fetchProductExist(id));
    }

    @Override
    public List<ProductResponse> getProducts() {
        return productRepository.findAll().stream().map(PRODUCT_MAPPER::buildProductResponse).toList();
    }

    @Override
    public void updateProduct(Long id, ProductRequest productRequest) {
        var product = fetchProductExist(id);
        var updateProduct = PRODUCT_MAPPER.updateProductEntity(product,productRequest);
        productRepository.save(updateProduct);
    }

    @Override
    public void deleteProduct(Long id) {

    }

    private ProductEntity fetchProductExist(Long id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(PRODUCT_NOT_FOUND.getMessage(), PRODUCT_NOT_FOUND.getCode())
        );
    }
}
