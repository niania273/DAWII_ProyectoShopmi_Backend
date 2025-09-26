package pe.edu.alicorp.serviceauthentication.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class RegisterDTO {
    // CLIENTE
    @NotBlank private String razonSocial;
    @NotBlank private String nroDoc;
    @Email private String corCliente;

    // USUARIO
    @NotBlank private String apeUsuario;
    @NotBlank private String nomUsuario;
    @NotNull  private LocalDate fecNac;
    @Pattern(regexp = "[MF]") private String sexUsuario;
    @Pattern(regexp = "\\d{9}") private String telUsuario;
    @Email @NotBlank private String corUsuario;
    @NotBlank private String password;
}