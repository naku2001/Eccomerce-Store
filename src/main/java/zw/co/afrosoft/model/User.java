package zw.co.afrosoft.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String lastname;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
	@OneToOne
	private Restaurant restaurant;
	@OneToOne
	private Customer customer;
	@Enumerated(EnumType.STRING)
	private UserType userType;


}
