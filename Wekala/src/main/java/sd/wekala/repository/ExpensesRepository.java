package sd.wekala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sd.wekala.model.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

}
