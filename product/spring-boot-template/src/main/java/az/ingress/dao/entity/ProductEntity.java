package az.ingress.dao.entity;

import az.ingress.model.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@Builder
@Entity
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String productName;
    private BigDecimal price;

    @Enumerated(STRING)
    private ProductStatus status;

    @OneToOne(
            mappedBy = "product",
            cascade = {PERSIST,MERGE},
            fetch = LAZY
    )
    DescriptionEntity description;

    @CreationTimestamp
    LocalDateTime created_at;
    @UpdateTimestamp
    LocalDateTime updated_at;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
