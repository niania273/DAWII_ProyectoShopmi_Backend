package pe.edu.alicorp.serviceauthentication.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class LoginDTO {
    @Email @NotBlank private String email;
    @NotBlank private String password;
}