package cafeSystem.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductWrapper {
    private Integer id;
    private String description;
    private String name;
    private Integer price;
    private String status="present";
    private Integer categoryId;
    private String categoryName;
    private String image;

    public ProductWrapper(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductWrapper(Integer id,  String name, String description, Integer price, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image= image;
    }
    
}
