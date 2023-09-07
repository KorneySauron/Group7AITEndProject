package de.ait.group7aitendproject.controllers;

import de.ait.group7aitendproject.controllers.api.AdvertsApi;
import de.ait.group7aitendproject.dto.*;
import de.ait.group7aitendproject.services.AdvertsService;
import de.ait.group7aitendproject.models.Advert;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class AdvertsController implements AdvertsApi {

    AdvertsService advertsService;

    @Override
    public ResponseEntity<AdvertDto> addAdvert(NewAdvertDto newAdvert) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(advertsService.addAdvert(newAdvert));
    }

    @Override
    public ResponseEntity<AdvertDto> updateAdvert(Long advertId, UpdateAdvertDto updateAdvert) {
        return ResponseEntity
                .ok()
                .body(advertsService.updateAdvert(advertId, updateAdvert));
    }

    @Override
    public ResponseEntity<AdvertDto> getAdvert(Long advertId) {
        return ResponseEntity
                .ok()
                .body(advertsService.getAdvert(advertId));
    }

    @Override
    public ResponseEntity<AdvertsDto> getAdverts() {
        return ResponseEntity
                .ok()
                .body(advertsService.getAdverts());
    }
}
