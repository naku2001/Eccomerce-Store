package zw.co.afrosoft.security.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.model.MenuRequest;
import zw.co.afrosoft.model.RestaurantDetails;


public interface RestaurantService {


    ResponseEntity getAll();



    ResponseEntity getRestaurant(Long id);

    ResponseEntity createRestaurant(RestaurantDetails request);


}
