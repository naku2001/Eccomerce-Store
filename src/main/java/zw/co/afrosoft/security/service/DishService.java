package zw.co.afrosoft.security.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.model.MenuRequest;

public interface DishService {
    ResponseEntity getDish(Long id);

    ResponseEntity getAllDishes();

    ResponseEntity delete(Long id);

    ResponseEntity addDish(MenuRequest request);
}
