package back.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RuokaRepository extends JpaRepository<Ruoka, Long> {

	@Query("SELECT r FROM Ruoka r WHERE r.nimi LIKE %?1%" + " OR r.lisatietoja LIKE %?1%" + " OR r.pvm LIKE %?1%"
			+ " OR r.kellonaika LIKE %?1%")
	public List<Ruoka> hae(String haku);

}
