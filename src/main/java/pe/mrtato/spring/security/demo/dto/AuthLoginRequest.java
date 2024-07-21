package pe.mrtato.spring.security.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(
		@NotBlank String username,
		@NotBlank String password
		) {

}
