package wiktorApp.respositories;

import org.springframework.data.repository.CrudRepository;
import wiktorApp.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
