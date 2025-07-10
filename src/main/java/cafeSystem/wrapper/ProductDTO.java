package cafeSystem.wrapper;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "CategoryId is required")
    private Integer categoryId;

    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 0, message = "Price must be non-negative")
    private Integer price;

    private String image;
} 