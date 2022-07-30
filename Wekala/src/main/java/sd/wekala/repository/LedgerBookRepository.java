package sd.wekala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.LedgerBook;

@Repository
public interface LedgerBookRepository extends JpaRepository<LedgerBook, Long> {

}
