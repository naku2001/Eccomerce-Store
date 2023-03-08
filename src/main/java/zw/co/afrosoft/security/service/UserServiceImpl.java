package zw.co.afrosoft.security.service;

import org.springframework.http.ResponseEntity;
import zw.co.afrosoft.model.*;
import zw.co.afrosoft.repository.CustomerRepo;
import zw.co.afrosoft.repository.RestaurantRepo;
import zw.co.afrosoft.repository.UserRepository;
import zw.co.afrosoft.security.dto.AuthenticatedUserDto;
import zw.co.afrosoft.security.dto.RegistrationRequest;
import zw.co.afrosoft.security.dto.RegistrationResponse;
import zw.co.afrosoft.security.mapper.UserMapper;
//import zw.co.afrosoft.service.UserValidationService;
import zw.co.afrosoft.service.UserService;
import zw.co.afrosoft.utils.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	private final RestaurantRepo restaurantRepo;
	private final CustomerRepo customerRepo;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);
		if(registrationRequest.getUsertype().startsWith("R")){
			Restaurant restaurant = new Restaurant();

			restaurant.setEmail(registrationRequest.getEmail());
			restaurant.setPassword(registrationRequest.getPassword());
			restaurant.setUsername(registrationRequest.getUsername());
			restaurant.setLastname(registrationRequest.getLastname());
			restaurant.setName(registrationRequest.getName());
			Restaurant saved =  restaurantRepo.save(restaurant);
			final User users = UserMapper.INSTANCE.convertToUser(saved);
			users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
			users.setUserRole(UserRole.ADMIN);
			users.setUserType(UserType.Restaurant);
			users.setRestaurant(saved);
			userRepository.save(users);
			final String username = registrationRequest.getUsername();
			log.info("{} registered successfully!", username);
			return new RegistrationResponse(users);
		}
		Customer customer = new Customer();

		customer.setEmail(registrationRequest.getEmail());
		customer.setPassword(registrationRequest.getPassword());
		customer.setUsername(registrationRequest.getUsername());
		customer.setName(registrationRequest.getName());
		customer.setLastname(registrationRequest.getLastname());
		Customer save= customerRepo.save(customer);


		final User user = UserMapper.INSTANCE.convertToUser(save);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.USER);
		user.setUserType(UserType.Customer);
		user.setCustomer(save);
		userRepository.save(user);
		final String username = registrationRequest.getUsername();

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(user);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}

	@Override
	public ResponseEntity findAll() {
		return null;
	}
}
