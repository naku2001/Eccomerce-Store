package zw.co.afrosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.afrosoft.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
