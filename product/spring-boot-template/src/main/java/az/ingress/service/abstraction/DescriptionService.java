package az.ingress.service.abstraction;

import az.ingress.dao.entity.ProductEntity;
import az.ingress.model.request.DescriptionRequest;
import az.ingress.model.response.DescriptionResponse;

public interface DescriptionService {
    void addDescription(ProductEntity product,DescriptionRequest descriptionRequest);
    DescriptionResponse getDescription(Long id);
}
