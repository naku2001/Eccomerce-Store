package zw.co.afrosoft.security.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.model.MenuRequest;
import zw.co.afrosoft.model.RestaurantDetails;


public interface RestaurantService {
    ResponseEntity addDish(MenuRequest request, Long id);

    ResponseEntity delete(Long id);

    ResponseEntity getAll();

    ResponseEntity getAllDishes();

    ResponseEntity getDish(Long id);

    ResponseEntity getRestaurant(Long id);

    ResponseEntity createRestaurant(RestaurantDetails request);

//    ResponseEntity createRestaurant(RestaurantDetails request, Long id);
}
