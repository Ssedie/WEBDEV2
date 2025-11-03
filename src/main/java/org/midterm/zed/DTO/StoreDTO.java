package org.midterm.zed.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record StoreDTO(

        @NotBlank(message = "Name is Required")
        String name,

        @NotBlank(message = "Description is Required")
        String description,

        @Min(1)
        int stock,

        @NotBlank(message = "Unit is Required")
        String unit,

        @NotBlank(message = "Price is Needed")
        @Min(1)
        double price

    ) {
}
