package chordax_dev_team.chordax_registration.model;

import chordax_dev_team.chordax_registration.service.UserEmailStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "The user model have necessary data for registration or/and logging in the service.")
@Entity(name = "app_user") // name added because let 'user' only as class name, would cause H2 get crashed
							// since 'user' is keyword in H2
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Schema(nullable = false, description = "Autogenerated user's Id number.")
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Schema(nullable = true, description = "Optional user's name.")
	@Column
	private String userName;

	@Schema(nullable = false, description = "Mandatory user's email address.")
	@Column
	private String email;

	@Schema(nullable = false, description = "Mandatory user's password.")
	@Column
	private String password;

	@Schema(nullable = false, description = "Status of user's email confirmation.")
	@Enumerated(EnumType.STRING)
	private UserEmailStatus emailStatus = UserEmailStatus.NOT_CONFIRMED;

}