package zw.co.afrosoft.security.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.model.MenuRequest;
import zw.co.afrosoft.model.RestaurantDetails;

@Service
public class RestaurantServiceImpl implements RestaurantService{


    @Override
    public ResponseEntity addDish(MenuRequest request, Long id) {
        return null;
    }
    @Override
    public ResponseEntity delete(Long id) {
        return null;
    }
    @Override
    public ResponseEntity getAll() {
        return null;
    }
    @Override
    public ResponseEntity getAllDishes() {
        return null;
    }
    @Override
    public ResponseEntity getDish(Long id) {
        return null;
    }
    @Override
    public ResponseEntity getRestaurant(Long id) {
        return null;
    }

    @Override
    public ResponseEntity createRestaurant(RestaurantDetails request) {
        return null;
    }
}
