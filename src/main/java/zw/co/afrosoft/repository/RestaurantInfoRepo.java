package zw.co.afrosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.model.RestaurantInfo;

public interface RestaurantInfoRepo extends JpaRepository<RestaurantInfo, Long> {
}
