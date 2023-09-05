package de.ait.group7aitendproject.services;

import de.ait.group7aitendproject.dto.UserDto;
import de.ait.group7aitendproject.dto.UsersDto;


public interface UsersService {
    UserDto getUser(Long userId);


    UserDto deleteUser(Long userId);
}
