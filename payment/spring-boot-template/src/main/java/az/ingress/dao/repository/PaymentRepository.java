package az.ingress.dao.repository;

import az.ingress.dao.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
