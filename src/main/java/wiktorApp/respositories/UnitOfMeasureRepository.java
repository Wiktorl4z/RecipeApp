package wiktorApp.respositories;

import org.springframework.data.repository.CrudRepository;
import wiktorApp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
