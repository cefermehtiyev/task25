package az.ingress.service.concurate;

import az.ingress.dao.entity.DescriptionEntity;
import az.ingress.dao.entity.ProductEntity;
import az.ingress.dao.repository.DescriptionRepository;
import az.ingress.exception.NotFoundException;
import az.ingress.model.request.DescriptionRequest;
import az.ingress.model.response.DescriptionResponse;
import az.ingress.service.abstraction.DescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.ingress.mapper.DescriptionMapper.DESCRIPTION_MAPPER;
import static az.ingress.model.consrants.ExceptionConstants.DESCRIPTION_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class DescriptionServiceHandler implements DescriptionService {


    private final DescriptionRepository descriptionRepository;



    @Override
    public DescriptionResponse getDescription(Long id) {
        return DESCRIPTION_MAPPER.buildDescriptionResponse(fetchDescriptionExist(id));
    }

    private DescriptionEntity fetchDescriptionExist(Long id) {
        return  descriptionRepository.findById(id).orElseThrow(
                ()->new NotFoundException(DESCRIPTION_NOT_FOUND.getMessage(), DESCRIPTION_NOT_FOUND.getCode() )
        );
    }
}
