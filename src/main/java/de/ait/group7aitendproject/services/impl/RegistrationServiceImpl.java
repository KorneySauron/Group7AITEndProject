package de.ait.group7aitendproject.services.impl;

import de.ait.group7aitendproject.dto.RegisterDto;
import de.ait.group7aitendproject.dto.UserDto;
import de.ait.group7aitendproject.models.User;
import de.ait.group7aitendproject.repositories.UsersRepository;
import de.ait.group7aitendproject.services.RegistrationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static de.ait.group7aitendproject.dto.UserDto.from;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

    UsersRepository usersRepository;

    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public UserDto register(RegisterDto registerData) {
        User user = User.builder()
                .hashPassword(passwordEncoder.encode(registerData.getPassword()))
                .role(User.Role.FREELANCER)
                .state(User.State.CONFIRMED).build();

        usersRepository.save(user);

        return from(user);
    }
}