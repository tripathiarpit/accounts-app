package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Address",
        description = "Schema to hold Customer Address information"
)
public class AddressDto {

    @Schema(description = "Street address", example = "123 Main Street")
    @NotEmpty(message = "Street cannot be empty")
    private String street;

    @Schema(description = "City name", example = "New York")
    @NotEmpty(message = "City cannot be empty")
    private String city;

    @Schema(description = "State name", example = "NY")
    @NotEmpty(message = "State cannot be empty")
    @Size(min = 2, max = 2, message = "State should be a valid 2-letter code")
    private String state;

    @Schema(description = "Zip code", example = "10001")
    @NotEmpty(message = "Zip code cannot be empty")
    @Size(min = 5, max = 6, message = "Zip code should be 5 or 6 digits")
    private String zipCode;

    @Schema(description = "Country name", example = "USA")
    @NotEmpty(message = "Country cannot be empty")
    private String country;
}
