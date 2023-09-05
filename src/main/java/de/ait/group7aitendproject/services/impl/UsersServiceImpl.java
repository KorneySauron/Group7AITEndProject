package de.ait.group7aitendproject.services.impl;

import de.ait.group7aitendproject.dto.UserDto;
import de.ait.group7aitendproject.dto.UsersDto;
import de.ait.group7aitendproject.handler.RestException;
import de.ait.group7aitendproject.models.Advert;
import de.ait.group7aitendproject.models.User;
import de.ait.group7aitendproject.repositories.AdvertsRepository;
import de.ait.group7aitendproject.repositories.UsersRepository;
import de.ait.group7aitendproject.security.details.AuthenticatedUser;
import de.ait.group7aitendproject.services.UsersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static de.ait.group7aitendproject.dto.UserDto.from;


@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;
    AdvertsRepository advertsRepository;

    @Override
    public UserDto getUser(Long userId) {
        return from(getUserOrThrow(userId));
    }



    @Transactional
    @Override
    public UserDto deleteUser(Long userId) {
        User user = getUserOrThrow(userId);

        user.setState(User.State.DELETED);

        if (user.getRole().equals(User.Role.FREELANCER)) {
            user.getAdverts().clear();
        }

        usersRepository.save(user);

        logoutIfNecessary(userId);

        return from(user);
    }

    private void logoutIfNecessary(Long userIdForLogout) {
        // объект аутентификации текущего пользователя
        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken)SecurityContextHolder.getContext().getAuthentication());
        // нашли текущего пользователя по email
        User currentUser = usersRepository.findByName(token.getName()).orElseThrow();
        // если мы удаляем себя
        if (currentUser.getId().equals(userIdForLogout)) {
            // завершаем свою сессию
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }

    User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new RestException(HttpStatus.NOT_FOUND, "User with id <" + userId + "> not found"));
    }
}