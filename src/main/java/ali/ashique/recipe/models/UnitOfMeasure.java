package ali.ashique.recipe.models;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String unitOfMeasure;

    public UnitOfMeasure() {
    }

    public UnitOfMeasure(long id, String unitOfMeasure) {
        this.id = id;
        this.unitOfMeasure = unitOfMeasure;
    }

}
