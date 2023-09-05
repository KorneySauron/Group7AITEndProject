package de.ait.group7aitendproject.repositories;

import de.ait.group7aitendproject.models.Advert;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdvertsRepository extends JpaRepository<Advert, Long> {
}
