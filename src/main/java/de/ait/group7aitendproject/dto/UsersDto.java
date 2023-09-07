package de.ait.group7aitendproject.dto;

import de.ait.group7aitendproject.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDto {

    private List<UserDto> students;
}
