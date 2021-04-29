package core.app.repository;

import core.app.entity.CursValutar;
import core.app.entity.Numerar;
import core.app.entity.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface NumerarRepository extends JpaRepository<Numerar, Integer> {

    @Query("select o from Numerar o where o.cursValutarId = ?1 and o.operatorId = ?2")
    Numerar findNumerarPerCodValuta(CursValutar cursValutar, Operator operator);
}
