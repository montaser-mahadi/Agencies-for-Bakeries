package sd.wekala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.Weat;

@Repository
public interface WeatRepository extends JpaRepository<Weat, Long> {

	Iterable<Weat> findByWeatNameContaining(String weatName);

	Iterable<Weat> findByWeatPhoneContaining(String weatPhone);
}
