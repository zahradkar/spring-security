package com.workshop.martin.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AppUserDTO(
		@NotBlank
		@Size(min = 4, max = 30)
		String username,
		@NotNull
		@Size(min = 8, max = 30)
		@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
		String password

) {
}
