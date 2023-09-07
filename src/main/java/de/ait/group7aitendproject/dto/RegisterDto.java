package de.ait.group7aitendproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;


@Data
public class RegisterDto {

    @Schema(description = "Имя пользователя", example = "Korney Saushkin")
    @NotNull
    @NotBlank
    private String name;

    @Schema(description = "Пароль пользователя", example = "qwerty007")
    @NotBlank
    @Size(min = 7, max = 1000)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Weak password")
    private String password;

}
