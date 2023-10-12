package worldnew.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RawResource implements Resource {

    private String name;
    private Double price;
    private Integer quantity;

    @Override
    public double calculatePrice() {
        return price * quantity;
    }
}
