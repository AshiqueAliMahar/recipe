package ali.ashique.recipe.controler;

import ali.ashique.recipe.models.Recipe;
import ali.ashique.recipe.repositories.RecipeRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class indexTest {

    @Mock
    RecipeRepo recipeRepo;
    @Mock
    Model model;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockMVCTest() throws Exception {
        index indexObj = new index(recipeRepo, null, null, null);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexObj).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/indexs")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void show() {
        index index = new index(recipeRepo, null, null, null);
        String show = index.show(model);
        assertEquals(show, "index");
        List<Recipe> recipes = Arrays.asList(new Recipe(), new Recipe());
        Mockito.when(recipeRepo.findAll()).thenReturn(recipes);
        Mockito.verify(recipeRepo, Mockito.times(1)).findAll();
        Iterable<Recipe> all = recipeRepo.findAll();


        Mockito.verify(model, Mockito.times(1)).addAttribute(ArgumentMatchers.eq("recipes"), ArgumentMatchers.anyList());
    }
}