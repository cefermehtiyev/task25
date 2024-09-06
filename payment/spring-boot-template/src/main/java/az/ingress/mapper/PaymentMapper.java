package az.ingress.mapper;

import az.ingress.dao.entity.PaymentEntity;
import az.ingress.model.client.ProductResponseDto;
import az.ingress.model.request.PaymentRequest;

import static az.ingress.model.enums.PaymentStatus.COMPLETED;

public enum PaymentMapper {
    PAYMENT_MAPPER;

    public PaymentEntity buildPaymentEntity(PaymentRequest paymentRequest, ProductResponseDto productResponseDto) {
        return PaymentEntity.builder()
                .productName(productResponseDto.getProductName())
                .amount(productResponseDto.getPrice())
                .cardNumber(paymentRequest.getCardNumber())
                .status(COMPLETED)
                .build();
    }
}
