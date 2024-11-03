package az.ingress.service.concurate;

import az.ingress.dao.entity.ProductEntity;
import az.ingress.dao.repository.ProductRepository;
import az.ingress.exception.NotFoundException;
import az.ingress.model.request.ProductRequest;
import az.ingress.model.response.ProductResponse;
import az.ingress.service.abstraction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static az.ingress.mapper.ProductMapper.PRODUCT_MAPPER;
import static az.ingress.model.consrants.ExceptionConstants.PRODUCT_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class ProductServiceHandler implements ProductService {
    private final ProductRepository productRepository;


    @Override
    @Transactional
    public void addProduct(ProductRequest productRequest) {
        var product = PRODUCT_MAPPER.buildProductEntity(productRequest);
        PRODUCT_MAPPER.buildEntityRelations(product,productRequest.getDescription());
        productRepository.save(product);
    }


    @Override
    public ProductResponse getProduct(Long id) {
        return PRODUCT_MAPPER.buildProductResponse(fetchProductExist(id));
    }


    @Override
    public void updateProduct(Long id, ProductRequest productRequest) {
        var product = fetchProductExist(id);
        PRODUCT_MAPPER.updateProductEntity(product,productRequest);
        productRepository.save(product);
    }



    private ProductEntity fetchProductExist(Long id) {
        return productRepository.findById(id).orElseThrow(
                ()-> new NotFoundException(PRODUCT_NOT_FOUND.getMessage(), PRODUCT_NOT_FOUND.getCode())
        );
    }
}
