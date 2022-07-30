package sd.wekala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

}
