package zw.co.afrosoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRequest {
    @NotEmpty(message = "{food name cannot be empty}")
    private String dishName;
    @NotEmpty(message = "{image_url_not_empty}")
    private String imageUrl;
    @NotEmpty(message = "{price_not_empty}")
    private double price;
    private Long restaurantId;


}
