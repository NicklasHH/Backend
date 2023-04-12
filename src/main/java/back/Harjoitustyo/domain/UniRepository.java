package back.Harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UniRepository extends CrudRepository<Uni, Long> {
	List<Uni> findByPvm(String pvm);

}
