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
    ResponseEntity<AdvertDto> addAdvert(@RequestBody @Valid NewAdvertDto newCourse);

    @PreAuthorize("hasAnyAuthority('MANAGER', 'ADMIN')")
    @PutMapping("/{course-id}")
    ResponseEntity<AdvertDto> updateAdvert(@PathVariable("advert-id") Long courseId,
                                           @RequestBody @Valid UpdateAdvertDto updateCourse);



    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{course-id}")
    ResponseEntity<AdvertDto> getAdvert(@PathVariable("advert-id") Long advertId);

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    ResponseEntity<AdvertsDto> getAdverts();
}
