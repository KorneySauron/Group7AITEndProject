package de.ait.group7aitendproject.controllers.api;
import de.ait.group7aitendproject.dto.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/Adverts")
@Tags(value =
@Tag(name = "Adverts")
)
public interface AdvertsApi {
    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @PostMapping
    ResponseEntity<AdvertDto> addAdvert(@RequestBody @Valid NewAdvertDto newAdvert);

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @PutMapping("/{advert-id}")
    ResponseEntity<AdvertDto> updateAdvert(@PathVariable("advert-id") Long advertId,
                                           @RequestBody @Valid UpdateAdvertDto updateAdvert);



    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{advert-id}")
    ResponseEntity<AdvertDto> getAdvert(@PathVariable("advert-id") Long advertId);

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    ResponseEntity<AdvertsDto> getAdverts();
}
