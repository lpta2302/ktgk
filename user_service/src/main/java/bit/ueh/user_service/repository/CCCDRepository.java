package bit.ueh.user_service.repository;

import bit.ueh.user_service.entity.CCCD;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CCCDRepository extends JpaRepository<CCCD, Long> {
    public Optional<CCCD> findByCccdNumber(String CccdNumber);
}