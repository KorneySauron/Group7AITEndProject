package de.ait.group7aitendproject.services.impl;

import de.ait.group7aitendproject.dto.*;
import de.ait.group7aitendproject.handler.RestException;
import de.ait.group7aitendproject.models.Advert;
import de.ait.group7aitendproject.models.User;
import de.ait.group7aitendproject.repositories.AdvertsRepository;
import de.ait.group7aitendproject.repositories.UsersRepository;
import de.ait.group7aitendproject.services.AdvertsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;

import static de.ait.group7aitendproject.dto.AdvertDto.from;
import static de.ait.group7aitendproject.dto.UserDto.from;


@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Service
public class AdvertsServiceImpl implements AdvertsService {

    AdvertsRepository advertsRepository;

    UsersRepository usersRepository;

    UsersServiceImpl usersService;

    @Transactional
    @Override
    public AdvertDto addAdvert(NewAdvertDto newAdvert) {
        Advert advert = Advert.builder()
                .startDate(LocalDate.parse(newAdvert.getStartDate()))
                .finishDate(LocalDate.parse(newAdvert.getFinishDate()))
                .title(newAdvert.getTitle())
                .description(newAdvert.getDescription())
                .build();

        advertsRepository.save(advert);

        return from(advert);
    }

    @Transactional
    @Override
    public AdvertDto updateAdvert(Long advertId, UpdateAdvertDto updateAdvert) {

        Advert advert = getAdvertOrThrow(advertId);

        advert.setDescription(updateAdvert.getDescription());

        if (updateAdvert.getStartDate() != null) {
            advert.setStartDate(LocalDate.parse(updateAdvert.getStartDate()));
        }

        if (updateAdvert.getFinishDate() != null) {
            advert.setFinishDate(LocalDate.parse(updateAdvert.getFinishDate()));
        }

        advertsRepository.save(advert);

        return from(advert);
    }

    @Override
    public AdvertDto getAdvert(Long advertId) {
        return from(getAdvertOrThrow(advertId));
    }

    @Override
    public AdvertsDto getAdverts() {
        return AdvertsDto.builder()
                .adverts(from(advertsRepository.findAll()))
                .build();
    }
    Advert getAdvertOrThrow(Long advertId) {
        return advertsRepository.findById(advertId).orElseThrow(
                () -> new RestException(HttpStatus.NOT_FOUND, "Course with id <" + advertId + "> not found"));
    }

}