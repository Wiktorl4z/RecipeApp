package wiktorApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import wiktorApp.domain.Category;
import wiktorApp.domain.UnitOfMeasure;
import wiktorApp.respositories.CategoryRepository;
import wiktorApp.respositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {

    CategoryRepository categoryRepository;
    UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> measure = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category: " + category.get().getId());
        System.out.println("Measure: " + measure.get().getId());
        return "index";
    }
}
