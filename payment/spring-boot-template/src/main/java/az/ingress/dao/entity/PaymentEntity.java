package az.ingress.dao.entity;

import az.ingress.model.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payments")
@Entity
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String productName;
    private BigDecimal amount;
    private String cardNumber;
    @Version
    private Long version;

    @Enumerated(STRING)
    private PaymentStatus status;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
