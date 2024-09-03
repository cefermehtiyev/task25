package az.ingress.controller;

import az.ingress.model.request.PaymentRequest;
import az.ingress.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("{id}")
    public void createPayment(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest){
        paymentService.createPayment(id, paymentRequest);
    }
}
