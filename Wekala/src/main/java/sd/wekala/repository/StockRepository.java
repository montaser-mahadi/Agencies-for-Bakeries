package sd.wekala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

}
