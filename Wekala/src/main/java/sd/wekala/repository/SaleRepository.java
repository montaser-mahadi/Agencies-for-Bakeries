package sd.wekala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
