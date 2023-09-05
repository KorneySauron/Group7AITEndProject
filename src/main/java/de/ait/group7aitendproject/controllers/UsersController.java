package de.ait.group7aitendproject.controllers;

import de.ait.group7aitendproject.controllers.api.UsersApi;
import de.ait.group7aitendproject.dto.UserDto;
import de.ait.group7aitendproject.security.details.AuthenticatedUser;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    UsersService usersService;

    @Override
    public ResponseEntity<UserDto> getMyProfile(AuthenticatedUser currentUser) {
        Long userId = currentUser.id();
        return ResponseEntity.ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> deleteMyProfile(AuthenticatedUser currentUser) {
        Long userId = currentUser.id();
        return ResponseEntity.ok(usersService.deleteUser(userId));
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long userId) {
        return ResponseEntity.ok(usersService.deleteUser(userId));
    }

}
