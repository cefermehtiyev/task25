package az.ingress.mapper;

import az.ingress.dao.entity.ProductEntity;
import az.ingress.model.enums.ProductStatus;
import az.ingress.model.request.ProductRequest;
import az.ingress.model.response.ProductResponse;
import org.springframework.data.domain.PageRequest;

import static az.ingress.model.enums.ProductStatus.AVAILABLE;

public enum ProductMapper {
    PRODUCT_MAPPER;

    public ProductEntity buildProductEntity(ProductRequest productRequest) {
        return ProductEntity.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .status(AVAILABLE)
                .build();
    }

    public ProductResponse buildProductResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .id(productEntity.getId())
                .productName(productEntity.getProductName())
                .price(productEntity.getPrice())
                .build();
    }
    public ProductEntity updateProductEntity(ProductEntity productEntity,ProductRequest productRequest) {
        return ProductEntity.builder().
                id(productEntity.getId())
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice()).status(productEntity.getStatus())
                .status(productEntity.getStatus())
                .build();
    }


}
