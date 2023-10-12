package worldnew.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class CraftedResource implements Resource {

    private String name;
    private Double price;
    private Integer quantity;
    private List<Resource> ingredients;

    public void addIngredient(Resource resource) {
        ingredients.add(resource);
    }

    public void removeIngredient(String resourceName) {
        Optional<Resource> resource = ingredients.stream()
                .filter(ingredient -> ingredient.getName().equalsIgnoreCase(resourceName)).findFirst();
        resource.ifPresent(value -> ingredients.remove(value));
    }

    @Override
    public double calculatePrice() {
        double total = 0.0;
        for (Resource ingredient : ingredients) {
            total += ingredient.calculatePrice();
        }
        return total;
    }
}
