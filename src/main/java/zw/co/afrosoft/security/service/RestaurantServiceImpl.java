package zw.co.afrosoft.security.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.model.Restaurant;
import zw.co.afrosoft.model.RestaurantDetails;
import zw.co.afrosoft.model.RestaurantInfo;
import zw.co.afrosoft.repository.RestaurantInfoRepo;
import zw.co.afrosoft.repository.RestaurantRepo;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantRepo restaurantRepo;
    private final RestaurantInfoRepo restaurantInfoRepo;

    public RestaurantServiceImpl(RestaurantRepo restaurantRepo, RestaurantInfoRepo restaurantInfoRepo) {
        this.restaurantRepo = restaurantRepo;
        this.restaurantInfoRepo = restaurantInfoRepo;
    }
    @Override
    public ResponseEntity getAll() {
        List<RestaurantInfo> restaurantList = restaurantInfoRepo.findAll();
        return ResponseEntity.ok().body(restaurantList);
    }@Override
    public ResponseEntity getRestaurant(Long id) {
        Optional<RestaurantInfo> restaurantOptional = restaurantInfoRepo.findById(id);
        return ResponseEntity.ok().body(restaurantOptional);}
    @Override
    public ResponseEntity createRestaurant(RestaurantDetails request) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(request.getRestaurantUserId());
        if(restaurant.isPresent()){
            RestaurantInfo restaurantInfo = new RestaurantInfo();
            restaurantInfo.setRestaurantUser(restaurant.get());
            restaurantInfo.setName(request.getName());
            restaurantInfo.setContactDetails(request.getContactDetails());
            restaurantInfo.setLogoUrl(request.getLogoUrl());
            restaurantInfo.setAddress(request.getAddress());
            RestaurantInfo saved = restaurantInfoRepo.save(restaurantInfo);

            return ResponseEntity.ok().body(saved);
        }
        return  ResponseEntity.ok().body("restaurant not found");

        }



    }

