package zw.co.afrosoft.security.dto;

import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.model.Restaurant;
import zw.co.afrosoft.model.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zw.co.afrosoft.model.UserType;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

	private String name;
	private String lastname;
	private Restaurant restaurantUser;
	private Customer customer;
	private String email;
	private UserType userType;
	private String username;
	private String password;
	private UserRole userRole;

}
