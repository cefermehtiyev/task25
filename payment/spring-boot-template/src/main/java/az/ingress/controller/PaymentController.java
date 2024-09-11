package az.ingress.controller;

import az.ingress.model.request.PaymentRequest;
import az.ingress.service.abstraction.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("{id}")
    @ResponseStatus(CREATED)
    public void createPayment(@PathVariable Long id, @RequestBody PaymentRequest paymentRequest){
        paymentService.createPayment(id, paymentRequest);
    }
}
