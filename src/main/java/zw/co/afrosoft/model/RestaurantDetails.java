package zw.co.afrosoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDetails {
    @NotEmpty(message = "{name cannot be empty}")
    private String name;
    @NotEmpty(message = "{logo_url_not_empty}")
    private String logoUrl;
    @NotEmpty(message = "{address_should_not_be_not_empty}")
    private String address;
    @NotEmpty(message = "{restaurantId_should_not_be_empty}")
    private Long restaurantUserId;
    @NotEmpty(message = "{contact_details_should_not_be_empty}")
    private String contactDetails;




}
