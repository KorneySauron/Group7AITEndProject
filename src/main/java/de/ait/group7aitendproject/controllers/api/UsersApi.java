package de.ait.group7aitendproject.controllers.api;


import de.ait.group7aitendproject.dto.StandardResponseDto;
import de.ait.group7aitendproject.dto.UserDto;
import de.ait.group7aitendproject.dto.UsersDto;
import de.ait.group7aitendproject.security.details.AuthenticatedUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/users")
@Tags(value =
@Tag(name = "Users")
)
public interface UsersApi {

    @Operation(summary = "Получение профиля", description = "Доступно аутентифицированным пользователям. Позволяет получить текущего пользователя на основе объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Профиль пользователя",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    }),
            @ApiResponse(responseCode = "401", description = "Пользователь не аутентифицирован",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
                    })
    })
    @GetMapping("/me")
    ResponseEntity<UserDto> getMyProfile(@Parameter(hidden = true) @AuthenticationPrincipal AuthenticatedUser currentUser);

    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/me")
    ResponseEntity<UserDto> deleteMyProfile(@Parameter(hidden = true) @AuthenticationPrincipal AuthenticatedUser current);

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{user-id}")
    ResponseEntity<UserDto> deleteUser(@PathVariable("user-id") Long userId);

}
