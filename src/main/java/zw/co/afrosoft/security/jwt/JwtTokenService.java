package zw.co.afrosoft.security.jwt;

import zw.co.afrosoft.model.User;
import zw.co.afrosoft.repository.UserRepository;
import zw.co.afrosoft.security.dto.AuthenticatedUserDto;
import zw.co.afrosoft.security.dto.LoginRequest;
import zw.co.afrosoft.security.dto.LoginResponse;
import zw.co.afrosoft.security.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import zw.co.afrosoft.service.UserService;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {
	private final UserRepository userRepository;

	private final UserService userService;

	private final JwtTokenManager jwtTokenManager;

	private final AuthenticationManager authenticationManager;

	public LoginResponse getLoginResponse(LoginRequest loginRequest) {

		final String username = loginRequest.getUsername();
		final String password = loginRequest.getPassword();

		final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		final AuthenticatedUserDto authenticatedUserDto = userService.findAuthenticatedUserByUsername(username);

		final User user = UserMapper.INSTANCE.convertToUser(authenticatedUserDto);


		final String token = jwtTokenManager.generateToken(user);


		log.info("{} has successfully logged in!", user.getUsername());

		return new LoginResponse(token,user);
	}

}
