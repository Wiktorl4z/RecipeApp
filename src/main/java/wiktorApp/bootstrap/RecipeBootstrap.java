package wiktorApp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import wiktorApp.domain.Recipe;
import wiktorApp.respositories.CategoryRepository;
import wiktorApp.respositories.RecipeRepository;
import wiktorApp.respositories.UnitOfMeasureRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipe());
    }

    private List<Recipe> getRecipe() {

        List<Recipe> recipes = new ArrayList<>(2);



        return null;


    }
}
