package ali.ashique.recipe.commandObjects;

import ali.ashique.recipe.models.UnitOfMeasure;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class IngredientCommand {
    private long id;

    private long recipeId;
    @NotBlank
    @Size(min = 5, max = 255, message = "Description Must be of 5-255 characters")
    private String description;

    private double amount;
    private UnitOfMeasureCommand unitOfMeasureCommand;
}
