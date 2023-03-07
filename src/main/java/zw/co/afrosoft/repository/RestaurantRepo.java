package zw.co.afrosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.model.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Long> {
}
