package de.ait.group7aitendproject.services;

import de.ait.group7aitendproject.dto.*;

public interface AdvertsService {
    AdvertDto addAdvert(NewAdvertDto newAdvert);

    AdvertDto updateAdvert(Long courseId, UpdateAdvertDto newAdvert);


    AdvertDto getAdvert(Long advertId);

    AdvertsDto getAdverts();

}
