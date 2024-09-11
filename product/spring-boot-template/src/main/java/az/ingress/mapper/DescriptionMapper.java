package az.ingress.mapper;

import az.ingress.dao.entity.DescriptionEntity;
import az.ingress.model.request.DescriptionRequest;
import az.ingress.model.response.DescriptionResponse;

public enum DescriptionMapper {
    DESCRIPTION_MAPPER;

    public DescriptionEntity buildDescriptionEntity(DescriptionRequest descriptionRequest){
        return DescriptionEntity.builder()
                .description(descriptionRequest.getDescription())
                .build();
    }

    public DescriptionResponse buildDescriptionResponse(DescriptionEntity descriptionEntity){
        return DescriptionResponse.builder().id(descriptionEntity.getId())
                .description(descriptionEntity.getDescription())
                .build();
    }
}
