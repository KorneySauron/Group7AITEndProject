package de.ait.group7aitendproject.security.details;

import de.ait.group7aitendproject.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AuthenticatedUsersService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return new AuthenticatedUser(
                usersRepository.findByName(name)
                        .orElseThrow(() ->
                                new UsernameNotFoundException("User with email <" + name + "> not found ")));
    }
}
