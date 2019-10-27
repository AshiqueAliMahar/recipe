package ali.ashique.recipe.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoryName;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private List<Recipe> recipes = new LinkedList<>();
}
