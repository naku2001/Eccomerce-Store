package zw.co.afrosoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.model.MenuRequest;
import zw.co.afrosoft.model.RestaurantDetails;
import zw.co.afrosoft.security.service.RestaurantService;


@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private  final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }


    @PostMapping("/create-restaurant")
    ResponseEntity createRestaurant(@RequestBody RestaurantDetails request){
        return restaurantService.createRestaurant(request);
    }

    @GetMapping("/get-Allrestaurants")
    ResponseEntity getAll(){
        return restaurantService.getAll();
    }


    @GetMapping("/get-restaurant/{id}")
    ResponseEntity getRestaurant(@PathVariable Long id){
        return restaurantService.getRestaurant(id);
    }
}
