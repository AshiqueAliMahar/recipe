package ali.ashique.recipe.repositories;

import ali.ashique.recipe.models.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepoTest {

    @Autowired
    UnitOfMeasureRepo unitOfMeasureRepo;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByDescription() {
        Optional<UnitOfMeasure> tea_spoon = unitOfMeasureRepo.findByUnitOfMeasure("tea spoon");
        assertEquals("tea spoon", tea_spoon.get().getUnitOfMeasure());
    }
}