package ali.ashique.recipe.commandObjects;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class NotesCommand {
    private long id;
    @NotEmpty
    @Size(min = 20, max = 255)
    private String notes;
}
