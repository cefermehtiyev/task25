package az.ingress.service.abstraction;

import az.ingress.model.request.PaymentRequest;

public interface PaymentService {

    void createPayment(Long id,PaymentRequest paymentRequest);


}
