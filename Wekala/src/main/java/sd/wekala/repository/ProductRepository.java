package sd.wekala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.Invoice;
import sd.wekala.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product>  findProductByInvoice(List<Invoice> invoice);
}
