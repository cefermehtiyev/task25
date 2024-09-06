package az.ingress.service.concurate;

import az.ingress.client.ProductClient;
import az.ingress.dao.repository.PaymentRepository;
import az.ingress.model.request.PaymentRequest;
import az.ingress.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static az.ingress.mapper.PaymentMapper.PAYMENT_MAPPER;
@RequiredArgsConstructor
@Service
public class PaymentServiceHandler implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ProductClient productClient;


    @Override
    public void createPayment(Long id, PaymentRequest paymentRequest) {
        var product = productClient.getProduct(id);
        var payment = PAYMENT_MAPPER.buildPaymentEntity(paymentRequest,product);
        paymentRepository.save(payment);
    }
}
