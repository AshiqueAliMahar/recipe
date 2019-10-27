package ali.ashique.recipe.service;

import ali.ashique.recipe.models.Recipe;
import ali.ashique.recipe.repositories.RecipeRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class RecipeServiceTest {
    @Mock
    RecipeRepo recipeRepo;
    RecipeService recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeService(recipeRepo, null);
    }

    @Test
    public void findAll() {
        Recipe recipe = new Recipe();
        List<Recipe> recipes = new LinkedList<>();
        recipes.add(recipe);

        Mockito.when(recipeService.findAll()).thenReturn(recipes);
        List<Recipe> list = recipeService.findAll();
        assertEquals(1, list.size());
        Mockito.verify(recipeRepo, Mockito.times(2)).findAll();
    }
}