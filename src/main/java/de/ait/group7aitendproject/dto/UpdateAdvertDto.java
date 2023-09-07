package de.ait.group7aitendproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateAdvertDto {

    private String description;

    @NotBlank
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in the format YYYY-MM-DD")
    @Schema(example = "2023-02-02")
    private String startDate;

    @NotBlank
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in the format YYYY-MM-DD")
    @Schema(example = "2023-03-02")
    private String finishDate;
}
