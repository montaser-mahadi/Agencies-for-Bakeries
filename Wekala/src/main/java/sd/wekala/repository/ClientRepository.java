package sd.wekala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.Client;
import sd.wekala.model.Invoice;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Iterable<Client> findByClientNameContaining(String clientName);

	Iterable<Client> findByClientPhoneContaining(String clientPhone);

	Client findClientByInvoice(Invoice invoice);

}
