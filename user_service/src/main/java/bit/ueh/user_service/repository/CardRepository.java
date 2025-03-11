package bit.ueh.user_service.repository;

import bit.ueh.user_service.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}