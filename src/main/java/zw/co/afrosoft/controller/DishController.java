package zw.co.afrosoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.model.MenuRequest;
import zw.co.afrosoft.security.service.DishService;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;

    @GetMapping("/get-dish/{id}")
    ResponseEntity getDish(@PathVariable Long id){
        return dishService.getDish(id);
    }

    @GetMapping("/get-menu")
    ResponseEntity getAllDishes(){
        return dishService. getAllDishes();
    }

    @DeleteMapping("/delete-dish/{id}")
    ResponseEntity delete(@PathVariable Long id){
        return dishService.delete(id);
    }

    @PostMapping("/create-menu")
    ResponseEntity addDish(@RequestBody MenuRequest request){
        return dishService.addDish(request);

    }


}
