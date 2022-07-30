package sd.wekala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.Client;
import sd.wekala.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	List<Invoice> findByC(Client c);

	List<Invoice> findByCOrderByCDesc(Client c);

	//Invoice findByCOrderByCDesc(Long id);
}
