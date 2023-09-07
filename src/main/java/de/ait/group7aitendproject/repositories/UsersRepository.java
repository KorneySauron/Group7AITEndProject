package de.ait.group7aitendproject.repositories;

import de.ait.group7aitendproject.models.Advert;
import de.ait.group7aitendproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    @Query("select user from User user where user.role = 'FREELANCER' and :advert not member of user.adverts")
    List<User> findStudentsNotInCourse(@Param("advert") Advert advert);

    boolean existsByRole(User.Role role);
}
