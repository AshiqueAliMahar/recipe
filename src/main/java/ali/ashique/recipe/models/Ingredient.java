package ali.ashique.recipe.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"recipe"})
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private double amount;

    @ManyToOne
    @Autowired
    private Recipe recipe;

    @OneToOne
    private UnitOfMeasure unitOfMeasure;
}
