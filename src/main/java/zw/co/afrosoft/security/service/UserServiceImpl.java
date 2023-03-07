package zw.co.afrosoft.security.service;

import zw.co.afrosoft.model.*;
import zw.co.afrosoft.repository.CustomerRepo;
import zw.co.afrosoft.repository.RestaurantRepo;
import zw.co.afrosoft.repository.UserRepository;
import zw.co.afrosoft.security.dto.AuthenticatedUserDto;
import zw.co.afrosoft.security.dto.RegistrationRequest;
import zw.co.afrosoft.security.dto.RegistrationResponse;
import zw.co.afrosoft.security.mapper.UserMapper;
//import zw.co.afrosoft.service.UserValidationService;
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
			restaurant.setLastname(restaurant.getLastname());
			restaurant.setName(restaurant.getName());
			Restaurant saved =  restaurantRepo.save(restaurant);
			final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setUserRole(UserRole.ADMIN);
			user.setUserType(UserType.Restaurant);
			user.setRestaurant(saved);


			userRepository.save(user);

			final String username = registrationRequest.getUsername();
			final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

			log.info("{} registered successfully!", username);

			return new RegistrationResponse(user);
		}
		Customer customer = new Customer();

		customer.setEmail(registrationRequest.getEmail());
		customer.setPassword(registrationRequest.getPassword());
		customer.setUsername(registrationRequest.getUsername());
		customer.setName(registrationRequest.getName());
		customer.setLastname(registrationRequest.getLastname());
		Customer SavedCustomer = customerRepo.save(customer);


		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.USER);
		user.setUserType(UserType.Customer);
		user.setCustomer(SavedCustomer);


		userRepository.save(user);

		final String username = registrationRequest.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(user);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}
}
