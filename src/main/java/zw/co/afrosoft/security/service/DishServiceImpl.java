package zw.co.afrosoft.security.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.model.Dish;
import zw.co.afrosoft.model.MenuRequest;
import zw.co.afrosoft.model.Restaurant;
import zw.co.afrosoft.model.RestaurantInfo;
import zw.co.afrosoft.repository.DishRepo;
import zw.co.afrosoft.repository.RestaurantInfoRepo;
import zw.co.afrosoft.repository.RestaurantRepo;

import java.util.List;
import java.util.Optional;
@Service
public class DishServiceImpl implements DishService{

    private final DishRepo dishRepo;
    private final RestaurantRepo restaurantRepo;
    private final RestaurantInfoRepo restaurantInfoRepo;

    public DishServiceImpl(DishRepo dishRepo, RestaurantRepo restaurantRepo,
                           RestaurantInfoRepo restaurantInfoRepo) {
        this.dishRepo = dishRepo;
        this.restaurantRepo = restaurantRepo;
        this.restaurantInfoRepo = restaurantInfoRepo;
    }

    @Override
    public ResponseEntity getDish(Long id) {
       Optional<Dish> dish = dishRepo.findById(id);
        return ResponseEntity.ok().body(dish);
    }

    @Override
    public ResponseEntity getAllDishes() {
        List<Dish> dishList = dishRepo.findAll();
        return ResponseEntity.ok().body(dishList);
    }

    @Override
    public ResponseEntity delete(Long id) {
        Optional<Dish> dish = dishRepo.findById(id);
        if(dish.isPresent()){
            dishRepo.delete(dish.get());
        }
        return  ResponseEntity.ok().body("dish not available");
    }

    @Override
    public ResponseEntity addDish(MenuRequest request) {
        Optional<RestaurantInfo> restaurant = restaurantInfoRepo.findById(request.getRestaurantId());
        if(restaurant.isPresent()){
            Dish dish = new Dish();
            dish.setRestaurant(restaurant.get());
            dish.setDishName(request.getDishName());
            dish.setImageUrl(request.getImageUrl());
            dish.setPrice(request.getPrice());
            dishRepo.save(dish);
            return  ResponseEntity.ok().body(dish);
        }
        return ResponseEntity.ok().body("Restaurant not available ");
    }
}
