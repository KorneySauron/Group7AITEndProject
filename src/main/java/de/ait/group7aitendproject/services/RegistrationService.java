package de.ait.group7aitendproject.services;

import de.ait.group7aitendproject.dto.RegisterDto;
import de.ait.group7aitendproject.dto.UserDto;


public interface RegistrationService {
    UserDto register(RegisterDto registerData);
}
