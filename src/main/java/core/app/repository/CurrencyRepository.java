package core.app.repository;

import core.app.entity.CursValutar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CurrencyRepository extends JpaRepository<CursValutar, Integer> {

    @Query("select c from CursValutar c where c.codValuta = ?1")
    CursValutar findPerCursValutar(String codValuta);

}
