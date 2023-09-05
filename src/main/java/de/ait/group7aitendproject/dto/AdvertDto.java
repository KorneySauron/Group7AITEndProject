package de.ait.group7aitendproject.dto;

import de.ait.group7aitendproject.models.Advert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvertDto {

    private Long id;

    private String title;

    private String description;

    private String startDate;

    private String finishDate;

    public static AdvertDto from(Advert advert) {
        AdvertDto result =  builder()
                .id(advert.getId())
                .title(advert.getTitle())
                .description(advert.getDescription())
                .build();

        if (advert.getStartDate() != null) {
            result.setStartDate(advert.getStartDate().toString());
        }

        if (advert.getFinishDate() != null) {
            result.setFinishDate(advert.getFinishDate().toString());
        }

        return result;
    }

    public static List<AdvertDto> from(List<Advert> courses) {
        return courses.stream()
                .map(AdvertDto::from)
                .collect(Collectors.toList());
    }

}
