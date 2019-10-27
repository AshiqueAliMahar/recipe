package ali.ashique.recipe.bootstrap;

import ali.ashique.recipe.models.*;
import ali.ashique.recipe.repositories.CategoryRepo;
import ali.ashique.recipe.repositories.RecipeRepo;
import ali.ashique.recipe.repositories.UnitOfMeasureRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepo categoryRepo;
    private RecipeRepo recipeRepo;
    private UnitOfMeasureRepo unitOfMeasureRepo;

    @Autowired
    public BootstrapData(CategoryRepo categoryRepo, RecipeRepo recipeRepo, UnitOfMeasureRepo unitOfMeasureRepo) {
        this.categoryRepo = categoryRepo;
        this.recipeRepo = recipeRepo;
        this.unitOfMeasureRepo = unitOfMeasureRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("debug bootstrap event");
        List<Category> categories = new LinkedList<>();
        Category americanCat = new Category();
        Category Italian = new Category();
        Category Mexican = new Category();
        Category Japanian = new Category();

        americanCat.setCategoryName("American");
        Italian.setCategoryName("Italian");
        Mexican.setCategoryName("Mexican");
        Japanian.setCategoryName("Mexican");
        categories = Arrays.asList(americanCat, Italian, Mexican, Japanian);
        categoryRepo.saveAll(categories);

        List<UnitOfMeasure> unitOfMeasures = Arrays.asList(new UnitOfMeasure(0, "tea spoon"), new UnitOfMeasure(0, "table spoon"), new UnitOfMeasure(0, "cup"), new UnitOfMeasure(0, "pinch"));
        unitOfMeasureRepo.saveAll(unitOfMeasures);

        final Optional<Category> american = categoryRepo.findByCategoryName("American");
        final Optional<Category> italian = categoryRepo.findByCategoryName("Italian");
        final Optional<UnitOfMeasure> teaSpoon = unitOfMeasureRepo.findByUnitOfMeasure("tea spoon");
        final Optional<UnitOfMeasure> tableSpoon = unitOfMeasureRepo.findByUnitOfMeasure("table spoon");
        Recipe recipe = new Recipe();//"Spicy Grilled Chicken Tacos",20,15,"4 To 6 Servings","Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.","https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/","Look for ancho chile powder with the Mexican ingredients at your", Difficulty.EASY,null,new Notes("Note chicken taco"),ingredientList,null);
        recipe.setDescription("Spicy Grilled Chicken Tacos");
        recipe.setPrepTime(20);
        recipe.setCookTime(15);
        recipe.setServings("4 To 6 Servings");
        recipe.setSource("Spicy grilled chicken tacos! Quick marinade source");
        recipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        recipe.setDirections("Look for ancho chile powder with the Mexican ingredients at your directions");
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setNotes(new Notes(0, "Note1", recipe));

        recipe.getIngredients().add(new Ingredient(0, "ancho chili powder", 2, recipe, teaSpoon.get()));
        recipe.getIngredients().add(new Ingredient(0, "powder ", 3, recipe, tableSpoon.get()));
        recipe.getCategories().add(american.get());
        recipe.getCategories().add(italian.get());
        Recipe save = recipeRepo.save(recipe);

        Recipe guacRecipe = new Recipe();//"Spicy Grilled Chicken Tacos",20,15,"4 To 6 Servings","Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.","https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/","Look for ancho chile powder with the Mexican ingredients at your", Difficulty.EASY,null,new Notes("Note chicken taco"),ingredientList,null);
        guacRecipe.setDescription("GuacRecipe");
        guacRecipe.setPrepTime(15);
        guacRecipe.setCookTime(10);
        guacRecipe.setServings("4 To 5 Servings");
        guacRecipe.setSource("Spicy guac recipe! Quick marinade source");
        guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy/");
        guacRecipe.setDirections("directions for guac recipe");
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setNotes(new Notes(0, "guac recipe note", guacRecipe));

        guacRecipe.getIngredients().add(new Ingredient(0, "ancho chili powder guac", 2, guacRecipe, teaSpoon.get()));
        guacRecipe.getIngredients().add(new Ingredient(0, "powderguac  ", 3, guacRecipe, tableSpoon.get()));
        guacRecipe.getCategories().add(american.get());
        guacRecipe.getCategories().add(italian.get());
        recipeRepo.save(guacRecipe);
    }
}