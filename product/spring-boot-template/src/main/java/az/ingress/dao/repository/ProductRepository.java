package az.ingress.dao.repository;

import az.ingress.dao.entity.ProductEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity ,Long> {
}
