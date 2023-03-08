package zw.co.afrosoft.security.mapper;

import javax.annotation.processing.Generated;
import zw.co.afrosoft.model.Customer;
import zw.co.afrosoft.model.Restaurant;
import zw.co.afrosoft.model.User;
import zw.co.afrosoft.security.dto.AuthenticatedUserDto;
import zw.co.afrosoft.security.dto.RegistrationRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-08T11:55:41+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User convertToUser(RegistrationRequest registrationRequest) {
        if ( registrationRequest == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( registrationRequest.getName() );
        user.lastname( registrationRequest.getLastname() );
        user.username( registrationRequest.getUsername() );
        user.password( registrationRequest.getPassword() );
        user.email( registrationRequest.getEmail() );

        return user.build();
    }

    @Override
    public User convertToUser(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( restaurant.getId() );
        user.name( restaurant.getName() );
        user.lastname( restaurant.getLastname() );
        user.username( restaurant.getUsername() );
        user.password( restaurant.getPassword() );
        user.email( restaurant.getEmail() );

        return user.build();
    }

    @Override
    public AuthenticatedUserDto convertToAuthenticatedUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        AuthenticatedUserDto authenticatedUserDto = new AuthenticatedUserDto();

        authenticatedUserDto.setName( user.getName() );
        authenticatedUserDto.setUsername( user.getUsername() );
        authenticatedUserDto.setPassword( user.getPassword() );
        authenticatedUserDto.setUserRole( user.getUserRole() );

        return authenticatedUserDto;
    }

    @Override
    public User convertToUser(AuthenticatedUserDto authenticatedUserDto) {
        if ( authenticatedUserDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( authenticatedUserDto.getName() );
        user.lastname(authenticatedUserDto.getLastname());
        user.userType(authenticatedUserDto.getUserType());
        user.customer(authenticatedUserDto.getCustomer());
        user.restaurant(authenticatedUserDto.getRestaurantUser());
        user.email(authenticatedUserDto.getEmail());
        user.username( authenticatedUserDto.getUsername() );
        user.password( authenticatedUserDto.getPassword() );
        user.userRole( authenticatedUserDto.getUserRole() );

        return user.build();
    }

    @Override
    public User convertToUser(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( customer.getId() );
        user.name( customer.getName() );
        user.lastname( customer.getLastname() );
        user.username( customer.getUsername() );
        user.password( customer.getPassword() );
        user.email( customer.getEmail() );

        return user.build();
    }
}
