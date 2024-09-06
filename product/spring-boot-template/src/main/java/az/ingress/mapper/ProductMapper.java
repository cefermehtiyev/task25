package az.ingress.mapper;

import az.ingress.dao.entity.ProductEntity;
import az.ingress.model.request.DescriptionRequest;
import az.ingress.model.request.ProductRequest;
import az.ingress.model.response.ProductResponse;

import static az.ingress.mapper.DescriptionMapper.DESCRIPTION_MAPPER;
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

    public void buildEntityRelations(ProductEntity product, DescriptionRequest descriptionRequest){
          product.setDescription(DESCRIPTION_MAPPER.buildDescriptionEntity(descriptionRequest));
          product.getDescription().setProduct(product);
    }

    public ProductResponse buildProductResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .id(productEntity.getId())
                .productName(productEntity.getProductName())
                .price(productEntity.getPrice())
                .build();
    }
    public void updateProductEntity(ProductEntity productEntity,ProductRequest productRequest) {
            productEntity.setProductName(productRequest.getProductName());
            productEntity.setPrice(productRequest.getPrice());
            productEntity.getDescription().setDescription(productRequest.getDescription().getDescription());

    }


}
