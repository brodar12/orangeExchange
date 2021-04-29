package core.app.repository;

import core.app.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OperatorRepository extends JpaRepository<Operator, Integer> {

    @Query("select o from Operator o where o.username = ?1")
    Operator findOperatorPerUsername(String username);

}
