package com.sportfemme.en_avant_toutes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
public class UserRegisterDTO {
    @NotBlank(message = "Name is required")
    private String username;
/* 
    @Email(message = "Invalid email format")
    private String email;
*/
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

}
