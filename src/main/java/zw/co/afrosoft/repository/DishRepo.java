package zw.co.afrosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.model.Dish;

public interface DishRepo extends JpaRepository<Dish,Long> {

}
