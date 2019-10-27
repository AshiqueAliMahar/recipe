package ali.ashique.recipe.commandObjects;

import ali.ashique.recipe.models.Recipe;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Data
public class CategoryCommand {
    private long id;
    private String categoryName;
}
