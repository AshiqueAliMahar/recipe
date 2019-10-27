package ali.ashique.recipe.models;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Data()
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"recipe"})
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String notes;
    @OneToOne(mappedBy = "notes")
    private Recipe recipe;
}
