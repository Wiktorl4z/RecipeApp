package wiktorApp.respositories;

import org.springframework.data.repository.CrudRepository;
import wiktorApp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
